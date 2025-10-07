# Flask Web Application

This project is a simple web application built using Flask that implements basic user authentication and allows users to input prompts. The application displays Power BI reports and analytics based on the user input.

## Project Structure

```
flask-web-app
├── app.py                # Main entry point of the Flask application
├── requirements.txt      # Lists dependencies required for the project
├── README.md             # Documentation for the project
├── static
│   └── styles.css        # CSS styles for the application
├── templates
│   ├── base.html         # Base template for the application
│   ├── index.html        # Main page of the application
│   └── login.html        # Login interface for user authentication
└── utils
    └── auth.py           # Functions for user authentication
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd flask-web-app
   ```

2. **Create a virtual environment:**
   ```
   python -m venv venv
   ```

3. **Activate the virtual environment:**
   - On Windows:
     ```
     venv\Scripts\activate
     ```
   - On macOS/Linux:
     ```
     source venv/bin/activate
     ```

4. **Install the required dependencies:**
   ```
   pip install -r requirements.txt
   ```

## Usage

1. **Run the application:**
   ```
   python app.py
   ```

2. **Access the application:**
   Open your web browser and go to `http://127.0.0.1:5000`.

3. **Authentication:**
   - Navigate to the login page to enter your credentials.
   - After logging in, you will be redirected to the main page where you can input prompts and view Power BI reports.

## Features

- User authentication with login and logout functionality.
- Input form for user prompts.
- Buttons to display Power BI reports and analytics.

## License

This project is licensed under the MIT License.