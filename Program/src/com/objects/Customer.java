package com.objects;

import java.sql.SQLException;

import com.DBlink.DB;
import com.mysql.cj.xdevapi.PreparableStatement;

//import java.util.HashMap;

public class Customer {

//	private HashMap<String, String> customerParameters = new HashMap<>();
//
//
//	public Customer() {
//		customerParameters.put("FirstName", null);
//		customerParameters.put("LastName)", null);
//		customerParameters.put("Address", null);
//		customerParameters.put("EmailAddress", null);
//		customerParameters.put("PhoneNumber", null);
//		customerParameters.put("Age", null);
//	}
//
//
//	/**
//	 * @return the customerParameters
//	 */
//	public HashMap<String, String> getCustomerParameters() {
//		return customerParameters;
//	}
//
//
//	/**
//	 * @param customerParameters the customerParameters to set
//	 */
//	public void setCustomerParameters(HashMap<String, String> customerParameters) {
//		this.customerParameters = customerParameters;
//	}
	
	private int CustID;
	private String FirstName;
	private String LastName;
	private String Address;
	private String EmailAddress;
	private String PhoneNumber;
	private int Age;
	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param emailAddress
	 * @param phoneNumber
	 * @param age
	 */
	public Customer(String firstName, String lastName, String address, String emailAddress, String phoneNumber,
			int age) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		EmailAddress = emailAddress;
		PhoneNumber = phoneNumber;
		Age = age;
	}
	
	public String getFromDB(int custID) throws SQLException {
		DB.connect();
		System.out.println(DB.exQuery("SELECT * FROM CUSTOMERS").getString(custID));
		DB.close();
		return "";
	}
	
	public void addToDb() {
		DB.connect();
//		System.out.println(DB.exUpdate("INSERT INTO Customers VALUES (FirstName = ?)");
	}
	
	public String createAddQuery() {
		String Query = "INSERT INTO Customers (FirstName, LastName, Address, EmailAddress, PhoneNumber, Age) ";
		Query += "VALUES (" + FirstName + ", " + LastName + ", " + Address + ", " + EmailAddress + ", "+ PhoneNumber + ", "+ Age + ")";
		return Query;
	}
	
	
	/**
	 * @return the custID
	 */
	public int getCustID() {
		return CustID;
	}

	/**
	 * @param custID the custID to set
	 */
	public void setCustID(int custID) {
		CustID = custID;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return FirstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return EmailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return Age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		Age = age;
	}
	
	public static void main(String[] args) {
		Customer harry = new Customer("Harry", "bob", "10", "f@f", "12345", 12);
		harry.getFromDB(0);
	}
	
}
