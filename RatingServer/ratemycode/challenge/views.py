import os
import json
import time

import psycopg2
import operator
from elo import Elo
from collections import defaultdict
from psycopg2.extras import execute_values

from ratemycode import leetcode
# from ratemycode.ratingEngine import CalculateRating
from django.shortcuts import render
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from kafka import KafkaProducer
from radon.raw import analyze
from radon.metrics import h_visit
from radon.metrics import mi_parameters
from ratemycode.challenge.models import Submissions
from ratemycode.rating.models import Rating
from django.core.exceptions import ObjectDoesNotExist

from django.contrib.auth.decorators import login_required


# producer = KafkaProducer(value_serializer = lambda v: json.dumps(v).encode('utf-8'),
# 			bootstrap_servers='54.183.195.208:9092')

keys = ["loc","cc","n","volume","prolength","difficulty","effort","bug",
    "time_est","lOCode","lOComment","lOBlank","lOCodeAndComment",
    "uniq_Op","uniq_Opnd","total_Op","total_Opnd"]


global env
global conn
env = Elo(k_factor=10,initial=1500)

try:
    conn = psycopg2.connect("dbname='ratemycode' user='mmgehlot' host='localhost' password='@root.21'")
    print("Connected to database successfully")
except:
    print("Error while connecting database")


def CalculateRating():

	try:
		cur = conn.cursor()
		cur.execute("select * from rating_rating")
		rows = cur.fetchall()
		d = defaultdict(list)

		for row in rows:
			d[str(row[4])].append(row[0])

		scores = [int(key) for (key,value) in sorted(d.items())]
		temp = [i for i in scores]
		new_d = {}

		for i in range(len(scores)):
			new_rating = scores[i]
			temp.remove(scores[i])
			for j in range(len(temp)):
				new_rating = env.rate_1vs1(new_rating,scores[i])
				new_rating = new_rating[0]

			temp.append(scores[i])

			for i in d[str(scores[i])]:
				new_d[i] = round(new_rating)

		sorted_d = sorted(new_d.items(), key=operator.itemgetter(1),reverse=True)
		
		i=1
		rating = []
		prev = -1
		for record in sorted_d:
			if record[1] < prev:
				i=i+1
			rating.append((i,record[0]))
			prev = record[1]

		
		print(rating)
		cur.close()


		qStr = "update rating_rating as t set rank = e.r from (values "

		qParam = []

		for r in rating:
			qStr += "(%s,%s),"
			qParam.extend([r[0],r[1]])
		
		qStr = qStr[:-1]
		qStr += " ) as e(r,u) where t.user = e.u;"

		cur = conn.cursor()
		cur.execute(qStr,qParam)
		print(cur.rowcount)
		conn.commit()
		cur.close()

		# cur = conn.cursor()
		# update_query = "update rating_rating as t set rank=e.r from (values %s) as e (r,u) where t.user = e.u;"
		# execute_values(cur, update_query,rating)
		# cur.execute("select * from rating_rating")
		# rows = cur.fetchall()
		# for row in rows:
		# 	print(row)
			
		# conn.commit()
		print("Rank updated")

	except Exception as ex:
		error = {}
		error["type"] = "system error"
		error["name"] = type(ex).__name__
		error["detail"] = ex.args
		print(error)

def collect_metrics(code):
	d = {key:None for key in keys}
	content = h_visit(code)
	d["uniq_Op"] = content.h1
	d["uniq_Opnd"] = content.h2
	d["total_Op"] = content.N1
	d["total_Opnd"] = content.N2
	d["n"] = float(content.N1) + float(content.N2)
	d["volume"] = content.volume
	d["prolength"] = content.length
	d["difficulty"] = content.difficulty
	d["effort"] = content.effort
	d["bug"] = content.bugs
	d["time_est"] = content.time

	content = analyze(code)
	d["loc"] = content.loc
	d["lOCode"] = content.loc
	d["lOComment"] = content.comments
	d["lOBlank"] = content.blank
	d["lOCodeAndComment"] = float(content.loc) + float(content.comments)

	content = mi_parameters(code)
	d["cc"] = content[1]

	return d

