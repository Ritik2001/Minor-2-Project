package com.operation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session= request.getSession();		
		session.removeAttribute("isUserLoggedIn");
		session.removeAttribute("isStaffLoggedIn");
		response.sendRedirect("index.jsp");
	}

}
