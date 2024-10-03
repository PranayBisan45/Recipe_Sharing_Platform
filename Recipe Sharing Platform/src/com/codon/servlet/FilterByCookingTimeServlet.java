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

@WebServlet("/FilterByCookingTime")
public class FilterByCookingTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static RecipeDao RDao = new RecipeDao();
    
    public FilterByCookingTimeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String Cooking_Time = request.getParameter("Cooking_Time");
		
			List<Recipe> recipe = RDao.filterByCookingTime(Cooking_Time);
			request.setAttribute("data", recipe);
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("filterCookingTime.jsp");
			dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}