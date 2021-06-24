package com.revature.models;

public class Item {
	
	private int item_id;
	private String item_name;
	private int obtain_method;
	private int item_type;
	
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}


//all arguments constructor
	public Item(int item_id, String item_name, int obtain_method, int item_type) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.obtain_method = obtain_method;
		this.item_type = item_type;
	}


//constructor without ID
	public Item(String item_name, int obtain_method, int item_type) {
		super();
		this.item_name = item_name;
		this.obtain_method = obtain_method;
		this.item_type = item_type;
	}


	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_name=" + item_name + ", obtain_method=" + obtain_method
				+ ", item_type=" + item_type + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + item_id;
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		result = prime * result + item_type;
		result = prime * result + obtain_method;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (item_id != other.item_id)
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		if (item_type != other.item_type)
			return false;
		if (obtain_method != other.obtain_method)
			return false;
		return true;
	}


	public int getItem_id() {
		return item_id;
	}


	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}


	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public int getObtain_method() {
		return obtain_method;
	}


	public void setObtain_method(int obtain_method) {
		this.obtain_method = obtain_method;
	}


	public int getItem_type() {
		return item_type;
	}


	public void setItem_type(int item_type) {
		this.item_type = item_type;
	}



	


	
	

}
