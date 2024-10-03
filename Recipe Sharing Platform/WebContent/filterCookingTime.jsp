<%@page import="java.util.List"%>
<%@page import="com.codon.model.Recipe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filter Recipes by Cooking Time</title>
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
        margin-bottom: 30px;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        display: inline-block;
    }
    label {
        margin-right: 10px;
        font-weight: bold;
    }
    input[type="text"] {
        padding: 8px;
        border-radius: 4px;
        border: 1px solid #ccc;
        margin-right: 10px;
        width: 200px;
    }
    button {
        padding: 8px 15px;
        background-color: #ff6347;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-weight: bold;
    }
    button:hover {
        background-color: #ff4500;
    }
    table {
        margin: 0 auto;
        border-collapse: collapse;
        width: 50%;
    }
    table, th, td {
        border: 1px solid #ccc;
        padding: 10px;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
    <h1>Filter Recipes by Cooking Time</h1>
    <form action="FilterByCookingTime" method="get">
        <label for="Cooking_Time">Enter Cooking Time:</label>
        <input type="text" id="Cooking_Time" name="Cooking_Time" required>
        <button type="submit">Filter</button>
    </form>
    
    <%
        List<Recipe> recipes = (List<Recipe>) request.getAttribute("data");
        if (recipes != null && !recipes.isEmpty()) {
    %>
        <table>
            <tr>
                <th>Recipe Name</th>
                <th>Ingredients</th>
                <th>Description</th>
                <th>Cooking Time</th>
                <th>Difficulty Level</th>
                <th>Author</th>
            </tr>
            <%
                for (Recipe recipe : recipes) {
            %>
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
    <%
        } else if (recipes != null) {
    %>
        <p>No recipes found with the specified cooking time.</p>
    <%
        }
    %>
</body>
</html>