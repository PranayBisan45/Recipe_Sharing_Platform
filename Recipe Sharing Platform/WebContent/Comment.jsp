<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit Comment</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        color: #333;
        padding: 50px;
    }
    h1 {
        color: #ff6347;
        text-align: center;
    }
    form {
        margin: 20px auto;
        width: 50%;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    textarea {
        width: 100%;
        height: 100px;
        margin-bottom: 10px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-family: Arial, sans-serif;
    }
    button {
        background-color: #ff6347;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    button:hover {
        background-color: #e5533d;
    }
</style>
</head>
<body>
    <h1>Submit Your Comment</h1>
    <%
        String recipeID = request.getParameter("Recipe_ID");
    %>
    
    <form action="addComment" method="post">
        <input type="hidden" name="Recipe_ID" value="<%= recipeID %>">
        <textarea name="Comment" placeholder="Write your comment here..." required></textarea>
        <button type="submit">Submit Comment</button>
    </form>
</body>
</html>
