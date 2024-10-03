package com.codon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codon.dao.InteractionDao;
import com.codon.model.Comment;

@WebServlet("/DisplayInteraction")
public class DisplayInteractionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static InteractionDao IDao = new InteractionDao();
    
    public DisplayInteractionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Recipe_ID = Integer.parseInt(request.getParameter("Recipe_ID"));
		
		int Total_Likes = IDao.getTotalLikes(Recipe_ID);
		List<Comment> Total_Comments = IDao.getTotalComments(Recipe_ID);
		
		request.setAttribute("Total_Likes", Total_Likes);
		request.setAttribute("Total_Comment", Total_Comments);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayInteraction.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
