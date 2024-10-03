package com.codon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codon.dao.RecipeDao;

@WebServlet("/removeFavourite")
public class RemoveFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static RecipeDao RDao = new RecipeDao();
    
    public RemoveFavouriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("Recipe_ID"));
		RDao.deleteFavourite(id);
		
		response.sendRedirect("welcome.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
