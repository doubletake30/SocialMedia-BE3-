<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
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
            width: 100px; /* Set a specific width for labels */
        }

        input, select {
            padding: 10px; /* Adjusted padding */
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 3px;
            width: calc(100% - 24px); /* Adjusted width to account for button width and margin */
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

        /* Fixed width for the gender dropdown */
        select {
            width: 398px; /* Set the width to match label width */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registration</h2>

        <!-- Check if there is a notification -->
        <% String notification = (String) request.getAttribute("error"); %>
        <% if (notification != null && !notification.isEmpty()) {%>
        <p class="notification"><%= notification%></p>
        <% }%>

        <form method="post">
            <label for="firstName">First Name</label>
            <input type="text" name="firstName" required>

            <label for="lastName">Last Name</label>
            <input type="text" name="lastName" required>

            <label for="email">Email</label>
            <input type="text" name="email" required>

            <label for="password">Password</label>
            <input type="password" name="password" required>

            <label for="dateOfBirth">Date of Birth</label>
            <input type="date" name="dateOfBirth" required>

            <label for="gender">Gender</label>
            <select name="gender" required>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select>

            <label for="country">Country</label>
            <input type="text" name="country" required>

            <label for="phone">Phone</label>
            <input type="text" name="phone" required>

            <input type="submit" value="Register">
        </form>
        <div class="register-link">
            <p>Already registered? <a href="${pageContext.request.contextPath}/Login">Login</a></p>
        </div>
    </div>
</body>
</html>
