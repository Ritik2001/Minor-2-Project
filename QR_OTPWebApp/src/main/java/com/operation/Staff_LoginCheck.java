package com.operation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Staff_LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String staffid= request.getParameter("staff_id");
		String password= request.getParameter("password");
		
		if(staffid.equals("staff") && password.equals("staff")) {
			HttpSession session= request.getSession();
			session.setAttribute("isStaffLoggedIn",true);
			response.sendRedirect("Staff_Home.jsp");
		}
		else {
			
			response.sendRedirect("Staff_LoginPage.jsp?login=failed");
		}
	}

}
