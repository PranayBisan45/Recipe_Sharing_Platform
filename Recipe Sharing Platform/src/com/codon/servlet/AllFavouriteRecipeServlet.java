package com.codon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codon.dao.RecipeDao;
import com.codon.model.Favourite;

@WebServlet("/UserFavouriteRecipe")
public class AllFavouriteRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static RecipeDao RDao = new RecipeDao();
    
    public AllFavouriteRecipeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String name = (String) session.getAttribute("userName");
		
		List<Favourite> favourites = RDao.getFavouriteRecipe(name);
		
		request.setAttribute("favourite", favourites);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("favouriteRecipe.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
