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

@WebServlet("/OTPservlet")
public class OTPservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UserDao UDao = new UserDao();
    
    public OTPservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String user = request.getParameter("user");
		String password = UDao.Password(user);
		
		String OTP = request.getParameter("OTP");
		String digit1 = request.getParameter("digit1");
		String digit2 = request.getParameter("digit2");
		String digit3 = request.getParameter("digit3");
		String digit4 = request.getParameter("digit4");
		
		String otp = digit1+digit2+digit3+digit4;
		
		if(OTP.equals(otp)) {
			HttpSession session = request.getSession();
	        session.setAttribute("userName", user);
	        session.setAttribute("password", password);
	        
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
