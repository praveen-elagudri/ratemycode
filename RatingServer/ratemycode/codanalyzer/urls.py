from django.conf.urls import url
from .views import Predict

urlpatterns = [
	url(r'^analyze/$', Predict.as_view()),
]