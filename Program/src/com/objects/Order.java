package com.objects;

import java.util.HashMap;

public class Order {
	
	private HashMap<String, String> orderParameters = new HashMap<>();

	public Order(HashMap<String, String> orderParameters) {
		orderParameters.put("CustID / INT", null);
		orderParameters.put("Warranty / BOOLEAN", null);
		orderParameters.put("PaymentMethod / VARCHAR(32)", null);
	}

	public HashMap<String, String> getOrderParameters() {
		return orderParameters;
	}

	public void setOrderParameters(HashMap<String, String> orderParameters) {
		this.orderParameters = orderParameters;
	}	

}
