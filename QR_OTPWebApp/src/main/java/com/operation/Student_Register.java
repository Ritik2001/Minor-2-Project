package com.operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataBase.DaoForAll;
import com.model.Student;

public class Student_Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o= response.getWriter();
		String firstName= request.getParameter("FirstName");
		String lastName= request.getParameter("LastName");
		String sapID= request.getParameter("SapID");
		String emailID= request.getParameter("EmailId");
		String password= request.getParameter("Password");
		String dob= request.getParameter("DOB");
		String department= request.getParameter("Branch");
		String year= request.getParameter("Year");
		String hashedDetails=null;
		String details= firstName+"@"+lastName+"@"+sapID+"@"+emailID+"@"+password+"@"+dob;
		try {
		hashedDetails= findHash(details); //f5269c9120decf0069fa84f040720d55b73740ba9c66aac64bb52f957663d2ed
		System.out.println("hashedValue:"+hashedDetails);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		Student student= new Student(firstName,lastName,sapID,emailID,password,dob,hashedDetails,department,year);
		DaoForAll db = new DaoForAll();
		try {
			
		int records= db.registerDetails(student);
		System.out.println(records+" inserted successfully");
		
		}
		catch(Exception e) {
			
			o.println(e.getMessage());
		}
		
		request.setAttribute("hashedDetails", hashedDetails);
		RequestDispatcher rs= request.getRequestDispatcher("/QRGeneration");
		rs.forward(request, response);
	}
	
	String findHash(String details) throws NoSuchAlgorithmException {
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] bytenum = digest.digest(
		  details.getBytes(StandardCharsets.UTF_8));

		  StringBuffer hexStringBuffer = new StringBuffer();
		    for (int i = 0; i < bytenum.length; i++) {
		        hexStringBuffer.append(byteToHex(bytenum[i]));
		    }
		    return hexStringBuffer.toString();
		}
	
	
	public String byteToHex(byte num) {
	    char[] hexDigits = new char[2];
	    hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
	    hexDigits[1] = Character.forDigit((num & 0xF), 16);
	    return new String(hexDigits);
	}

}
