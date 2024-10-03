package com.codon.servlet;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codon.dao.UserDao;

@WebServlet("/LoginOTP")
public class LoginOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static UserDao UDao = new UserDao();
    
    public LoginOTP() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String UserName = request.getParameter("username");
		String email = request.getParameter("email");
		
		boolean validUser = UDao.isValidUser(UserName, email);
		
		if(validUser) {
			final String username = "pranaybisan45@gmail.com";
			final String password = "nkhmidfxotwohycf";
			
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
			
	        Session session1 = Session.getInstance(props, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	        });
	        
	        Random random = new Random();
	        int OTP1 = random.nextInt(10000);
	        String OTP = Integer.toString(OTP1);
	        
	        if(OTP.length()<4) {
	        	OTP = OTP+"4";
	        }
	        
	        try {
	        	Message message1 = new MimeMessage(session1);
	        	message1.setFrom(new InternetAddress(username));
	        	message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
	            message1.setSubject("OTP for Login");
	            
	            String Content = "<html><body style=\"font-family: Arial, sans-serif; color: #333;\">"
	                    + "<div style=\"background-color: #f8f9fa; padding: 20px; border-radius: 10px;\">"
	                    + "<h2 style=\"color: #007bff; text-align: center;\"> Your OTP for Login </h2>"
	                    + "<p style=\"font-size: 16px;\">Hello, <strong>" + UserName + "</strong>,</p>"
	                    + "<p style=\"font-size: 16px;\">We received a request to log in to your account on our Recipe Sharing Platform.</p>"
	                    + "<p style=\"font-size: 16px;\">Please use the following OTP to complete your login process:</p>"
	                    + "<h3 style=\"color: #28a745; text-align: center;\">" + OTP + "</h3>"
	                    + "<p style=\"font-size: 16px;\">If you did not initiate this request, please ignore this email.</p>"
	                    + "<p style=\"font-size: 14px;\">Best Regards,<br/>The Recipe Sharing Platform Team</p>"
	                    + "</div>"
	                    + "</body></html>";

	            message1.setContent(Content,"text/html");
	            Transport.send(message1);
	            System.out.println("Email sent successfully!!");
	        } catch(MessagingException e) {
	        	System.out.println(e.getMessage());
	        }
	        request.setAttribute("OTP", OTP);
	        request.setAttribute("user", UserName);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("OTP.jsp");
			dispatcher.forward(request, response);
        } else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
        }
	}
}
