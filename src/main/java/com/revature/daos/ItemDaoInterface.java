package com.revature.daos;

import java.util.List;

import com.revature.models.Item;

public interface ItemDaoInterface {
	
	public List<Item> getItems();
	
	public void addItem(Item t);
	

	public void updateItemName(int itemID, String newName);
	public void updateObtainMethod(int itemID, int newMethod);
	public void updateItemType(int itemID, int newType);
	public void deleteItem(int itemID);

}
