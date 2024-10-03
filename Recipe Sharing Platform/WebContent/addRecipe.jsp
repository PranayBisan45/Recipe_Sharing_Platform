<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Recipe</title>
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
    label {
        display: block;
        margin-bottom: 10px;
    }
    input, textarea, select {
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
</style>
</head>
<body>
    <h1>Submit a New Recipe</h1>
    <form action="addRecipe" method="post">
    
        <label for="title">Recipe Title</label>
        <input type="text" id="title" name="title" required>

        <label for="ingredients">Ingredients</label>
        <textarea id="ingredients" name="ingredients" rows="4" required></textarea>

        <label for="description">Description</label>
        <textarea id="description" name="description" rows="6" required></textarea>
        
        <label for="Cooking_Time">Cooking Time</label>
        <input type="text" id="Cooking_Time" name="Cooking_Time" required>
        
        <label for="Difficulty_Level">Difficulty Level</label>
        <select id="Difficulty_Level" name="Difficulty_Level" required>
            <option value="1">1 - Very Easy</option>
            <option value="2">2 - Easy</option>
            <option value="3">3 - Medium</option>
            <option value="4">4 - Hard</option>
            <option value="5">5 - Very Hard</option>
        </select>

        <button type="submit">Submit Recipe</button>
    </form>
</body>
</html>
