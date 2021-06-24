package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Item;
import com.revature.utils.ConnectionUtil;

public class ItemDao implements ItemDaoInterface {

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){//tries to establish a database connection
			ResultSet rs = null; //initialize an empty result set to store the results of our query
			
			String sql = "SELECT * FROM Items;"; //assigning the query to a string variable
			
			Statement s = conn.createStatement(); //creates an object to sent the query to our database
			
			rs = s.executeQuery(sql); // this will execute the query, using the statement object, and put it in our result set
			
			List<Item> itemList = new ArrayList<>(); //creates a list to be populated with the returned items
			
			while(rs.next()) { //while there are results left in the result set
				//create a new item object from each returned record
				Item t = new Item(
						rs.getInt("item_id"),
						rs.getString("item_name"),
						rs.getInt("obtain_method"),
						rs.getInt("item_type")
						);
				
				//add the newly created item object into the array list
				itemList.add(t);
				
			}
			return itemList;
			
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}

	@Override
	public void addItem(Item t) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO Items (item_name, obtain_method, item_type)"
					+"VALUES (?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);//prepared statements are for SQL commands with parameters
			
			//use the prepared statement object to insert values into the SQL query
			//the values will come from the Item object we sent in
			ps.setString(1, t.getItem_name());
			ps.setInt(2, t.getObtain_method());
			ps.setInt(3, t.getItem_type());
			
			ps.executeUpdate(); //we use executeUpdate for insertions, updates, and deletes
			
			//send confirmation to the console if successful
			System.out.println("New Item "+ t.getItem_name() + " added successfully");
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
		}
		
	}
	

	
}
