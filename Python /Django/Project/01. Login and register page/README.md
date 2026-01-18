
---

🧩 Django Login & Registration Project (MySQL)

📌 Project Overview

This project demonstrates how to build a User Authentication System using Django with:

User Registration

User Login

User Logout

MySQL Database integration

Django Authentication System



---

🛠️ Technologies Used

Python 3.x

Django

MySQL

HTML (Templates)

Django ORM



---

📁 Project Structure

django_auth_project/
│
├── auth_project/
│   ├── __init__.py
│   ├── settings.py
│   ├── urls.py
│   ├── wsgi.py
│
├── accounts/
│   ├── migrations/
│   ├── templates/
│   │   └── accounts/
│   │       ├── login.html
│   │       ├── register.html
│   │       └── dashboard.html
│   ├── __init__.py
│   ├── admin.py
│   ├── apps.py
│   ├── models.py
│   ├── views.py
│   ├── urls.py
│
├── manage.py


---

✅ Step 1: Create Virtual Environment

python -m venv venv

Activate:

venv\Scripts\activate   # Windows
source venv/bin/activate # Linux/Mac


---

✅ Step 2: Install Django & MySQL Connector

pip install django mysqlclient


---

✅ Step 3: Create Django Project

django-admin startproject auth_project
cd auth_project


---

✅ Step 4: Create App

python manage.py startapp accounts

Add app to settings.py

INSTALLED_APPS = [
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
    'accounts',
]


---

✅ Step 5: Configure MySQL Database

Create Database in MySQL

CREATE DATABASE django_auth;

settings.py

DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.mysql',
        'NAME': 'django_auth',
        'USER': 'root',
        'PASSWORD': 'your_password',
        'HOST': 'localhost',
        'PORT': '3306',
    }
}


---

✅ Step 6: Run Migrations

python manage.py makemigrations
python manage.py migrate


---

✅ Step 7: Create Superuser

python manage.py createsuperuser


---

✅ Step 8: URLs Configuration

auth_project/urls.py

from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include('accounts.urls')),
]

accounts/urls.py

from django.urls import path
from . import views

urlpatterns = [
    path('', views.login_view, name='login'),
    path('register/', views.register_view, name='register'),
    path('dashboard/', views.dashboard, name='dashboard'),
    path('logout/', views.logout_view, name='logout'),
]


---

✅ Step 9: Views (Core Logic)

accounts/views.py

from django.shortcuts import render, redirect
from django.contrib.auth.models import User
from django.contrib.auth import authenticate, login, logout
from django.contrib import messages

def register_view(request):
    if request.method == 'POST':
        username = request.POST['username']
        email = request.POST['email']
        password = request.POST['password']

        if User.objects.filter(username=username).exists():
            messages.error(request, "Username already exists")
            return redirect('register')

        user = User.objects.create_user(
            username=username,
            email=email,
            password=password
        )
        user.save()
        messages.success(request, "Registration successful")
        return redirect('login')

    return render(request, 'accounts/register.html')


def login_view(request):
    if request.method == 'POST':
        username = request.POST['username']
        password = request.POST['password']

        user = authenticate(request, username=username, password=password)
        if user:
            login(request, user)
            return redirect('dashboard')
        else:
            messages.error(request, "Invalid credentials")

    return render(request, 'accounts/login.html')


def dashboard(request):
    if not request.user.is_authenticated:
        return redirect('login')
    return render(request, 'accounts/dashboard.html')


def logout_view(request):
    logout(request)
    return redirect('login')


---

✅ Step 10: HTML Templates

register.html

<form method="POST">
    {% csrf_token %}
    <h2>Register</h2>
    <input type="text" name="username" placeholder="Username" required><br>
    <input type="email" name="email" placeholder="Email" required><br>
    <input type="password" name="password" placeholder="Password" required><br>
    <button type="submit">Register</button>
</form>
<a href="/">Already have an account?</a>


---

login.html

<form method="POST">
    {% csrf_token %}
    <h2>Login</h2>
    <input type="text" name="username" placeholder="Username" required><br>
    <input type="password" name="password" placeholder="Password" required><br>
    <button type="submit">Login</button>
</form>
<a href="/register/">Create Account</a>


---

dashboard.html

<h2>Welcome {{ request.user.username }}</h2>
<a href="/logout/">Logout</a>


---

✅ Step 11: Run Server

python manage.py runserver

Open:

http://127.0.0.1:8000/


---

🔐 Authentication Flow (Explanation)

1. User registers → data stored in MySQL


2. Password stored hashed (Django default)


3. User logs in → Django validates credentials


4. Session created → user redirected to dashboard


5. Logout clears session




---

📌 Real-World Use Cases

Student Portal Login

Admin Dashboards

E-commerce Authentication

Event Management Systems

Job Portals



---

🎯 Interview Questions

1. How does Django store passwords?


2. Difference between login() and authenticate()?


3. What is CSRF token?


4. How Django handles sessions?


5. Why use Django ORM instead of raw SQL?




---

✅ Next Enhancements

Email verification

Password reset

Role-based authentication

JWT authentication

REST API (Django Rest Framework)



---
