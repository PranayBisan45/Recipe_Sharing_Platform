<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filters</title>
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
    a {
        display: inline-block;
        margin: 10px;
        padding: 10px 20px;
        background-color: #ff6347;
        color: white;
        text-decoration: none;
        border-radius: 4px;
    }
    a:hover {
        background-color: #e55347;
    }
</style>
</head>
<body>
    <h1>Filters on Recipes</h1>
    <a href="filterCookingTime.jsp">By Cooking Time</a>
    <a href="FilterDifficultyLevel.jsp">By Difficulty Level</a>
</body>
</html>