package com.codon.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codon.dao.RecipeDao;
import com.codon.model.Recipe;

@WebServlet("/editRecipe")
public class EditRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static RecipeDao RDao = new RecipeDao();   
    public EditRecipeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int recipeID = Integer.parseInt(request.getParameter("Recipe_ID"));
		
		Recipe recipe = RDao.getRecipeById(recipeID);
		
		request.setAttribute("recipe", recipe);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateRecipe.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
