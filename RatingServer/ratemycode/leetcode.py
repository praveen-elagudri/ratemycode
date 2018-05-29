import os
import re

def login(user):
	return True

def logout():
	msg = os.popen("leetcode user -L").read()
	if "logout" in msg:
		return True

def check_login(user):
	l = os.popen("leetcode user").read()
	msg = l[:l.find(" ")]
	if msg == "[ERROR]":
		print("You are not logged in yet")
		return

	u = l[l.rfind(" "):].strip()
	if u == user:
		print("You are good to go")

def get_all_problems():
	out = os.popen("leetcode list").read()
	lst = out.split("\n")
	d = {}
	# d["all"] = {}
	for l in lst:
		qid = (l[:l.find("]")].strip())[1:]
		qid = qid.strip()
		if "[" in qid:
			qid = qid[qid.find("[")+1:]
			qid = qid.strip()
		
		if qid:
			d[qid] = {}
			s = l[l.find("]")+1:].strip()
			s = re.sub(' +',' ',s)
			s = s[:s.find("(")].strip()

			qtitle = s[:s.rfind(" ")]
			difficulty = s[s.rfind(" "):].strip()
			
			d[qid]["qtitle"] = qtitle 
			d[qid]["difficulty"]  = difficulty

		# d["qid"] = qid
		# d["qtitle"] = qtitle 
		# d["difficulty"]  = difficulty

	# print(d)	
	return d

def get_problem(qid):
	cur_path = os.getcwd()
	print(cur_path)
	os.chdir("ratemycode")
	os.chdir("problems")
	cmd = "leetcode show {} -g -l python3".format(qid)
	out = os.popen(cmd).read()
	lst = out.split("\n")
	flag=False
	qDetail = ""
	for l in lst:
		if flag:
			qDetail+=l + "\n"
		if "Source Code:" in l:
			tmp = l
		if "Testcase" in l:
			flag=True

	fileName = (tmp[tmp.find(":")+1:]).strip()
	fileContent = open(fileName,"r").read()

	cmd = "rm *.py"
	out = os.popen(cmd).read()

	d = {}
	d["detail"] = qDetail
	d["fileContent"] = fileContent
	d["fileName"] = fileName

	os.chdir(cur_path)
	return d

def submit_code(isTested, code, fileName):
	if isTested != "True":
		info = {"result" : "False"}
		return info

	cur_path = os.getcwd()
	os.chdir("ratemycode")
	os.chdir("problems")
	
	with open(fileName,'w') as f:
		f.write(code)
		f.close()

	cmd = "leetcode submit {}".format(fileName)
	out = os.popen(cmd).read()
	lst = out.split("\n")
	print(lst)
	d = {}
	if lst:
		if "Accepted" in lst[0]:
			d["isAccepted"] = "True"
			d["testCases"] = lst[1]
		else:
			d["isAccepted"] = "False"
	print(d)
	os.chdir(cur_path)
	return d

def run_code(code,fileName):
	cur_path = os.getcwd()
	os.chdir("ratemycode")
	os.chdir("problems")
	# code = code[1:-1]
	# code = code.split()
	with open(fileName,'w') as f:
		# for line in code:
		# 	print(line)
		f.write(code)
		f.close()

	cmd = "leetcode test {}".format(fileName)
	out = os.popen(cmd).read()
	lst = out.split("\n")
	
	if "session expired, please login again" in out:
		print("Please log in to leetcode")
		return

	print(out)

	d = {}
	d["actual"] = {}
	d["expected"] = {}

	for i in range(len(lst)):
		
		if "Input data:" in lst[i]:
			d["input"] = lst[i+1]
			d["output"] = lst[i+2]

		if "Actual" in lst[i]:
			if "Runtime Error" in lst[i+1] or "Compile Error" in lst[i+1]:
				d["actual"]["error"] = lst[i+5]
			else:
				d["actual"]["runtime"] = lst[i+1]
				d["actual"]["answer"] = lst[i+2]
				d["actual"]["stdout"] = lst[i+3]

		if "Expected" in lst[i]:
			d["expected"]["runtime"] = lst[i+1]
			d["expected"]["answer"] = lst[i+2]
			d["expected"]["stdout"] = lst[i+3]	

	cmd = "rm *.py"
	out = os.popen(cmd).read()
	os.chdir(cur_path)
	print(d)
	return d

if __name__ == '__main__':
	# get_all_problems()
	d = get_problem(1)
	print(d)
	code = """
        nums_hash = {}
        for i in range(len(nums)):
            if target - nums[i] in nums_hash: 
                return [nums_hash[target - nums[i]], i]
            nums_hash[nums[i]] = i
	"""
	code = d["fileContent"] + code
	run_code(code, d["fileName"])