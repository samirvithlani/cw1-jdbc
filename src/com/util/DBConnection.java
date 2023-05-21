package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	private final static String userName = "root";
	private final static String Password = "root";
	//cw1java is database name
	private final static String connectionURL = "jdbc:mysql://localhost:3306/cw1java";
	private final static String DriverClass = "com.mysql.jdbc.Driver";
			
		
	public static Connection getDBConnection() {
				
		Connection conn = null;
		//1st step load driver class in memory...
		try {
			Class.forName(DriverClass);
			//2nd create connection
			
			conn = DriverManager.getConnection(connectionURL, userName, Password);
			
			if(conn!=null) {
				
				System.out.println("datbase connected...");
			}
			else {
				System.out.println("not connected...");
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return conn;
	}
	
	
	
	public static void main(String[] args) {
		
		
		DBConnection.getDBConnection();
		
		
	}
}
