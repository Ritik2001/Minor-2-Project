package com.operation;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dataBase.DBConnection;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.qr.QRActions;

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024,
		maxFileSize = 1024 * 1024 * 5, 
		maxRequestSize = 1024 * 1024 * 5 * 5)
public class Student_OTP_QR_Verify extends HttpServlet {
		
	private static final String UPLOAD_DIR = "uploads";
	//	String uploadPath ="/home/ec2-user/serverSide/";
	//"C:\\Users\\Dell\\Desktop\\ServerSide\\"; 
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  	PrintWriter out= response.getWriter();
		HttpSession session= request.getSession(); 
		boolean isOTPCorrect=false, isQRCorrect=false;
		String sapid= (String)session.getAttribute("sapid");
		String sessionOTP= (String)session.getAttribute("otp");
		
		String OTP_Entered= request.getParameter("otp");
		//String filename= sapid;
		System.out.println(" SapID "+sapid+" session OTP "+sessionOTP+" entered otp "+OTP_Entered);
		
		if(OTP_Entered.equals(sessionOTP))
		{
			isOTPCorrect=true;
		}
		
		  // To Read a QR Uploaded by a student
		  // gets absolute path of the web application
		
	      String applicationPath = request.getServletContext().getRealPath("");
	      // constructs path of the directory to save uploaded file
	      String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
	       
	      // creates the save directory if it does not exists
	      File fileSaveDir = new File(uploadFilePath);
	      if (!fileSaveDir.exists()) {
	          fileSaveDir.mkdirs();
	      }
	      
	      System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
	      
	      String fileName = null;
	      //Get all the parts from request and write it to the file on server
	      for (Part part : request.getParts()) {
	    	  System.out.println("Success 1");
	    	  System.out.println(part.getHeader("content-disposition"));
	          fileName = getFileName(part);
	          if(!fileName.equals(""))
	          {
	        	part.write(uploadFilePath + File.separator + fileName);  
	          }
	          
	      }
	      
	    request.setAttribute("message", fileName + " File uploaded successfully!");
	    
		Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        String extractedDetails=null;
        
        try {
        	
        extractedDetails = QRActions.readQRCode(uploadFilePath+ File.separator+ fileName, hintMap);
        System.out.println("Successful "+ extractedDetails);
        Files.deleteIfExists(Paths.get(uploadFilePath+ File.separator+ fileName));
		Connection con= DBConnection.getConnection();
		String query="SELECT * FROM student_registration WHERE sap_id=? AND qrcodedetail=?";
		PreparedStatement st= con.prepareStatement(query);
		st.setString(1, sapid);
        st.setString(2,extractedDetails);
        
        ResultSet rs= st.executeQuery();
        
        if(rs.next()) {
        	isQRCorrect=true;
        	}
        
        if(isOTPCorrect && isQRCorrect)
        {
        	getServletContext().getRequestDispatcher("/markAttendance").forward(
                    request, response);
//        	RequestDispatcher rd= request.getRequestDispatcher("/markAttendance");
//        	rd.forward(request, response);
        }
        else {
        	response.sendRedirect("StudentSignin.jsp?VerificationFailed=yes");
        }
        
       }
        catch(Exception e) {
        	out.print(e.getMessage());
        }
    
	}
  
  private String getFileName(Part part) {
      String contentDisp = part.getHeader("content-disposition");
      System.out.println("content-disposition header= "+contentDisp);
      String[] tokens = contentDisp.split(";");
      for (String token : tokens) {
          if (token.trim().startsWith("filename")) {
              return token.substring(token.indexOf("=") + 2, token.length()-1);
          }
      }
      return "";
  }

}
