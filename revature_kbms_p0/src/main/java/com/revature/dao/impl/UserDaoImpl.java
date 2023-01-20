package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.app.mysqljdbc.AppResource;
import com.revature.config.DatabaseConnection;
import com.revature.dao.UserDao;
import com.revature.main.app.*;
import com.revature.model.User;

public class UserDaoImpl implements UserDao {
@Override
public void getUser() {
	String userid=null;
	String password=null;
	Scanner s=new Scanner(System.in);
	User u=new User();
	Connection con = null;
	con = DatabaseConnection.getConnection();
	try {
		
		System.out.print("\nPlease enter userId from the table:");
		userid = s.nextLine();

		System.out.print("\nPlease enter password from the table:");
		password = s.nextLine();

		java.sql.Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM User2");
		if (rs.next()) {
			if (userid.equals(rs.getString(1)) && password.equals(rs.getString(2))&& rs.getString(3).equals("Customer")) {
				Application.uid=userid;
				Application.menu(s);
			} else {
				System.out.println("\tInvalid userid or password");
			}
		} else {
			System.out.println("\tInvalid userid or password");
		}

	} catch (SQLException e) {
		System.out.println("Exception" + e.getMessage());
	}
	try {
		con.close();
	} 
	catch (SQLException e) {}
}

}