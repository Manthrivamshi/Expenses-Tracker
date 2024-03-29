package com.jsp.expenseTracker.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//The class for which, programmer can create only one object
//To establish connection.

public class SingletonClass {

	private static SingletonClass sc;
	
	private Connection connect;
	
	private SingletonClass() {
		
	}
	
	public static SingletonClass getSingletonClassObject() {
		if(sc == null) {
			//create object of SingletonClass
			sc = new SingletonClass();
			System.out.println("Singleton object created....");
			System.out.println(sc);
			return sc;
		}
		return sc;
	}
	//to Establish connection
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/expencetracker?user=root&password=12345";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connect = DriverManager.getConnection(url);
			System.out.println("Connection Established......");
			return connect;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
}
