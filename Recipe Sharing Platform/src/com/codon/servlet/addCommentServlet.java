package com.codon.servlet;

import java.io.IOException;
import java.util.Properties;

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

import com.codon.dao.InteractionDao;

@WebServlet("/addComment")
public class addCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static InteractionDao IDao = new InteractionDao();
    
    public addCommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String User_Name = (String) session.getAttribute("userName");
		int Recipe_ID = Integer.parseInt(request.getParameter("Recipe_ID"));
		String Comment = request.getParameter("Comment");
		
		boolean success = IDao.addComment(Recipe_ID, User_Name, Comment);
		if(success && User_Name!=null) {
			final String username = "pranaybisan45@gmail.com";
			final String password = "nkhmidfxotwohycf";
			
			String UserName = IDao.getUserName(Recipe_ID);
			String email = IDao.getEmailID(UserName);
			String RecipeName = IDao.getRecipeName(Recipe_ID);
			
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
	        
	        try {
	        	Message message1 = new MimeMessage(session1);
	        	message1.setFrom(new InternetAddress(username));
	        	message1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
	            message1.setSubject("Comment on your recipe");
	            
	            String Content = "<html><body style=\"font-family: Arial, sans-serif; color: #333;\">"
	            	    + "<div style=\"background-color: #f8f9fa; padding: 20px; border-radius: 10px;\">"
	            	    + "<h2 style=\"color: #007bff; text-align: center;\"> Your Recipe Just Got a New Comment! </h2>"
	            	    + "<p style=\"font-size: 16px;\">Hello,</p>"
	            	    + "<p style=\"font-size: 16px;\">We are excited to inform you that <strong>" + User_Name 
	            	    + "</strong> has just commented on your recipe, <strong>" + RecipeName + "</strong>, on our Recipe Sharing Platform!</p>"
	            	    + "<p style=\"font-size: 16px;\"><strong>Comment:</strong> \"" + Comment + "\"</p>"
	            	    + "<p style=\"font-size: 16px;\">Your culinary creation is sparking conversations, and we're thrilled to see it being appreciated.</p>"
	            	    + "<p style=\"font-size: 14px;\">Keep sharing your amazing recipes and inspiring our community!</p>"
	            	    + "<p style=\"font-size: 14px;\">Best Regards,<br/>The Recipe Sharing Platform Team</p>"
	            	    + "</div>"
	            	    + "</body></html>";

	            message1.setContent(Content,"text/html");
	            Transport.send(message1);
	            System.out.println("Email sent successfully!!");
	        } catch(MessagingException e) {
	        	System.out.println(e.getMessage());
	        }
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			dispatcher.forward(request, response);
		} else if(User_Name==null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
