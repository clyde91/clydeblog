from django.shortcuts import render, redirect
from django.contrib import auth
from django.contrib.auth.models import User
from django.urls import reverse
from django.http import JsonResponse
from user.forms import LoginForm, RegForm


def login_for_medal(request):
    login_form = LoginForm(request.POST)
    data = {}
    if login_form.is_valid():
        user = login_form.cleaned_data['user']
        auth.login(request, user)
        data['status'] = 'SUCCESS'
    else:
        data['status'] = 'ERROR'
    return JsonResponse(data)


def login(request):
    if request.method == 'POST':  # 加判断login这个方法是打开登录页面的处理，还是提交登录数据的请求。相当于2个方法合并到一个来。
        login_form = LoginForm(request.POST)  # 将post传来的数据实例化成表单
        if login_form.is_valid():
            user = login_form.cleaned_data["user"]
            auth.login(request, user)
            return redirect(request.GET.get("from", reverse('home')))
    else:
        login_form = LoginForm()  # request方法不是POST

    context = {}  # if分支的共有部分，都会执行以下代码。
    context['login_form'] = login_form
    return render(request, 'login.html', context)


def logout(request):  #退出登录
    referer = request.META.get('HTTP_REFERER', reverse('home'))
    auth.logout(request)
    return redirect(referer)


def register(request):
    if request.method == 'POST':
        reg_form = RegForm(request.POST)
        if reg_form.is_valid():
            username = reg_form.cleaned_data['username']
            email = reg_form.cleaned_data['email']
            password = reg_form.cleaned_data['password']
            # 创建用户
            user = User.objects.create_user(username=username,email=email,password=password)
            user.save()
            # 登录用户
            user = auth.authenticate(request, username=username, password=password)
            auth.login(request, user)
            return redirect(request.GET.get("from", reverse('home')))

    else:
        reg_form = RegForm()  # request方法不是POST时

    context = {}  # if分支的共有部分，都会执行以下代码。
    context['reg_form'] = reg_form
    return render(request, 'register.html', context)


def user_info(request):
    context = {}

    return render(request, 'user_info.html', context)
