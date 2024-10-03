package com.codon.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codon.dao.UserDao;
import com.codon.model.User;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UserDao UDao = new UserDao();
    
    public ProfileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);

		if(session!=null) {
			String name=(String)session.getAttribute("userName");
	        String pass = (String) session.getAttribute("password");
	        
	        User user = UDao.Login(name, pass);
	        
      		request.setAttribute("data", user);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
	        dispatcher.forward(request, response);
		} else {
			response.sendRedirect("Login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
