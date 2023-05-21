package com.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConnection;

public class UserController {

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

	public static void main(String[] args) {

		UserController controller = new UserController();
		controller.addUser();

	}
}
