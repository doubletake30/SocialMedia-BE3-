<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #e0ffe0; /* Faint green background */
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .container {
                width: 400px; /* Adjusted width */
                background-color: #fff;
                padding: 30px; /* Adjusted padding */
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                text-align: center;
                color: #333;
            }

            form {
                display: flex;
                flex-direction: column;
            }

            label {
                margin-bottom: 8px;
                color: #333;
            }

            .password-container {
                position: relative;
            }

            input.email, input.password {
                padding: 10px; /* Adjusted padding */
                margin-bottom: 16px;
                border: 1px solid #ccc;
                border-radius: 3px;
                width: calc(100% - 24px); /* Adjusted width to account for button width and margin */
            }

            .toggle-password {
                position: absolute;
                cursor: pointer;
                left: 90%; /* Adjusted left position */
                background: none;
                border: none;
                height: 100%;
                top: -10%;
                z-index: 1; /* Added z-index to place the button above the input border */
            }

            input[type="submit"] {
                background-color: #4caf50;
                color: #fff;
                cursor: pointer;
                padding: 12px; /* Adjusted padding */
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            .icon {
                width: 30px; /* Adjusted width */
                height: 30px; /* Adjusted height */
            }

            .register-link {
                text-align: center;
                margin-top: 15px; /* Adjusted margin */
                color: #333;
            }

            .register-link a {
                color: #4caf50;
                text-decoration: none;
                font-weight: bold;
            }

            .register-link a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Login</h2>

            <!-- Check if there is a notification -->
            <c:if test="${requestScope.error != null}">
                <p style="color: red;">${requestScope.error}</p>
            </c:if>

            <form method="POST">
                <label for="email">Email</label>
                <input type="text" name="email" class="email" required>

                <label for="password">Password</label>
                <div class="password-container">
                    <input type="password" name="password" class="password" required>
                    <button type="button" class="toggle-password" onclick="togglePasswordVisibility(this)">
                        <img id="passwordIcon" src="${pageContext.request.contextPath}/resources/images/hide.png" alt="Toggle Password Visibility" class="icon">
                    </button>
                </div>

                <input type="submit" value="Login">
            </form>
            <div class="register-link">
                <p>Not registered? <a href="${pageContext.request.contextPath}/register">Create an account</a></p>
            </div>
        </div>

        <script>
            function togglePasswordVisibility(button) {
                var passwordInput = button.previousElementSibling;
                var passwordIcon = document.getElementById("passwordIcon");

                if (passwordInput.type === "password") {
                    passwordInput.type = "text";
                    passwordIcon.src = "${pageContext.request.contextPath}/resources/images/view.png";
                } else {
                    passwordInput.type = "password";
                    passwordIcon.src = "${pageContext.request.contextPath}/resources/images/hide.png";
                }
            }
        </script>
    </body>
</html>