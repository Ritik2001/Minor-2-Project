package com.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataBase.DBConnection;

public class StudentRegCheck implements Filter {
    public StudentRegCheck() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Connection con= DBConnection.getConnection();
		HttpServletRequest req= (HttpServletRequest)(request);
		HttpServletResponse res= (HttpServletResponse)(response);
		
		String sapid= req.getParameter("SapID");
		boolean match=Pattern.matches("[^0]{1}[0-9]{8}",sapid); // regular expression
		
		if(!match)
		{
			res.sendRedirect("Student_Register.jsp?isSapID=Invalid");
		}
		
		else{
			
			 String query="SELECT * FROM student_registration WHERE sap_id=? ";
			   try {
				   	PreparedStatement st= con.prepareStatement(query);
				   	st.setString(1,sapid);
		
				   	ResultSet rs= st.executeQuery();
				   	if(rs.next()) {
		
				   		res.sendRedirect("Student_LoginPage.jsp?SapID=Already_Exists");
				   		}
				   	else {
				   			String email= request.getParameter("EmailId");
				   			query="SELECT * FROM student_registration WHERE email_id=?";
				   			st = con.prepareStatement(query);
				   			st.setString(1,email);
				   			rs= st.executeQuery();
				   			
				   			if(rs.next())
				   			{
				   				res.sendRedirect("Student_LoginPage.jsp?Email=Already_Exists");
				   			}
				   			else {
				   				chain.doFilter(request, response);
							}
				   		}
		
			   	}
			   
			   catch(Exception e) {
				   System.out.println(e.getMessage());
			   }
		
		}

		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
