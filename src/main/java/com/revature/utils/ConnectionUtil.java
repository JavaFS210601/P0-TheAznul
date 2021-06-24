package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		
		//for compatibility with other technologies/frameworks, we will need to register our driver
		//this process makes the application aware of what Driver class (SQL dialect) we are using
		
		try {
			Class.forName("org.postgresql.Driver"); //try to find and return the postgreSQL driver class
		}
		catch(ClassNotFoundException e) {
			System.out.println("Class was not found");
			e.printStackTrace();
		}
		
		//We need to provide the database credentials
		//format for connections: jdbc:postgresql://{host}[:{port}]/[{database}]
		//the curly braces {} and square brackets[] are not needed. Remove them
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=public";
		String username = "postgres";
		String password = "password";
		
		
		return DriverManager.getConnection(url, username, password);
	}
	

}
