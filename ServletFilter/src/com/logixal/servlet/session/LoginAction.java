package com.logixal.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userID = "admin";
	private final String password = "password";

       
    public LoginAction() {
        super();
      }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String servername =request.getServerName();
	     String userid=request.getParameter("user");
	     String password=request.getParameter("pwd");
	     if(userID.equals(userid) && password.equals(password)){
	    	 System.out.println("in if");
	    	 HttpSession session=request.getSession();
	    	 session.setAttribute("user", "priyanka");
	    	 session.setMaxInactiveInterval(30*60);
	    	 Cookie username= new Cookie("user",userid);
	    	 username.setMaxAge(30*60);
	    	 response.addCookie(username);
	    	 response.sendRedirect("LoginSuccess.jsp");
	     }
	    	 else{
	    		 RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
	    	PrintWriter out=response.getWriter();
	    	out.println("<font color=red>Either username or password is wrong</font>");
	    	 }
	    	 
	    	 
	     }
	
}
