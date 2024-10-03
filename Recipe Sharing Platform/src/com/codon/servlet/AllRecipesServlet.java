package com.codon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codon.dao.RecipeDao;
import com.codon.model.Recipe;

@WebServlet("/viewRecipes")
public class AllRecipesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RecipeDao RDao = new RecipeDao();
	
    public AllRecipesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Recipe> recipes = RDao.getAllRecipes();
		
		request.setAttribute("RecipeList", recipes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewAllRecipe.jsp");
		dispatcher.forward(request, response);
	}
}
