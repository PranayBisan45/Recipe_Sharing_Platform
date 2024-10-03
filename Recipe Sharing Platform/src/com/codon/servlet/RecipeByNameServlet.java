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
import com.codon.model.Recipe;

@WebServlet("/RecipeByName")
public class RecipeByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static RecipeDao RDao = new RecipeDao();   
   
    public RecipeByNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		
		String name=(String)session.getAttribute("userName");

        List<Recipe> recipe = RDao.getRecipeByName(name);

        if (recipe != null) {
            request.setAttribute("recipe", recipe);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewRecipeByName.jsp");
	        dispatcher.forward(request, response);
        } else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
	        dispatcher.forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}