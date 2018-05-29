from django.shortcuts import render
from django.contrib.auth.decorators import login_required

# Create your views here.

@login_required
def jobs(request):
    return render(request,'jobs/jobs.html')

@login_required
def singleJob(request):
    return render(request,'jobs/singleJob.html')


