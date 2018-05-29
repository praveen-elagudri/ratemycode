from django.conf.urls import url
from .views import UserRating, AllRating

urlpatterns = [
	url(r'^$', UserRating.as_view()),
	url(r'^all/$', AllRating.as_view()),
]