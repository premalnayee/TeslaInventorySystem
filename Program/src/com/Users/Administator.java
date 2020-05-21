package com.Users;

import com.UI.UI;
import com.objects.Customer;
import com.objects.Order;
import com.objects.Product;

public class Administator {

	public void start() {
		
		boolean running = true;
		
		do {
		
			System.out.println("Type \'create\' to create a new record, \'read\' to read records, \'update\' to update records, \'delete\' to delete records, \'exit\' to exit");
	
			String option = UI.in.nextLine();
				
			switch (option) {
			case "create":
				create();
				break;
			case "read":
				read();
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
		
		String option = UI.in.nextLine();
		
		switch (option) {
		case "customer":
			
			// Take information from user
			System.out.println("Enter customers first name");
			String FirstName = UI.in.nextLine();
			
			System.out.println("Enter customers last name");
			String LastName = UI.in.nextLine();
			
			System.out.println("Enter customers address");
			String Address = UI.in.nextLine();
			
			System.out.println("Enter customers email address");
			String EmailAddress = UI.in.nextLine();
			
			System.out.println("Enter customers age");
			int Age = Integer.parseInt(UI.in.nextLine());
			
			System.out.println("Enter customers phone number");
			String PhoneNumber = UI.in.nextLine();
			
			
			// Confirm with user
			System.out.println("Would you like to add this customer to the system y/n");
			
			switch (UI.in.nextLine()) {
				case "n": 
					System.out.println("Returning to main screen");
					break;
				case "y":
					System.out.println("Entering to system");
					Customer newCust = new Customer(FirstName, LastName, Address, EmailAddress, PhoneNumber, Age);
					newCust.addToDb();
					System.out.println("Added, returning to main menu \n");
					break;
				default:
					System.out.println("Error, try again");
			}

		case "product":
			
			// Take information from user
			System.out.println("Enter the products name");
			String ProdName = UI.in.nextLine();
			
			System.out.println("Enter the products colour");
			String colour = UI.in.nextLine();
			
			System.out.println("Enter the products battery size");
			String batterySize = UI.in.nextLine();
			
			System.out.println("Enter the products autopilot (y/n)");
			boolean autopilot = askUserForBoolean();
			
			System.out.println("Enter the products dualmotor (y/n)");
			boolean dualmotor = askUserForBoolean();
			
			System.out.println("Enter the products release date (yyyy-mm-dd)");
			String releaseDate = UI.in.nextLine();
			
			System.out.println("Enter the products delay");
			String prodDelay= UI.in.nextLine();
			
			System.out.println("Enter the products price");
			int prodPrice= Integer.parseInt(UI.in.nextLine());
			
			// Confirm with user
			System.out.println("Would you like to add this product to the system y/n");
			switch (UI.in.nextLine()) {
				case "n": 
					System.out.println("Returning to main screen");
					break;
				case "y":
					System.out.println("Entering to system");
					Product newProd = new Product(ProdName, colour, batterySize, autopilot, dualmotor, releaseDate, prodDelay, prodPrice);
					newProd.addToDb();
					System.out.println("Added, returning to main menu \n");
					break;
				default:
					System.out.println("Error, try again");
		}
			break;
			
		case "order":
			// Take information from order
			System.out.println("Enter the custID for the order");
			int custID = Integer.parseInt(UI.in.nextLine());
			
			System.out.println("Would you like warranty with the order? (y/n)");
			boolean warranty = askUserForBoolean();
			
			System.out.println("Payment method");
			String paymentMethod = UI.in.nextLine();
			
			System.out.println("What is the total of the order");
			int total = Integer.parseInt(UI.in.nextLine());
			
			// Confirm with user
			System.out.println("Would you like to add this product to the system y/n");
			switch (UI.in.nextLine()) {
				case "n": 
					System.out.println("Returning to main screen");
					break;
				case "y":
					System.out.println("Entering to system");
					Order newOrd = new Order(custID, warranty, paymentMethod, total);
					newOrd.addToDb();
					System.out.println("Added, returning to main menu \n");
					break;
				default:
					System.out.println("Error, try again\n");
			}
			break;
			
		case "return":
			System.out.println("Returning");
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}
	
	boolean askUserForBoolean() {
		String option = UI.in.nextLine();
		switch (option) {
		case "y": {
			return true;
		}
		case "n":
			return false;
		default:
			System.out.println("Error, try again");
			throw new IllegalArgumentException("Unexpected value: " + option);
		}
	}

	private void read() {
		System.out.println("Which table would you like to create a record for?");
		System.out.println("Type \'customer\' to add customers, \'product\' to add products, \'order\' for orders, \'return\' to return to original menu");
		
		switch(UI.in.nextLine()) {
		
		case "customer":
			System.out.println("Enter the CustID of the customer you would like to view");
			int custIDView = Integer.parseInt(UI.in.nextLine());
			
			// Get the details of the customer from the database using the ID
			Customer readCustomer;
			try {
				readCustomer = new Customer(custIDView);
				System.out.println(readCustomer.toString() + "\n");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Number format exception");
			}
			break;
		case "product":
			System.out.println("Enter the ProdID of the product you would like to view");
			int  prodIDView = Integer.parseInt(UI.in.nextLine());
			
			// Get the details of the products from the database using the ID
			try {
				Product readProduct = new Product(prodIDView);
				System.out.println(readProduct.toString() + "\n");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Number format exception");
			}
			break;
		case "order":
			System.out.println("Enter the orderID of the order you would like to view");
			int orderIDView = Integer.parseInt(UI.in.nextLine());
			
			// Get the details of the products from the database using the ID
			try {
				Order readOrder = new Order(orderIDView);
				System.out.println(readOrder.toString() + "\n");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Number format exception");
			}
			
			break;
		case "return":
			System.out.println("Returning... \n");
		}
		
		
	}
	
}
