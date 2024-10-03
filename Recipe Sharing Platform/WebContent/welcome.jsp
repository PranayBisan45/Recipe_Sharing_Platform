<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>

<%
    HttpSession session1 = request.getSession(false);
    String password = null;
    if (session1 != null) {
        password = (String) session1.getAttribute("password");
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Recipe Sharing Platform</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #fafafa;
            color: #333;
            text-align: center;
            padding: 50px;
            margin: 0;
        }
        h1 {
            color: #ff4500;
            margin-bottom: 20px;
            font-size: 2.5em;
        }
        .container {
            max-width: 700px;
            margin: 0 auto;
            padding: 30px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        p {
            font-size: 1.2em;
            margin-bottom: 30px;
            color: #666;
        }
        .navigation {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 15px;
        }
        .navigation a,
        .navigation button {
            flex: 1;
            min-width: 150px;
            margin: 10px 5px;
            padding: 12px 25px;
            text-decoration: none;
            color: #fff;
            background-color: #ff4500;
            border-radius: 5px;
            border: none;
            font-size: 1em;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.3s;
        }
        .navigation a:hover,
        .navigation button:hover {
            background-color: #e63e00;
            transform: translateY(-2px);
        }
        .navigation a:active,
        .navigation button:active {
            background-color: #cc3700;
            transform: translateY(0);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Recipe Sharing Platform!</h1>
        <p>Share your favorite recipes, discover new ones, and connect with other food enthusiasts.</p>
        
        <div class="navigation">
            <a href="addRecipe.jsp">Submit a New Recipe</a>
            
            <form action="viewRecipes" method="post" style="display: inline;">
                <button type="submit" name="viewRecipes" id="viewRecipes">Browse All Recipes</button>
            </form>
            
            <form action="UserFavouriteRecipe" method="get" style="display: inline;">
                <button type="submit" name="UserFavouriteRecipe" id="UserFavouriteRecipe">Favourite Recipes</button>
            </form>

            <a href="searchRecipe.jsp">Search Recipes</a>
            <a href="Filters.jsp">Filters</a>
            <a href="Personal_Info.jsp">Personal Information</a>

            <% 
                if (password == null) {
            %>
                <a href="Login.jsp">Log In</a>
            <% 
                } else { 
            %> 
                <a href="Logout.jsp">Log Out</a>  
            <% 
                } 
            %>
        </div>
    </div>
</body>
</html>
