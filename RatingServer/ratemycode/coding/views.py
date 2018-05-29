from django.shortcuts import render
from django.contrib.auth.decorators import login_required

# Create your views here.

@login_required
def coding(request):
    return render(request,'coding/takeCodingChalenge.html')

@login_required
def codingChallenge(request):
    return render(request,'coding/challenge_list.html')

@login_required
def problem(request):
    return render(request,'coding/problems.html')



