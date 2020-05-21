package com.UI;

import java.util.Scanner;

import com.DBlink.DB;
import com.Users.Administator;

public class UI {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		Administator admin = new Administator();
		
		DB.connect();
		
		System.out.println("Type your username (admin)");
		
		switch (in.nextLine()) {
		case "admin": {
			admin.start();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + in.nextLine());
		}
		
		
		DB.close();
	}
}
