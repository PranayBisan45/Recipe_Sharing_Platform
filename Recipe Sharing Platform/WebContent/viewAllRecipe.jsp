<%@page import="com.codon.model.Recipe"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Recipe</title>
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
    table {
        margin: 20px auto;
        border-collapse: collapse;
        width: 80%;
    }
    table, th, td {
        border: 1px solid #ccc;
        padding: 10px;
    }
    th {
        background-color: #ff6347;
        color: white;
    }
    a {
        color: #ff6347;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
    .details-btn {
        background-color: #ff6347;
        color: white;
        border: none;
        padding: 5px 10px;
        cursor: pointer;
        border-radius: 5px;
    }
    .details-btn:hover {
        background-color: #e55347;
    }
</style>
</head>
<body>
    <h1>Recipe List</h1>
    <table>
        <tr>
            <th>Recipe Name</th>
            <th>Ingredients</th>
            <th>Description</th>
            <th>Cooking Time</th>
            <th>Difficulty Level</th>
            <th>Author</th>
            <th>Favourite</th>
            <th>Like</th>
            <th>Comment</th>
            <th>Interactions</th>
        </tr>
        <%
            List<Recipe> recipes = (List<Recipe>) request.getAttribute("RecipeList");
            if (recipes != null) {
                for (Recipe recipe : recipes) {
        %>
        <tr>
            <td><%= recipe.getTitle() %></td>
            <td><%= recipe.getIngredients() %></td>
            <td><%= recipe.getdiscription() %></td>
            <td><%= recipe.getCooking_Time() %></td>
            <td><%= recipe.getDifficulty_Level() %></td>
            <td><%= recipe.getUser_Name() %></td>
            <td><a href="favouriteRecipe?Recipe_ID=<%= recipe.getRecipeID() %>">Favourite</a></td>
            <td><a href="addLikes?Recipe_ID=<%= recipe.getRecipeID() %>">Like</a></td>
            <td> <a href="Comment.jsp?Recipe_ID=<%= recipe.getRecipeID() %>">Comment</a></td>
            <td>
                <form action="DisplayInteraction" method="get">
                    <input type="hidden" name="Recipe_ID" value="<%= recipe.getRecipeID() %>">
                    <button type="submit" class="details-btn">Details</button>
                </form>
            </td>            
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="10">No recipes found.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
