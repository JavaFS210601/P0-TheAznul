package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.ItemDao;

public class Menu {
//the menu display options and control flow are contained in this method
	ItemDao ed = new ItemDao();
	public void display() {
		
		boolean displayMenu = true; //toggles menu visibility
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Starting Item Tracker System");
		System.out.println("********************************");
		System.out.println("This system is for tracking desirable items in the Destiny 2 game");
		
		while(displayMenu) {
			System.out.println("------------------");
			System.out.println("Choose an option");
			System.out.println("------------------");
			System.out.println("Type the command written in parenthesis (command), then hit enter");
			System.out.println("------------------");
			
			//menu options
			System.out.println("View current items (View)");
			System.out.println("Add an item (Add)");
			System.out.println("Remove an item (Remove)");
			System.out.println("Edit an existing item (Edit)");
			System.out.println("Exit the system (Exit)");
			
			
			String input = scan.nextLine().toLowerCase();
			//switch statement control flow
			switch(input) {
			
			case "view": {
				System.out.println("Listing all Items");
				List<Item> items = ed.getItems();
				for(Item t : items) {
					System.out.println(t);
				}
				
				break;
			}
			case "add": {
				
				System.out.println("Enter Item name");
				String item_name = scan.nextLine();
				System.out.println("Enter obtain method code: 1)Random Drop 2)Strikes 3)Nightfalls 4)Crucible 5)Gambit 6)Quest");
				int obtain_method = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter Item type code: 1)Weapon 2)Armor 3)Exotic Catalyst 4)Ship 5)Sparrow");
				int item_type = scan.nextInt();
				scan.nextLine();
				Item newItem = new Item(item_name, obtain_method, item_type);
				ed.addItem(newItem);
				
				break;
			}
			case "remove": {
				
				
				break;
				
			
			}
			case "edit": {
				
				break;
			}
			case "command": {
				System.out.println("That was an example, please select something else");
				break;
			}
			case "exit": {
				System.out.println("Exiting application");
				scan.close();
				break;
			}
			
			default: {
				System.out.println("That was not a valid command. Please try again");
			}
			}
			
			
		}
		
		
	}
	
	
	
	
}
