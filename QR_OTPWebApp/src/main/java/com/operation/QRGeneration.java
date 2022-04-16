package com.operation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qr.QRActions;

public class QRGeneration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//To Generate QR for registered Student	
		
		PrintWriter out= response.getWriter();
		String details= (String)request.getAttribute("hashedDetails");
		String filename= request.getParameter("SapID");
		System.out.println(details);
		
		try{
		String applicationPath = request.getServletContext().getRealPath("");
		String path=QRActions.generateQRCode(details,filename,applicationPath);
		out.println("Successfully generated QR Code");
		request.setAttribute("path", path);
		request.setAttribute("sendQRAttachment",true);
		RequestDispatcher rs= request.getRequestDispatcher("/MailService");
		rs.forward(request, response);
		
		}
		catch(Exception e) {
			out.println(e.getMessage());
		}
		
	}

}
