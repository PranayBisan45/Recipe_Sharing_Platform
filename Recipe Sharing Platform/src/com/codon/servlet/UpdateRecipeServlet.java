package com.codon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codon.dao.RecipeDao;
import com.codon.model.Recipe;

@WebServlet("/updateRecipe")
public class UpdateRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static RecipeDao RDao = new RecipeDao();
    
    public UpdateRecipeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recipeID = Integer.parseInt(request.getParameter("recipeID"));
		String title = request.getParameter("title");
        String ingredients = request.getParameter("ingredients");
        String description = request.getParameter("description");
        String cookingTime = request.getParameter("cookingTime");
        String difficultyLevel = request.getParameter("difficultyLevel");
        
        Recipe recipe = new Recipe(recipeID, title, ingredients, description, cookingTime, difficultyLevel);
        RDao.updateRecipe(recipe);
        
        response.sendRedirect("welcome.jsp");
	}
}
