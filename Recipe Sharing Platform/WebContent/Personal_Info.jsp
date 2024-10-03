<%@page import="com.codon.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            color: #333;
            text-align: center;
            padding: 50px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .navigation {
            margin-top: 20px;
        }
        .navigation button {
            display: inline-block;
            margin: 10px 20px;
            padding: 10px 20px;
            color: #fff;
            background-color: #ff6347;
            border-radius: 4px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .navigation button:hover {
            background-color: #e5533d;
        }
        
        h1 {
            color: #ff6347;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="navigation">
        <h1> Personal Information </h1>
            <form action="profile" method="post" style="display: inline;">    
                <button type="submit" name="profile" id="profile">Profile</button>
            </form>
            <form action="RecipeByName" method="post" style="display: inline;">    
                <button type="submit" name="rbn" id="rbn">Your Recipes</button>
            </form>
        </div>
    </div>
</body>
</html>
