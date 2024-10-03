<%@page import="com.codon.model.Recipe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Recipe</title>
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
    .container {
        max-width: 600px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }
    label {
        display: block;
        margin-top: 10px;
        font-weight: bold;
    }
    input[type="text"], textarea, select {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border-radius: 4px;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }
    button {
        background-color: #ff6347;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-top: 20px;
    }
    button:hover {
        background-color: #e5533d;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Update Recipe</h1>
        <%
            Recipe recipe = (Recipe) request.getAttribute("recipe");
        %>
        <form action="updateRecipe" method="post">
            <input type="hidden" name="recipeID" value="<%= recipe.getRecipeID() %>">
            
            <label for="title">Recipe Name</label>
            <input type="text" id="title" name="title" value="<%= recipe.getTitle() %>" required>
            
            <label for="ingredients">Ingredients</label>
            <textarea id="ingredients" name="ingredients" rows="5" required><%= recipe.getIngredients() %></textarea>
            
            <label for="description">Description</label>
            <textarea id="description" name="description" rows="5" required><%= recipe.getdiscription() %></textarea>
            
            <label for="cookingTime">Cooking Time</label>
            <input type="text" id="cookingTime" name="cookingTime" value="<%= recipe.getCooking_Time() %>" required>
            
            <label for="difficultyLevel">Difficulty Level</label>
            <input type="text" id="difficultyLevel" name="difficultyLevel" value="<%= recipe.getDifficulty_Level() %>" required>

            <button type="submit">Update Recipe</button>
        </form>
    </div>
</body>
</html>
