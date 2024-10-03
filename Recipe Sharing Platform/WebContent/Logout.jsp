<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Confirmation</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #fafafa;
            color: #333;
            text-align: center;
            padding: 50px;
            margin: 0;
        }
        h2 {
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
        .navigation {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 15px;
        }
        button, a {
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
        button:hover, a:hover {
            background-color: #e63e00;
            transform: translateY(-2px);
        }
        button:active, a:active {
            background-color: #cc3700;
            transform: translateY(0);
        }
        a {
            display: inline-block;
            text-align: center;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Do you want to Logout?</h2>
        <form action="LogoutServlet" method="post">
            <button type="submit">Yes</button>
        </form>
        <a href="welcome.jsp">Cancel</a>
    </div>
</body>
</html>
