<%@page import="java.util.List"%>
<%@page import="com.codon.model.Comment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recipe Details</title>
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
    .details {
        margin: 20px auto;
        width: 60%;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .stat {
        font-size: 1.5em;
        margin: 10px 0;
        text-align: center;
    }
    .stat span {
        color: #ff6347;
        font-weight: bold;
    }
    .comments {
        margin-top: 20px;
    }
    .comment {
        background-color: #fff;
        padding: 15px;
        border-radius: 5px;
        margin-bottom: 10px;
        box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }
    .comment .author {
        font-weight: bold;
    }
    .comment .date {
        font-size: 0.9em;
        color: #999;
    }
</style>
</head>
<body>
    <h1>Recipe Details</h1>
    <div class="details">
        <%
            String recipeID = request.getParameter("Recipe_ID");
            int totalLikes = (Integer) request.getAttribute("Total_Likes");
            List<Comment> comments = (List<Comment>) request.getAttribute("Total_Comment");
            int index=1;
        %>
        
        <div class="stat">Total Likes: <span><%= totalLikes %></span></div>
        
        <div class="comments">
            <h2>Comments:</h2>
            <% if (comments != null && !comments.isEmpty()) { %>
                <% for (Comment comment : comments) { %>
                    <div class="comment">
                        <div class="author"><%= index++%>) <%= comment.getUser_Name() %></div>
                        <p><%= comment.getComment() %></p>
                    </div>
                <% } %>
            <% } else { %>
                <p>No comments yet. Be the first to comment!</p>
            <% } %>
        </div>
    </div>
</body>
</html>
