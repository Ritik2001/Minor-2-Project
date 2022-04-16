package com.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static String url="";
	private static String username="";
	private static String password="";
	private static Connection con=null;
	static public Connection getConnection() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection(url,username,password);
		
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		return con;
	}
}
