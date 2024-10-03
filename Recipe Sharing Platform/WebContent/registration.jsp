<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        color: #333;
        text-align: center;
        padding: 50px;
    }
    h1 {
        color: #ff6347;
    }
    form {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        display: inline-block;
        text-align: left;
    }
    table {
        margin: 0 auto;
    }
    table td {
        padding: 10px;
    }
    input[type="text"], input[type="password"], input[type="number"] {
        width: 200px;
        padding: 8px;
        border-radius: 4px;
        border: 1px solid #ccc;
        font-size: 14px;
    }
    button[type="submit"] {
        background-color: #ff6347;
        color: #fff;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        margin-top: 20px;
        transition: background-color 0.3s;
    }
    button[type="submit"]:hover {
        background-color: #e5533d;
    }
    .navigation {
        margin-top: 20px;
    }
    .navigation a {
        display: inline-block;
        margin: 10px 20px;
        padding: 10px 20px;
        text-decoration: none;
        color: #fff;
        background-color: #ff6347;
        border-radius: 4px;
        transition: background-color 0.3s;
    }
    .navigation a:hover {
        background-color: #e5533d;
    }
</style>
</head>
<body>
    <h1>Register</h1>
    <form action="registration" method="post">
        <table>
            <tr>
                <td>User Name:</td>
                <td><input type="text" name="userName" id="username" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" id="password" required></td>
            </tr>
            <tr>
                <td>Mobile Number:</td>
                <td><input type="number" name="number" id="num" required></td>
            </tr>
            <tr>
                <td>Email ID:</td>
                <td><input type="text" name="email" id="email" required></td>
            </tr>
        </table>
        <button type="submit" name="btn" id="btn">Register</button><br>
    </form>
    <div class="navigation">
    <h4>Already have an Account?</h4>
    <p><a href="Login.jsp">Login</a> 
    <a href="welcome.jsp">Home</</a></p></div>
</body>
</html>
