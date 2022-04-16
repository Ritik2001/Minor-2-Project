package com.operation;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

public class OTPGeneration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		
		String otp= new DecimalFormat("000000").format(new Random().nextInt(999999));
		session.setAttribute("otp", otp);
		
		System.out.println("OTP: "+ otp);
		response.sendRedirect("MailService");
	}

}
