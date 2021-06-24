package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu;
import com.revature.utils.ConnectionUtil;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//testing connection from the ConnectionUtil class
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("connection successful, beginning application");
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		Menu menu = new Menu(); //menu is instantiated here
		menu.display(); //menu is displayed
		
		

	}

}
