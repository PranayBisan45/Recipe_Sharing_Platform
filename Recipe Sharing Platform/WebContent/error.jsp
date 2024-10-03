<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            color: #333;
            padding: 50px;
            text-align: center;
        }
        h1 {
            color: #ff6347;
        }
        p {
            margin: 20px 0;
        }
        .details {
            margin-top: 20px;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            text-align: left;
            max-width: 600px;
            margin: 0 auto;
        }
        .home-btn {
            margin-top: 30px;
            background-color: #ff6347;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            display: inline-block;
        }
        .home-btn:hover {
            background-color: #e55347;
        }
    </style>
</head>
<body>
    <h1>Oops! Something went wrong.</h1>
    <p>We encountered an error while processing your request.</p>
    <p>Please try again later or contact support (Mo. No. 9552007193) if the issue persists.</p>
    <a href="welcome.jsp" class="home-btn">Go to Home</a>
</body>
</html>
