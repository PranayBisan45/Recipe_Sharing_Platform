<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP Verification</title>
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
    .otp-container {
        display: flex;
        justify-content: center;
        margin-bottom: 20px;
    }
    .otp-container input {
        width: 50px;
        height: 50px;
        margin: 0 10px;
        text-align: center;
        font-size: 24px;
        border-radius: 5px;
        border: 1px solid #ccc;
        box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
        outline: none;
        transition: all 0.2s ease-in-out;
    }
    .otp-container input:focus {
        border-color: #ff6347;
        box-shadow: 0px 0px 10px rgba(255, 99, 71, 0.2);
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
</style>
</head>
<body>
    <h1>OTP Verification</h1>
    <form action="OTPservlet" method="post">
    <input type="hidden" name="OTP" value="${OTP}">
    <input type="hidden" name="user" value="${user}">
        <div class="otp-container">
            <input type="text" name="digit1" id="digit1" maxlength="1" required>
            <input type="text" name="digit2" id="digit2" maxlength="1" required>
            <input type="text" name="digit3" id="digit3" maxlength="1" required>
            <input type="text" name="digit4" id="digit4" maxlength="1" required>
        </div>
        <button type="submit">Submit OTP</button>
    </form>
</body>
</html>
