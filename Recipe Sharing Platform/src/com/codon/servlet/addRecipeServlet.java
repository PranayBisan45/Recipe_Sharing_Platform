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


@WebServlet("/addRecipe")
public class addRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static RecipeDao RDao = new RecipeDao(); 
	
    public addRecipeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String name=(String)session.getAttribute("userName");
	        
		String title = request.getParameter("title");
        String ingredients = request.getParameter("ingredients");
        String description = request.getParameter("description");
        String Cooking_Time = request.getParameter("Cooking_Time");
        String Difficulty_Level = request.getParameter("Difficulty_Level");

        boolean success = RDao.saveRecipe(title,ingredients,description,name,Cooking_Time,Difficulty_Level);

        if(success) {			
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
