import psycopg2
import operator
from elo import Elo
from collections import defaultdict
from psycopg2.extras import execute_values


global env
env = Elo(k_factor=10,initial=1500)

def initConnection():
	try:
	    global conn
	    conn = psycopg2.connect("dbname='ratemycode' user='mmgehlot' host='localhost' password='@root.21'")
	    print(conn)
	    return conn
	except:
	    print("Error while connecting database")
	    return None

def getAllRating():
	cur = conn.cursor()
	cur.execute("select * from rating_rating")
	rows = cur.fetchall()
	d = defaultdict(list)

	for row in rows:
		d[str(row[4])].append(row[0])

	print(d)
	return d

def updateRank(rating):
	cur = conn.cursor()
	update_query = "update rating_rating as t set rank=e.r from (values %s) as e (r,u) where t.user = e.u;"
	execute_values(cur, update_query,rating)
	conn.commit()

def calculateRating():
	d = getAllRating()
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
		print(record[1])
		if record[1] < prev:
			i=i+1
		rating.append((i,record[0]))
		prev = record[1]

	print(rating)
	return(rating)
	
if __name__ == '__main__':
	initConnection()
	rating = calculateRating()
	updateRank(rating)