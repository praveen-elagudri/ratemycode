import pickle
import os
from django.shortcuts import render
from django.shortcuts import get_object_or_404
from django.contrib.auth import authenticate
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status


cur_path = os.getcwd()
model_file = cur_path + "/ratemycode/codanalyzer/model_GNB.pkl"

global model

with open(model_file, 'rb') as file:
	model = pickle.load(file)

# Create your views here.
class Predict(APIView):

	@staticmethod
	def get(request):
		X_test = [[]]
		result = model.predict(X_test)
		
		for i in range(len(result)):
			r = result[i]
			if r=="False":
				result[i] = "True"
			if r=="True":
				result[i] = "False"

		return Response({"result" : result})
