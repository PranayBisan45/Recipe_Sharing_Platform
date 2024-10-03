<%@page import="com.codon.model.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Recipe</title>
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
        display: inline-block;
        text-align: left;
        background: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
    }
    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    button {
        background-color: #ff6347;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #e55347;
    }
    table {
        margin: 20px auto;
        border-collapse: collapse;
        width: 100%;
    }
    table, th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
    <h1>Search Recipes</h1>
    <form action="searchRecipe" method="get">
        <input type="text" name="keyword" id="keyword" placeholder="Enter Keyword" required>
        <button type="submit">Search</button>
    </form>

    <% 
        List<Recipe> recipes = (List<Recipe>) request.getAttribute("data");
        if (recipes != null && !recipes.isEmpty()) { 
    %>
    <table>
        <tr>
            <th>Title</th>
            <th>Ingredients</th>
            <th>Description</th>
            <th>Cooking Time</th>
            <th>Difficulty Level</th>
            <th>Author</th>
        </tr>
        <% for (Recipe recipe : recipes) { %>
        <tr>
            <td><%= recipe.getTitle() %></td>
            <td><%= recipe.getIngredients() %></td>
            <td><%= recipe.getdiscription() %></td>
            <td><%= recipe.getCooking_Time() %></td>
            <td><%= recipe.getDifficulty_Level() %></td>
            <td><%= recipe.getUser_Name() %></td>
        </tr>
        <% } %>
    </table>
    <% } else if (recipes != null) { %>
        <p>No recipes found.</p>
    <% } %>
</body>
</html>
