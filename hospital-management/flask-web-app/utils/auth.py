from flask import session, redirect, url_for, request
from werkzeug.security import generate_password_hash, check_password_hash

# Dummy user data for demonstration purposes
users = {
    "admin": generate_password_hash("password123")
}

def login(username, password):
    if username in users and check_password_hash(users[username], password):
        session['username'] = username
        return True
    return False

def logout():
    session.pop('username', None)

def is_authenticated():
    return 'username' in session

def get_current_user():
    return session.get('username')