# # ...existing code...
# app = Flask(__name__)
# app.secret_key = 'your_secret_key'  # Ensure this line is present and set to a secure value
# # ...existing code...



from flask import Flask

app = Flask(__name__)
app.secret_key = 'your_secret_key'

@app.route('/')
def home():
    return "Hello, Flask!"

if __name__ == '__main__':
    app.run(debug=True)