def history(record):
	print(record)
	submission = Submissions.objects.create()
	submission.user = record["user"]
	submission.question = record["question"]
	submission.qid = record["qid"]
	submission.category = record["category"]
	submission.status = record["status"]
	submission.runtime = record["runtime"]
	submission.code = record["code"]
	submission.metrics = record["metrics"]
	submission.quality = record["quality"]

	submission.save()

	try:
		rs = Rating.objects.get(user=record["user"])
		if record["category"] == "Easy":
			rs.easy = rs.easy + 1
			rs.rating = rs.rating + 5

		if record["category"] == "Medium":
			rs.medium = rs.medium + 1
			rs.rating = rs.rating + 10

		if record["category"] == "Hard":
			rs.hard = rs.hard + 1
			rs.rating = rs.rating + 15
		
		rs.save()
		print("Record for {} has been updated".format(record["user"]))

	except ObjectDoesNotExist:
		rs = Rating.objects.create(user=record["user"])
		rs.save()
		print("New rating record has created for {}".format(record["user"]))
		rs = Rating.objects.get(user=record["user"])
		if record["category"] == "Easy":
			rs.easy = rs.easy + 1
			rs.rating = rs.rating + 5

		if record["category"] == "Medium":
			rs.medium = rs.medium + 1
			rs.rating = rs.rating + 10

		if record["category"] == "Hard":
			rs.hard = rs.hard + 1
			rs.rating = rs.rating + 15
		
		rs.save()
		print("Record for {} has been updated".format(record["user"]))


class GetSubmissions(APIView):
	@staticmethod
	def get(request):
		# body = request.body.decode('utf-8')
		# body = json.loads(body)
		# user = body["user"]
		print("Submission")
		user=request.user
		result = Submissions.get_user_submissions(user)
		return Response(result)

# @login_required
class AllProblems(APIView):
	@staticmethod
	def get(request):
		# if request.user.is_authenticated():
		# if leetcode.login(request.user):
		# print("Hit")
		d = leetcode.get_all_problems()
		# d = json.dumps(d)
		# d = json.loads(d)
		# print(d)
		return Response(d, status=status.HTTP_200_OK)
		# return Response(status=status.HTTP_400_BAD_REQUEST)


# @login_required
class Problem(APIView):
	@staticmethod
	def get(request):
		# print(request)
		qid = request.GET.get("qid")
		print(qid)
		out = leetcode.get_problem(qid)
		return Response(out, status=status.HTTP_200_OK)
		# if request.user.is_authenticated():
		# 	if leetcode.login(request.user):
        # print(request)


		# return Response(status=status.HTTP_400_BAD_REQUEST)

# @login_required
class RunCode(APIView):
	@staticmethod
	def post(request):
		# if request.user.is_authenticated():
		try:
			# 	if leetcode.login(request.user):
			body = request.body.decode('utf-8')
			body = json.loads(body)

			code = body["editorContent"]
			filename = body["fileName"] 
			
			# metrics = collect_metrics(code)

			# d = {}
			# d["metrics"] = metrics
			# d["user"] = body["user"]
			# d["fileName"] = body["fileName"]
			# d["code"] = body["editorContent"]
			# d["tstamp"] = time.time()		

			# record = {}
			# record["user"] = body["user"]
			# record["qid"] = body["qid"]
			# record["question"] = body["qtitle"]
			# record["category"] = body["cat"]
			# record["runtime"] = "33ms"

			# # if res["isAccepted"] == "True":
			# record["status"] = "Accepted"
			# record["code"] = code
			# record["quality"] = "Good"
			# record["metrics"] = json.dumps(metrics)

			# history(record)
			print("Runcode hit")

			CalculateRating()
			return Response(leetcode.run_code(code,filename))
		# return Response(status=status.HTTP_400_BAD_REQUEST)
		except Exception as ex:
			error = {}
			error["type"] = "system error"
			error["name"] = type(ex).__name__
			error["detail"] = ex.args
			return Response(error)

# @login_required
class SubmitCode(APIView):
	@staticmethod
	def post(request):
		# if request.user.is_authenticated():
		# 	if leetcode.login(request.user):
		body = request.body.decode('utf-8')
		body = json.loads(body)
		
		isTested = body["isTested"]
		code = body["editorContent"]
		filename = body["fileName"] 
		user = body["user"]
		print(isTested)

		if isTested == "True":
			d = {}
			metrics = collect_metrics(code)
			d["metrics"] = metrics
			d["user"] = body["user"]
			d["fileName"] = body["fileName"]
			d["code"] = body["editorContent"]
			# d["tstamp"] = time.time()

			# print(d)
			# if isTested == "True":
				# body = json.dumps(body)
				# body = body.encode('utf-8')
			# producer.send('CodeSubmission',d)

			record = {}
			record["user"] = body["user"]
			record["qid"] = body["qid"]
			record["question"] = body["qtitle"]
			record["category"] = body["cat"]
			record["runtime"] = "33ms"
			
			res = leetcode.submit_code(isTested,code,filename)
			
			if res["isAccepted"] == "True":
				record["status"] = "Accepted"
				record["code"] = code
				record["quality"] = "Good"
				record["metrics"] = json.dumps(metrics)

				history(record)

				# CalculateRating()

				print(res)
				return Response(res)
			else:
				return Response({"result" : "False"})
		else:
			return Response({"result" : "False"})


		# return Response(status=status.HTTP_400_BAD_REQUEST)

@login_required
def ViewSubmissions(request):
    return render(request,'coding/submissions.html')