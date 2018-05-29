from django.conf.urls import url
from ratemycode.challenge import views
from .views import AllProblems, Problem, RunCode, SubmitCode, GetSubmissions

urlpatterns = [
	url(r'^all/$', AllProblems.as_view()),
	url(r'^problem/$', Problem.as_view()),
	url(r'^runcode/$', RunCode.as_view()),
	url(r'^submit/$', SubmitCode.as_view()),
	url(r'^submissions/$', GetSubmissions.as_view()),
	url(r'^viewsubmissions/$', views.ViewSubmissions,name="view_submissions"),
]