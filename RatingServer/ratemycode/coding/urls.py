from django.conf.urls import url

from ratemycode.coding import views

urlpatterns = [
    url(r'^$', views.coding, name='start_coding'),
    url(r'^challenge/$', views.codingChallenge, name='take_challenge'),
    url(r'^problem/$', views.problem, name='problem'),
    ]