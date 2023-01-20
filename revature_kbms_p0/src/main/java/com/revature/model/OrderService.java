package com.revature.model;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderService {
	Scanner input = new Scanner(System.in);
	private static ArrayList<Order> list = new ArrayList<Order>();

	// static {
//	}
	public void placeOrder(Order order) {
		list.add(order);
	}

	public void getDetails() {
		for (Order order : list)
			System.out.println(order);
	}

	public void updateOrder(int id) {

		System.out.println("Press 1: update ProductName");
		System.out.println("Press 2: update Quantity");
		System.out.println("Press 3: update Price");
		System.out.println("Press 4: update Status ");
		int i = Integer.parseInt(input.nextLine());

		switch (i) {
		case 1:
		}
	}
}
