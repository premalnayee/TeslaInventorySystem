package com.objects;

import java.util.HashMap;

public class Customer {

	private HashMap<String, String> customerParameters = new HashMap<>();


	public Customer() {
		customerParameters.put("FirstName / VARCHAR(100)", null);
		customerParameters.put("LastName / VARCHAR(100)", null);
		customerParameters.put("Address / VARCHAR(256)", null);
		customerParameters.put("EmailAddress / VARCHAR(100)", null);
		customerParameters.put("PhoneNumber / VARCHAR(20)", null);
		customerParameters.put("Age / TINYINT", null);
	}


	/**
	 * @return the customerParameters
	 */
	public HashMap<String, String> getCustomerParameters() {
		return customerParameters;
	}


	/**
	 * @param customerParameters the customerParameters to set
	 */
	public void setCustomerParameters(HashMap<String, String> customerParameters) {
		this.customerParameters = customerParameters;
	}
	
	
}
