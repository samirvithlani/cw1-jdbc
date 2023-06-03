package com.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

public class UserController {
	
	public void deleteUserByName() {
		
		Connection conn = DBConnection.getDBConnection();
		Scanner sc = new Scanner(System.in);
		if(conn!=null) {
			
			
			//statement creation
			
			
			try {
				Statement stmt = conn.createStatement();
				
				//create Query
				System.out.println("enter name to delete...");
				String name  =sc.next();
				String deleteSQL = "delete from users where uname = '"+name+"'";
				//submit query to db;
				
				int res = stmt.executeUpdate(deleteSQL);
				if(res>0) {
					
					System.out.println(res + " raws deleted....");
				}
				else {
					System.out.println(res + " raws deleted....");
				}
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		
	}
	public void deleteUser() {
		
		//connection
		
		Connection conn = DBConnection.getDBConnection();
		Scanner sc = new Scanner(System.in);
		if(conn!=null) {
			
			
			//statement creation
			
			
			try {
				Statement stmt = conn.createStatement();
				
				//create Query
				System.out.println("enter id to delete...");
				int id = sc.nextInt();
				String deleteSQL = "delete from users where uid = "+id+"";
				//submit query to db;
				
				int res = stmt.executeUpdate(deleteSQL);
				if(res>0) {
					
					System.out.println(res + " raws deleted....");
				}
				else {
					System.out.println(res + " raws deleted....");
				}
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

	public void addUser() {

		// connection... logic ? no
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getDBConnection();
		if (conn != null) {

			// create statement .. statement intarface
			// to compile query
			try {
				Statement stmt = conn.createStatement();
				// 4th stpes
//				String insertSQl = "insert into users(uname,uage)values('samir',12)";
				System.out.println("enter name");
				String name  = sc.next();
				System.out.println("enter age");
				int age = sc.nextInt();
				String insertSQl = "insert into users(uname,uage)values('"+name+"',"+age+")";
				/// submit query 3 methods update() -> boolean, executeUpdate() ->int

				int res = stmt.executeUpdate(insertSQl);
				if (res > 0) {
					System.out.println("record inserted succefully..");
				} else {
					System.out.println("record not insterted...");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	//resultSet
	
	public void getAllUsers() {
		//connectino
		Connection conn = DBConnection.getDBConnection();
		if(conn!=null) {
			
			try {
				Statement stmt = conn.createStatement();
				String selectSQL = "select * from users";
				ResultSet rs = stmt.executeQuery(selectSQL);
				System.out.println("UID  NAME  AGE");
				while(rs.next()) {
					System.out.print(" "+rs.getInt("uid"));
					System.out.print(" "+rs.getString("uname"));
					System.out.print(" "+rs.getInt("uage"));
					System.out.println();
					
				}
								
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}

	public static void main(String[] args) {

		UserController controller = new UserController();
		//controller.addUser(); //switch case...
		//controller.deleteUser();
		//controller.deleteUserByName();
		controller.getAllUsers();

	}
}
