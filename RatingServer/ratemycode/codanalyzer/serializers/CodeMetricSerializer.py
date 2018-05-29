from rest_framework import serializers
from rest_framework.authtoken.models import Token
from django.contrib.auth.password_validation import validate_password
from rest_framework.views import APIView

class CodeMetric


class CodeMetricSerializer(serializers.ModelSerializer):
	class Meta:
		model = CodeMetricModel
		fields = ('userid', 'qid', 'filename', 'codesnippet', 'qdetail', 'input', 'output', 'timestamp')

	@staticmethod
	def get_