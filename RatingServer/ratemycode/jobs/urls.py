from django.conf.urls import url

from ratemycode.jobs import views

urlpatterns = [
    url(r'^$', views.jobs, name='jobs'),
     url(r'^singleJob/$', views.singleJob, name='singleJob'),
    ]