package com.Users;

import com.UI.UI;

public class UserCustomer {
	
	public void start() {
		
		boolean running = true;
		
		do {
		
			System.out.println("Type \'create\' to create a new record, \'read\' to read records, \'update\' to update records, \'delete\' to delete records, \'exit\' to exit");
	
			String option = UI.in.next();
				
			switch (option) {
			case "create":
				System.out.println("Create");
				break;
			case "read":
				System.out.println("Read");
				break;
			case "update":
				System.out.println("Update");
				break;
			case "delete":
				System.out.println("Delete");
				break;
			case "exit":
				System.out.println("Exiting");
				running = false;
				break;
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
			}
		} while (running);
	}
	

	private void create() {
		System.out.println("Which table would you like to create a record for?");
		System.out.println("Type \'customer\' to add customers, \'product\' to add products, \'order\' for orders, \'return\' to return to original menu");
		
		String option = UI.in.next();
		
		switch (option) {
		case "customer":
			System.out.println("customer");
			break;
		case "product":
			System.out.println("product");
			break;
		case "order":
			System.out.println("order");
			break;
		case "return":
			System.out.println("Returning");
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}


}
