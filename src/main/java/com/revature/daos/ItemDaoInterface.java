package com.revature.daos;

import java.util.List;

import com.revature.models.Item;

public interface ItemDaoInterface {
	
	public List<Item> getItems();
	
	public void addItem(Item t);
	
	

}
