package com.codon.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codon.dao.RecipeDao;
import com.codon.model.Favourite;
import com.codon.model.Recipe;

@WebServlet("/favouriteRecipe")
public class FavouriteRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RecipeDao RDao = new RecipeDao();
	
    public FavouriteRecipeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recipe_Id = Integer.parseInt(request.getParameter("Recipe_ID"));
		
		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("userName");
		
		Recipe recipe = RDao.getRecipeById(recipe_Id);
		Favourite favourite = new Favourite(recipe.getTitle(),recipe.getIngredients(),recipe.getdiscription(),recipe.getUser_Name(),recipe.getCooking_Time(),
								recipe.getDifficulty_Level(),userName);
		
		boolean success = RDao.favouriteRecipe(favourite);
		
		if(success && userName!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
