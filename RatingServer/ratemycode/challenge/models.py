from django.db import models
from django.contrib.auth.models import User
from django.utils.encoding import python_2_unicode_compatible
# Create your models here.

@python_2_unicode_compatible
class Submissions(models.Model):
    # user = models.ForeignKey(User, on_delete=models.CASCADE)
    user = models.TextField(max_length=255)
    date = models.DateTimeField(auto_now_add=True)
    question = models.TextField(max_length=255)
    status = models.TextField(max_length=255)
    runtime = models.TextField(max_length=255)
    qid = models.IntegerField(default=0)
    category = models.TextField(max_length=255)
    code = models.TextField(default='null')
    metrics = models.TextField(default='null')
    quality = models.TextField(default='null')

    @staticmethod
    def get_all_submissions():
        qs = Submissions.objects.all()
        return qs.values()

    @staticmethod
    def get_user_submissions(user=user):
        qst = list(Submissions.objects.filter(user=user).values())

        # result = {}
        # for qs in qst:
        
        # result["user"] = qs.user
        # result["date"] = qs.date
        # result["question"] = qs.question
        # result["status"] = qs.status
        # result["runtime"] = qs.runtime
        # result["qid"] = qs.qid
        # result["category"] = qs.category
        # result["code"] = qs.code
        # result["metircs"] = qs.metrics
        # result["quality"] = qs.quality
        # print(qst)
        return qst
