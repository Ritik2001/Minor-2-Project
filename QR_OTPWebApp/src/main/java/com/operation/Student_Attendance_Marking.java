package com.operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;

import com.dataBase.DBConnection;

public class Student_Attendance_Marking extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		Connection conn= DBConnection.getConnection();
		HttpSession session= request.getSession();
		String sapid= (String)session.getAttribute("sapid");
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();
	    String time = dateFormat.format(date);
	    
		String query1="SELECT * FROM student_registration WHERE sap_id="+sapid;
		try{
			Statement st1= conn.createStatement();
			ResultSet rs= st1.executeQuery(query1);
			rs.next();
			String firstName= rs.getString("fname");
			String lastName= rs.getString("lname");
			String department= rs.getString("dept");
			String year= rs.getString("year");
			session.setAttribute("Name",firstName+" "+lastName);
			String query2 ="INSERT INTO student_attendance(sap_id,name,attendance_time) VALUES(?,?,?)";
			
			PreparedStatement st2 = conn.prepareStatement(query2);
			st2.setString(1,sapid);
			st2.setString(2,firstName+" "+lastName);
			st2.setString(3,time);
			
			int records= st2.executeUpdate();
			if(records>0)
			{
				System.out.println("Successfully Marked the attendance");
				response.sendRedirect("Student_Home.jsp");
			}
			else {
				throw new Exception("Something wrong happened to the site");
			}
			}
		catch(Exception e)
		{
			out.println(e.getMessage());
		}
		
		}

}
