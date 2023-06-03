package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConnection;

public class ProductController {

	
	public void updateProduct() {
		
		Connection conn = DBConnection.getDBConnection();
		Scanner sc = new Scanner(System.in);
		if(conn!=null) {
			
			String updateSQL = "update product set pname=?,pprice=?,pqty=? where pid =?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(updateSQL);
				
				System.out.println("enter product name to update..");
				String pName=  sc.next();
				System.out.println("enter pprice to update");
				int pprice = sc.nextInt();
				System.out.println("enter pqty to update");
				int pqty = sc.nextInt();
				System.out.println("enter product id to update rec");
				int pid = sc.nextInt();
				pstmt.setString(1, pName);
				pstmt.setInt(2, pprice);
				pstmt.setInt(3, pqty);
				pstmt.setInt(4, pid);
				
//				pstmt.setString(1, "Iphone14 pro");
//				pstmt.setInt(2, 140000);
//				pstmt.setInt(3, 12);
//				pstmt.setInt(4, 1);
//				
				int res = pstmt.executeUpdate();
				if(res>0) {
					System.out.println("products updated...");
				}
				else {
					System.out.println("products not updated.,,,");
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public void addProduct() {
		
		Connection conn = DBConnection.getDBConnection();
		Scanner sc = new Scanner(System.in);
		if(conn!=null) {
			
			//plcaeHolder...
			String insertSQL = "insert into product(pname,pprice,pqty)values(?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
			
				
						
				pstmt.setString(1, "Iphone");
				pstmt.setInt(2, 120000);
				pstmt.setInt(3, 10);
//				pstmt.setInt(4, 1);
				
				int res = pstmt.executeUpdate();
				if(res>0) {
					System.out.println("product inserted..");
				}
				else {
					System.out.println("product not inserted...");
				}
								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		
		
	}
	public static void main(String[] args) {
		
		ProductController productController = new ProductController();
		//productController.addProduct();
		productController.updateProduct();
	}
}
