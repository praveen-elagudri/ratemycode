from rest_framework import serialzers
from django.contrib.auth.models import User
from authentication.models import Profile

class AuthSerializer(serialzers.ModelSerializer):
	class Meta:
		model = User
		fields = ("id","user","location","url","job_title")
		