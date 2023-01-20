package com.revature.main.app;

import java.util.Scanner;

import com.revature.dao.PlaceOrderDao;
import com.revature.dao.UserDao;
import com.revature.dao.impl.PlaceOrderDaoImpl;
import com.revature.dao.impl.UserDaoImpl;
import com.revature.model.IdQuantity;

public class Application {
	public static String uid = "";
	public static IdQuantity p = new IdQuantity();

	public static void main(String[] args) {

		UserDao a = new UserDaoImpl();
		Scanner input = new Scanner(System.in);
		System.out.println("\n\n||****WELCOME TO KITCHEN BASKET *****||\n");
		a.getUser();
		// menu(input);

	}

// /*******************************************************************************/ //
	public static void menu(Scanner input) {
		int condition = 0;
		// do {
		System.out.println("========================== \nAdd items to the basket\n==========================");
		System.out.println("Press 1: Vegetables");
		System.out.println("Press 2: Fruits");
		System.out.println("Press 3: Spices");
		int i = input.nextInt();
		input.nextLine();
		// int c = i;
		PlaceOrderDao obj = new PlaceOrderDaoImpl();
		switch (i) {
		case 1:
			System.out.println(
					"========================================================\nWhich Vegetables would you like to add in your basket\n========================================================");
			System.out.println("PRODUCT_ID" + "         " + "VEGETABLE" + "          " + "PRICE");
			obj.getVegetables();
			int veg = 1;
			welcome(input, veg);

			break;
		case 2:
			System.out.println(
					"========================================================\nWhich Fruits would you like to add in your basket\n========================================================");
			System.out.println("PRODUCT_ID" + "         " + "FRUITS" + "          " + "PRICE");

			obj.getFruits();
			int fruit = 2;

			welcome(input, fruit);
			break;
		case 3:
			System.out.println(
					"========================================================\nWhich Spices would you like to add in your basket\n========================================================");
			System.out.println("PRODUCT_ID" + "         " + "SPICES" + "          " + "PRICE");

			obj.getSpices();
			int spices = 3;
			welcome(input, spices);
			break;

		default:
			System.out.println("wrong entry");
			menu(input);

		}
		// } while (condition == 0);
	}

// /*******************************************************************************************/ //
//ENTRY OR ADD PRODUCT
	public static int c;

	public static void welcome(Scanner input, int choice) {

		System.out.println(
				"========================================================\nEnter the id of the product\n========================================================");
		c = input.nextInt();
		input.nextLine();
		p.setPid(c);
		// PlaceOrderDaoImpl.plist.add();
		PlaceOrderDao obj = new PlaceOrderDaoImpl();

		switch (choice) {
		case 1:
			if (c > 104 && c < 109) {
				System.out.println("=======================\nPlease enter quantity\n=======================");
				int productQuantity = input.nextInt();
				p.setQuantity(productQuantity);
				PlaceOrderDaoImpl.plist.add(p);
				obj.tempCart(c, productQuantity);
			} else {
				System.err.println("=======================\nPlease enter valid input\n=======================");
				obj.getVegetables();

				welcome(input, choice);

			}
			break;
		case 2:
			if (c > 100 && c < 105) {
				System.out.println("=======================\nPlease enter quantity\n=======================");
				int productQuantity = input.nextInt();
				obj.tempCart(c, productQuantity);
				p.setQuantity(productQuantity);
				PlaceOrderDaoImpl.plist.add(p);
			} else {
				System.err.println("=======================\nPlease enter valid input\n=======================");
				obj.getFruits();

				welcome(input, choice);

			}
			break;
		case 3:
			if (c > 108 && c < 113) {
				System.out.println("=======================\nPlease enter quantity\n=======================");
				int productQuantity = input.nextInt();
				obj.tempCart(c, productQuantity);
				p.setQuantity(productQuantity);
				PlaceOrderDaoImpl.plist.add(p);
			} else {
				System.err.println("=======================\nPlease enter valid input\n=======================");
				obj.getSpices();

				welcome(input, choice);

			}
			break;

		}
	}
}
