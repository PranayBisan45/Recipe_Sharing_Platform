<%@page import="com.codon.model.Favourite"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Favourite Recipe Collection</title>
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
    }body {
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
</style>
</head>
<body>
<h1>Favourite Recipe Collection</h1>
<table>
	<tr>
		<th>Recipe Name</th>
        <th>Ingredients</th>
        <th>Description</th>
        <th>Cooking Time</th>
		<th>Difficulty Level</th>
        <th>Author</th>
        <th>Remove</th>
	</tr>
	<%
		List<Favourite> favourites = (List<Favourite>) request.getAttribute("favourite");
	
		if(favourites!=null) {
			for(Favourite favourite: favourites) {
	%>
	<tr>
		<td><%= favourite.getTitle() %> </td>
		<td><%= favourite.getIngredients() %> </td>
		<td><%= favourite.getDiscription() %> </td>
		<td><%= favourite.getCooking_Time() %> </td>
		<td><%= favourite.getDifficulty_Level() %> </td>
		<td><%= favourite.getAuthor_Name() %> </td>
		<td><a href="removeFavourite?Recipe_ID=<%= favourite.getRecipeID() %>" onclick="return confirm('Are you sure you want to remove from favourite?');">Remove</a></td>
	</tr>
	<%
			}
       } else {
    %>
	<tr>
		<td colspan="6">No recipes found.</td>
	</tr>
    <%
		}
	%>
</table>
</body>
</html>