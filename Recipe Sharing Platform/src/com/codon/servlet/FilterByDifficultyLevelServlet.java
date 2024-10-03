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

@WebServlet("/FilterByDifficultyLevel")
public class FilterByDifficultyLevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RecipeDao RDao = new RecipeDao();
	
    public FilterByDifficultyLevelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String Difficulty_Level = request.getParameter("FDL");
		List<Recipe> recipes = RDao.filterByDifficultyLevel(Difficulty_Level);
		
		request.setAttribute("data", recipes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("FilterDifficultyLevel.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
