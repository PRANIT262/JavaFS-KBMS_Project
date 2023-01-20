package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.PlaceOrderDao;
import com.revature.main.app.Application;
import com.revature.model.IdQuantity;
import com.revature.model.Order;
import com.revature.model.Product;
import com.revature.service.impl.ServiceDaoImpl;
import com.revature.serviceDao.ServiceforPlaceOrder;
import com.revature.util.dateUtil;

public  class PlaceOrderDaoImpl extends Product implements PlaceOrderDao {
	static Scanner input = new Scanner(System.in);
	static List<Product> l = new ArrayList<>();

//ACCESSING/FETCH DATA FROM PRODUCT TABLE 
	Application app = new Application();

	/////////////////

	public static List<IdQuantity> plist=new ArrayList<>();
	
	
//TO FETCH VEG FROM TABLE
	public  void getVegetables() {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "root");
			// System.out.println("Connection Established");
			java.sql.Statement stm = con.createStatement();
			String sql = "SELECT * FROM product WHERE TYPE_OF_PRODUCT = \"vegitable\"";
			ResultSet rs = stm.executeQuery(sql);
			// System.out.println("PRODUCT_ID"+" "+"PRODUCT_NAME"+" "+"PRICE_PER_UNIT");
			while (rs.next()) {
				int productId = rs.getInt("PRODUCT_ID");
				String prodctName = rs.getString("PRODUCT_NAME");
				Double perPriceProduct = rs.getDouble("PRICE_PER_UNIT");
				System.out.println("  " + productId + "              " + prodctName +  "      " + perPriceProduct);
				Product p = new Product();
				p.setProductId(productId);
				p.setProductName(prodctName);
				p.setPricePerUnit(perPriceProduct);
				l.add(p);
				//ServiceDaoImpl.reflectChanges(Application.c);

			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}
// /********************************************************************/ //
// TO FETCH FRUITS FROM DB
	public  void getFruits() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "root");
			// System.out.println("Connection Established");
			java.sql.Statement stm = con.createStatement();
			String sql = "SELECT * FROM product WHERE TYPE_OF_PRODUCT = \"fruit\"";
			ResultSet rs = stm.executeQuery(sql);
			// System.out.println("PRODUCT_ID"+" "+"PRODUCT_NAME"+" "+"PRICE_PER_UNIT");
			while (rs.next()) {
				int productId = rs.getInt("PRODUCT_ID");
				String prodctName = rs.getString("PRODUCT_NAME");
				Double perPriceProduct = rs.getDouble("PRICE_PER_UNIT");
				System.out.println("  " + productId + "              " + prodctName + "      " + perPriceProduct);
				Product p = new Product();
				p.setProductId(productId);
				p.setProductName(prodctName);
				p.setPricePerUnit(perPriceProduct);
				l.add(p);
				//ServiceDaoImpl.reflectChanges(Application.c);

			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

// /******************************************************************************/ //	
// TO FETCH SPICES FROM DB
	public  void getSpices() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "root");
			// System.out.println("Connection Established");
			java.sql.Statement stm = con.createStatement();
			String sql = "SELECT * FROM product WHERE TYPE_OF_PRODUCT = \"Spices\"";
			ResultSet rs = stm.executeQuery(sql);
			// System.out.println("PRODUCT_ID"+" "+"PRODUCT_NAME"+" "+"PRICE_PER_UNIT");
			while (rs.next()) {
				int productId = rs.getInt("PRODUCT_ID");
				String prodctName = rs.getString("PRODUCT_NAME");
				Double perPriceProduct = rs.getDouble("PRICE_PER_UNIT");
				System.out.println("  " + productId + "              " + prodctName + "      " + perPriceProduct);
				Product p = new Product();
				p.setProductId(productId);
				p.setProductName(prodctName);
				p.setPricePerUnit(perPriceProduct);
				l.add(p);
				//ServiceDaoImpl.reflectChanges(Application.c);

			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

	// TO ADD DATA/OBJECT IN ARRAYLIST FOR TEMPORARY
	static List<Order> list = new ArrayList<>();

	public  void tempCart (int productID, int productQuantity) {

		Order order = new Order();
		order.setOrderId(1);
		order.setQuantity(productQuantity);

		for (Product p : l) {
			if (p.getProductId() == productID) {
				order.setproductId(String.valueOf(productID));
				order.setTotalPrice(p.getPricePerUnit() * productQuantity);
				break;
			}
		}
		list.add(order);

		// .out.println("OrderId: "+order.getOrderId()+"orderQuantity:
		// "+order.getQuantity());
		System.out.println(
				"==============================================\nIf you want to add more product Press:1\nIf you want go to your final cart Press:0\n==============================================");
		// System.out.println("If you want go to your final cart
		// Press:0\n==============================================");
		int y = input.nextInt();
		if (y == 1) {
			Application.menu(input);

		} else if (y == 0) {
			
			finalCart();
			
		} else {
			System.err.println("Please enter valid input");
		}
		

	}

	/////////////////////////////////////////////////////////////
	// FINAL CART INSERT TO DB
	ServiceforPlaceOrder serviceDao=new ServiceDaoImpl();
	public  void finalCart() {

		int totalVal = 0;
		int totalQuantity = 0;
		for (Order o : list) {
			totalVal += o.getTotalPrice();
			totalQuantity++;

		}
		System.out.println(
				"========================================================\nYour final cart value is:" + totalVal);
		System.out.println("To confirm order Press:1\n========================================================");
		int x = input.nextInt();
		input.nextLine();

		if (x == 1) {
			int id = 0;
			for (Order o : list) {
				Connection con = null;

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					// System.out.println("Driver Loaded");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "root");
					// System.out.println("Connection Established");
					java.sql.Statement stm = con.createStatement();

					String sql = "INSERT INTO order_details (PRODUCT_ID,USERNAME_LOGIN,QUANTITY,TOTAL_PRICE,ORDER_DATE,STATUS) VALUES (?,?,?,?,?,?)";
					// java.sql.PreparedStatement cs;
					PreparedStatement ps = con.prepareStatement(sql);
					// ps.setInt(1,1);
					ps.setString(1, o.getproductId());
					ps.setString(2, Application.uid);
					ps.setInt(3, o.getQuantity());
					ps.setDouble(4, totalVal);
					ps.setString(5, dateUtil.getCurrentDateTime());
					ps.setString(6, "confirm");
				
					ps.executeUpdate();
					
					for(IdQuantity i:PlaceOrderDaoImpl.plist) {
						serviceDao.reflectChanges(i);
						}
					
				} catch (ClassNotFoundException | SQLException e) {
					System.out.println(e.getMessage());
				}

			}
			System.out.println(
					"========================================================\nCongratulations Your order is placed sucessfully\nTHANK YOU FOR VISITING\n========================================================");
			System.out.println("\nPress:1 for order details");
			int i = input.nextInt();
			input.nextLine();
			if (i == 1) {
				System.out.println(
						"========================================================================\nORDER_ID   PRODUCT_ID   TOTAL_PRICE     ORDER_DATE     STATUS\n");

				getDetails();
			}

		}
	}

/////////////////////////////////////////////////////////////
//  TO GET/FETCH DATA FROM ORDER_DETAILS TABLE
	public  void getDetails() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kbms_project", "root", "root");
			// System.out.println("Connection Established");
			java.sql.Statement stm = con.createStatement();
			String sql = "SELECT * FROM order_details ";
			ResultSet rs = stm.executeQuery(sql);
			// System.out.println("PRODUCT_ID"+" "+"PRODUCT_NAME"+" "+"PRICE_PER_UNIT");
			while (rs.next()) {
				int orderID = rs.getInt("ORDER_ID");
				String productId = rs.getString("PRODUCT_ID");
				Double totalPrice = rs.getDouble("TOTAL_PRICE");
				String orderDate = rs.getString("ORDER_DATE");
				String status = rs.getString("STATUS");
				System.out.println("  " + orderID + "           " + productId + "          " + totalPrice + "        "
						+ orderDate + "     " + status);
				Product p = new Product();
				Order o = new Order();
				o.setOrderId(orderID);
				o.setTotalPrice(orderID);
				o.setOrderDate(orderDate);
				o.setStatus(status);
				// p.setProductId(productId);
				// l.add(p);

			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

}