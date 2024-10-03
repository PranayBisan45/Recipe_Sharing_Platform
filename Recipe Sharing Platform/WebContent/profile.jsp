<%@page import="com.codon.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
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
    <h1>Profile</h1>
    <table>
        <tr>
            <th>User Name</th>
            <td> <% User user = (User) request.getAttribute("data"); %>
            <%= user != null ? user.getUsername() : "N/A" %></td>
        </tr>
        <tr>
            <th>Mobile Number</th>
            <td><%= user != null ? user.getMobileNumber() : "N/A" %></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><%= user != null ? user.getEmail() : "N/A" %></td>
        </tr>
    </table>
</body>
</html>
