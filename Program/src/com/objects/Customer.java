package com.objects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DBlink.DB;

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
	
	private int CustID = 1;
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
	
	
	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * 
	 */
	
	public Customer(int custID) {
		super();
		try {
			getFromDB(custID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL exception");
			System.out.println("Error with finding record with that custID: " + custID);
			//e.printStackTrace();
		} catch (NullPointerException a) {
			// TODO: handle exception
			System.out.println("Nullpointer exception");
			System.out.println("Error with finding record with that custID: " + custID);
			//e.printStackTrace();
		}
	}
	
	public Customer(String FName, String LName) {
		super();
		int CustID_found = findCustID(FName, LName);
		
		try {
			getFromDB(CustID_found);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL exception in constructor");
			//e.printStackTrace();
		} catch (NullPointerException a) {
			// TODO: handle exception
			System.out.println("Nullpointer exceptio in constructor");
			//e.printStackTrace();
		}
	}

	public String getFromDB(int custID) throws SQLException  {
		ResultSet rs;

		try {
			rs = DB.exQuery("SELECT * FROM customers WHERE CustID=" + custID );

			while (rs.next()) {
				//System.out.println(rs.getInt("CustID") + rs.getString("FirstName"));
				this.CustID    = rs.getInt("CustID");
				this.FirstName = rs.getString("FirstName");
				this.LastName  = rs.getString("LastName");
				this.Address   = rs.getString("Address");
				this.EmailAddress = rs.getString("EmailAddress");
				this.PhoneNumber = rs.getString("PhoneNumber");
				this.Age		= rs.getInt("Age");
			}
			String name = FirstName + " " + LastName;
			//System.out.println(name);
			return name;

		} catch (SQLException e) { // TODO Auto-generated catch block
			System.out.println("SQL exception");
			System.out.println("Error with finding record with that custID: " + custID);
			e.printStackTrace(); 
		} catch (NullPointerException a) { // TODO: handle
			//exception System.out.println("Nullpointer exception");
			System.out.println("Error with finding record with that custID: " + custID);
			//e.printStackTrace(); 
			}
			return null;

	}
	
	public int addToDb() throws SQLException{
		/*
		 * String Query =
		 * "INSERT INTO Customers (FirstName, LastName, Address, EmailAddress, PhoneNumber, Age) "
		 * ; Query += "VALUES (" + FirstName + ", " + LastName + ", " + Address + ", " +
		 * EmailAddress + ", "+ PhoneNumber + ", "+ Age + ")"; int changedKey =
		 * DB.exUpdate(Query); return changedKey;
		 */
		
		int changedKey = 0;
		try {
			PreparedStatement preparedStatement = DB.getConn().prepareStatement("INSERT INTO Customers (FirstName, LastName, Address, EmailAddress, PhoneNumber, Age) "
					+ "VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, this.FirstName);
			preparedStatement.setString(2, this.LastName);
			preparedStatement.setString(3, this.Address);
			preparedStatement.setString(4, this.EmailAddress);
			preparedStatement.setString(5, this.PhoneNumber);
			preparedStatement.setInt(6, this.Age);
			changedKey = preparedStatement.executeUpdate();
			return changedKey;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(toString());
			System.out.println("SQL Error in customer class addtodb method"); 
		} catch	(NullPointerException a){ 
				System.out.println("Nullpoint error in addToDb method \nShowing all variables" + toString()); 
		}
			 
		return changedKey;
	}
	
	public int findCustID(String FName, String LName) {
		ResultSet rs;
		
		try {
			int CustID_found=0;
			
			PreparedStatement preparedStatement = DB.getConn().prepareStatement("SELECT * FROM customers WHERE FirstName = ? AND LastName = ?");
			preparedStatement.setString(1, FName);
			preparedStatement.setString(2, LName);
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				//System.out.println(rs.getInt("CustID") + rs.getString("FirstName"));
				CustID_found  = rs.getInt("CustID");
			}
			
			return CustID_found;
		} catch (SQLException e) {
			System.out.println("SQL Error in customer class findcust method"); 
			e.printStackTrace();
		} catch	(NullPointerException a){ 
				System.out.println("Nullpoint error in addToDb method \nShowing all variables" + toString()); 
		}
		return 0;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (CustID == 0) {
			return null;
		} else {
			String stringy =  "\nFirstName, LastName, Address, EmailAddress, PhoneNumber, Age \n";
			stringy += CustID + ", " + FirstName + ", " + LastName + ", " + Address + ", " + EmailAddress + ", "+ PhoneNumber + ", " + Age;
		return stringy;
		}
	}



	/**
	 * @return the custID
	 */
	public int getCustID() {
		return this.CustID;
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
	
}
