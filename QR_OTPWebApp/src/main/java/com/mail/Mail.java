package com.mail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {
	
	private String to;
	private String from="itdesk.upes@gmail.com";
	private String subject;
	private String message="Your Registration is done. Use Given QR for marking your Attendance";
	private Properties properties=null;
	private Session session=null;
	private String SMTP_USERNAME = "";
	private String SMTP_PASSWORD = "";
	private String HOST ="";
	
	
	public Mail(String subject){
		
		this.subject= subject;
		setServerProperties();
		session = getSession();
		session.setDebug(true);
	}
	
	public void sendMailForOTP(String recepient, String otp) {
			to= recepient;
		MimeMessage mail= new MimeMessage(session);
		
		try {
			
			mail.setFrom(new InternetAddress("itdesk.upes@gmail.com"));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mail.setSubject(subject);
			mail.setText("Dear Student, Your One-time PIN is: "+otp);
			Transport transport= session.getTransport();
			transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
			transport.sendMessage(mail, mail.getAllRecipients());
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println("Successfully Sent Email");
	}
	
	public void sendMailWithQRAttachment(String recipient, String path) {
		
		to= recipient;
		MimeMessage mail= new MimeMessage(session);
		
		try {
			mail.setFrom(new InternetAddress(from));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mail.setSubject(subject);
			
			MimeMultipart multipart= new MimeMultipart();
			
			MimeBodyPart text= new MimeBodyPart();
			MimeBodyPart file= new MimeBodyPart();
			
			text.setText(message);
			file.attachFile(new File(path));
			
			multipart.addBodyPart(text);
			multipart.addBodyPart(file);
			mail.setContent(multipart);
			Transport transport= session.getTransport();
			transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
			transport.sendMessage(mail, mail.getAllRecipients());
			
//			Transport.send(mail);
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	private void setServerProperties() {
		
//		String host="smtp.gmail.com";
//		properties.put("mail.smtp.host",host);
		properties= System.getProperties();
		properties.put("mail.transport.protocol","smtp");
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.auth", "true");
	    properties.setProperty("mail.smtp.starttls.enable", "true");
	    properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		
//		properties.put("mail.smtp.host",host);
//		properties.put("mail.smtp.port","587");
//	    properties.put("mail.smtp.auth", "true");
//	    properties.setProperty("mail.smtp.starttls.enable", "true");
//	    properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
//		properties.put("mail.smtp.port","465");
//	    properties.put("mail.smtp.ssl.enable","true");
//	    properties.put("mail.smtp.auth","true");

	}
	

	private Session getSession() {
		
		return Session.getDefaultInstance(properties);
			
	}
	


}
