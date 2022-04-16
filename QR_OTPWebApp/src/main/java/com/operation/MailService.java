package com.operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mail.Mail;

public class MailService extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getAttribute("sendQRAttachment") != null)
		{
			
		String path= (String)request.getAttribute("path");
		String recepient= request.getParameter("EmailId");
		String subject = "Registration Successful";
		Mail mail = new Mail(subject);
		mail.sendMailWithQRAttachment(recepient,path);
		Files.deleteIfExists(Paths.get(path));
		System.out.println("Registration Successful: "+path+" "+" "+recepient);
		response.sendRedirect("Student_LoginPage.jsp");
		
		}
		else {
		String subject="OTP Generated";
		
		HttpSession session= request.getSession();
		String otp= (String)session.getAttribute("otp");
		String email= (String)session.getAttribute("email");
		Mail mail= new Mail(subject);
		mail.sendMailForOTP(email, otp);
		response.sendRedirect("StudentSignin.jsp");
		}
	}

}
