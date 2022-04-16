package com.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Student;

public class DaoForAll {
	
Connection con= DBConnection.getConnection();
	
	public int registerDetails(Student stu) throws Exception{
		
		
		String query ="INSERT INTO student_registration(fname,lname,sap_id,email_id,password,dob,qrcodedetail,dept,year) VALUES(?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement st= con.prepareStatement(query);
		st.setString(1,stu.getFirstName());	
		st.setString(2,stu.getLastName());
		st.setString(3,stu.getSapid());
		st.setString(4,stu.getEmailID());
		st.setString(5,stu.getPassword());
		st.setString(6,stu.getDob());
		st.setString(7,stu.getQrdetails());
		st.setString(8,stu.getBranch());
		st.setString(9,stu.getYear());
		int no_records=st.executeUpdate();
		return no_records;
	}
	
	public ResultSet getStudentAttendanceDetails(String sapid) throws SQLException
	{
		Connection con= DBConnection.getConnection();
		String query="SELECT sr.sap_id, sa.name, sa.attendance_time, sr.dept, sr.year FROM student_registration sr JOIN student_attendance sa ON sr.sap_id=sa.sap_id WHERE sr.sap_id='"+sapid+"'";
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery(query);
		return rs;
	}
	
	public ResultSet getStudentsDetails() throws SQLException {
		
		
		String query="SELECT fname,lname,sap_id,email_id,dept,year FROM student_registration";
		Statement st= con.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}
	public ResultSet getAllStudentAttendance() throws SQLException {
		
	
		String query="SELECT sr.sap_id, sa.name, sa.attendance_time, sr.dept, sr.year FROM student_registration sr JOIN student_attendance sa ON sr.sap_id=sa.sap_id";
		Statement st= con.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
		
	}

}
