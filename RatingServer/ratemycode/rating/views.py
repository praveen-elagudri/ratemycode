import json
from django.contrib.auth.decorators import login_required
from ratemycode.rating.models import Rating
from rest_framework.views import APIView
from rest_framework.response import Response

# @login_required
class UserRating(APIView):
	@staticmethod
	def post(request):
		body = request.body.decode('utf-8')
		body = json.loads(body)

		user = body["user"]
		# user = request.POST.get("user")
		print(user)
		print("inside user rating")
		# user = 'mmgehlot'
		R = Rating()
		result = R.get_user_rating(user)
		print(result)
		return Response(result)		

class AllRating(APIView):
	@staticmethod
	def post(request):
		R = Rating()
		result = R.get_all_rating()
		return Response({'all' : list(result)})

