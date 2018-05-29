from django.db import models
from django.contrib.auth.models import User
from django.utils.encoding import python_2_unicode_compatible
# Create your models here.

@python_2_unicode_compatible
class Rating(models.Model):
    user = models.TextField(max_length=255,primary_key=True)
    easy = models.IntegerField(default=0)
    medium = models.IntegerField(default=0)
    hard = models.IntegerField(default=0)
    rating = models.IntegerField(default=1500)
    rank = models.IntegerField(default=-1)

    @staticmethod
    def get_all_rating():
        qs = Rating.objects.all()
        return qs.values()

    @staticmethod
    def delete_rating(user=user):
        qs = Rating.objects.get(user=user).delete()
        return qs
	
    @staticmethod
    def get_user_rating(user):
        try:
            qs = Rating.objects.get(user=user)
            result = {"rating":qs.rating, "rank":qs.rank}
            return result
        except:
            return "User doesn't exist"
            
    @staticmethod
    def save_new_rating(username,newrating):
    	qs = Rating.objects.get(user=user)
    	qs.rating = newrating
    	qs.save()


    @staticmethod
    def update_easy(user,e):
        qs = Rating.objects.get(user=user)
        qs.easy = e
        qs.save()

    @staticmethod
    def update_medium(user,m):
        qs = Rating.objects.get(user=user)
        qs.medium = x
        qs.save()

    @staticmethod
    def update_hard(user,h):
        qs = Rating.objects.get(user=user)
        qs.hard = h
        qs.save()
