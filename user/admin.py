from django.contrib import admin
from django.contrib.auth.admin import UserAdmin as BaseUserAdmin
from django.contrib.auth.models import User
from .models import Profile


class ProfileInline(admin.StackedInline):
    model = Profile
    can_delete = False


class UserAdmin(BaseUserAdmin):
    inlines = (ProfileInline, )
    # list_display = ('username', 'nickname', 'email', 'is_staff', 'is_active', 'is_superuser')

    def nickname(self, obj):
        return obj.profile.nickname

    def avatar(self, obj):
        return obj.profile.avatar


# Re-register UserAdmin
admin.site.unregister(User)
admin.site.register(User, UserAdmin)
