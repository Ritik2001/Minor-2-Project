package com.operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dataBase.DBConnection;

public class Student_LoginCheck extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sapid= request.getParameter("sap_id");
		String password= request.getParameter("password");
		String email= request.getParameter("email");
		PrintWriter out= response.getWriter();
		Connection con= DBConnection.getConnection();
		String query= " SELECT * FROM student_registration WHERE sap_id=? AND password=? AND email_id=?";
		try
		{
		PreparedStatement st= con.prepareStatement(query);
		st.setString(1, sapid);
		st.setString(2, password);
		st.setString(3, email);
		ResultSet rs= st.executeQuery();
		if(rs.next()) {
			
			HttpSession session= request.getSession();
			RequestDispatcher rd= request.getRequestDispatcher("/OTPGeneration");
			session.setAttribute("isUserLoggedIn",true);
			session.setAttribute("email",request.getParameter("email"));
			session.setAttribute("sapid",request.getParameter("sap_id"));
			rd.forward(request, response);
		}
		else {
			
			response.sendRedirect("Student_LoginPage.jsp?LoginFailed=true");
		}
		
		}
		catch(Exception e) {
			out.println(e.getMessage());
		}
		
	}

}
