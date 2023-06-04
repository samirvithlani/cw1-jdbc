package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBConnection;

public class BarchProcessiong {

	public void addProduct() {

		Connection conn = DBConnection.getDBConnection();
		if (conn != null) {

			String insertSQL = "insert into product(pname,pprice,pqty)values(?,?,?)";

			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, "Ihone 15");
				pstmt.setInt(2, 200000);
				pstmt.setInt(3, 1);
				// create batch and add product to batch
				pstmt.addBatch();
				pstmt.setString(1, "Samsung f20");
				pstmt.setInt(2, 45678);
				pstmt.setInt(3, 10);
				pstmt.addBatch();
				//exceyte that bacth..
				//int res = pstmt.executeUpdate()
				int res[] = pstmt.executeBatch();
				if(res.length>0) {
					System.out.println(res.length + " product inserted...");
				}
				else {
					
					System.out.println(res.length + " product inserted...");
					
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	public static void main(String[] args) {
		
		
		BarchProcessiong b1 = new BarchProcessiong();
		b1.addProduct();
	}
}
