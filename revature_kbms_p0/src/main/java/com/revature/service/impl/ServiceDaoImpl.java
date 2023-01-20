package com.revature.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.model.IdQuantity;
import com.revature.model.Product;
import com.revature.serviceDao.ServiceforPlaceOrder;

public class ServiceDaoImpl implements ServiceforPlaceOrder{
	
	static List<Product> l = new ArrayList<>();
	static Scanner input = new Scanner(System.in);

	
	///////////////////////////////////////////////////////////////////////////////
	//to update records in pr
	@Override
	public  void reflectChanges(IdQuantity p) {
		Connection con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "root");

			
			// String updateQuery = Constants.UPDATE_COUNT;
			//String sql = "UPDATE PRODUCT p join order_details o  on p.PRODUCT_ID=o.PRODUCT_ID set PRODUCT_COUNT = (p.PRODUCT_COUNT - ?) where p.PRODUCT_ID = ? ";
			// System.out.println("IN reflect");
			String sql = "UPDATE PRODUCT SET PRODUCT_COUNT = PRODUCT_COUNT - ? WHERE PRODUCT_ID =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(2, p.getPid());
			ps.setInt(1, p.getQuantity());	

			int n=ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		try {

			con.close();
		} catch (SQLException e) {
		}

	}


	}
////////////////////////////////////////////////////////////////////////////
