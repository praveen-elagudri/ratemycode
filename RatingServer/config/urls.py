from django.conf import settings
from django.conf.urls import include, url
from django.conf.urls.static import static
from django.contrib.auth import views as auth_views

from ratemycode.activities import views as activities_views
from ratemycode.authentication import views as ratemycode_auth_views
from ratemycode.core import views as core_views
from ratemycode.search import views as search_views

urlpatterns = [
    url(r'^$', core_views.home, name='home'),
    url(r'^login', auth_views.login, {'template_name': 'core/cover.html'},
        name='login'),
    url(r'^logout', auth_views.logout, {'next_page': '/'}, name='logout'),
    url(r'^signup/$', ratemycode_auth_views.signup, name='signup'),
    url(r'^settings/$', core_views.settings, name='settings'),
    url(r'^settings/picture/$', core_views.picture, name='picture'),
    url(r'^settings/upload_picture/$', core_views.upload_picture,
        name='upload_picture'),
    url(r'^settings/save_uploaded_picture/$', core_views.save_uploaded_picture,
        name='save_uploaded_picture'),
    url(r'^settings/password/$', core_views.password, name='password'),
    url(r'^network/$', core_views.network, name='network'),
    url(r'^feeds/', include('ratemycode.feeds.urls')),
    url(r'^challenge/', include('ratemycode.challenge.urls')),
    url(r'^coding/', include('ratemycode.coding.urls')),
    url(r'^jobs/', include('ratemycode.jobs.urls')),
    url(r'^rating/', include('ratemycode.rating.urls')),
    url(r'^codanalyzer/', include('ratemycode.codanalyzer.urls')),
    url(r'^questions/', include('ratemycode.questions.urls')),
    url(r'^articles/', include('ratemycode.articles.urls')),
    url(r'^messages/', include('ratemycode.messenger.urls')),
    url(r'^notifications/$', activities_views.notifications,
        name='notifications'),
    url(r'^notifications/last/$', activities_views.last_notifications,
        name='last_notifications'),
    url(r'^notifications/check/$', activities_views.check_notifications,
        name='check_notifications'),
    # For autocomplete suggestions
    url(r'^autocomplete/$',
        search_views.get_autocomplete_suggestions, name='autocomplete'),
    url(r'^search/$', search_views.search, name='search'),
    url(r'^(?P<username>[^/]+)/$', core_views.profile, name='profile'),
    url(r'^i18n/', include('django.conf.urls.i18n', namespace='i18n')),

] + static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)

if settings.DEBUG:
    if 'debug_toolbar' in settings.INSTALLED_APPS:
        import debug_toolbar
        urlpatterns = [
            url(r'^__debug__/', include(debug_toolbar.urls)),
        ] + urlpatterns
