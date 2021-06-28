package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Item;
import com.revature.utils.ConnectionUtil;

public class ItemDao implements ItemDaoInterface {

	final Logger log = LogManager.getLogger(ItemDao.class);
	
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
			log.warn("Database connection failed, read did not succeed");
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
			
			log.info("User has added a new item. The item name is " + t.getItem_name());
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
			log.warn("Database connection failed, add item did not succeed");
		}
		
	}
	
	public void updateItemName(int itemID, String newName) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE items SET item_name = ? WHERE item_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setInt(2, itemID);
			
			ps.executeUpdate();
			
			System.out.println("Item "+ itemID + " renamed to " + newName);
			
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
			log.warn("Database connection failed, update did not succeed");
		}
		
	}

	public void updateObtainMethod(int itemID, int newMethod) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE items SET obtain_method = ? WHERE item_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, newMethod);
			ps.setInt(2, itemID);
			
			ps.executeUpdate();
			
			System.out.println("Item "+ itemID + " obtain method adjusted to " + newMethod);
			
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
			log.warn("Database connection failed, update did not succeed");
		}
		
	}
	public void updateItemType(int itemID, int newType) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE items SET item_type = ? WHERE item_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, newType);
			ps.setInt(2, itemID);
			
			ps.executeUpdate();
			
			System.out.println("Item "+ itemID + " item type adjusted to " + newType);
			
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
			log.warn("Database connection failed, update did not succeed");
		}
		
		
	}
	
	public void deleteItem(int itemID) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM items WHERE item_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, itemID);
			
			ps.executeUpdate();
			
			System.out.println("Item "+ itemID + " has been deleted");
			log.info("User deleted item of id " +itemID);
			
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
			log.warn("Database connection failed, delete did not succeed");
		}
		
	}
	

	
	
}
