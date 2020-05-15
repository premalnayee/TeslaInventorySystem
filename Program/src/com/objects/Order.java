package com.objects;

//import java.util.HashMap;

public class Order {
	
	/*
	 * // private HashMap<String, String> orderParameters = new HashMap<>(); // //
	 * public Order(HashMap<String, String> orderParameters) { //
	 * orderParameters.put("CustID / INT", null); //
	 * orderParameters.put("Warranty / BOOLEAN", null); //
	 * orderParameters.put("PaymentMethod / VARCHAR(32)", null); // } // // public
	 * HashMap<String, String> getOrderParameters() { // return orderParameters; //
	 * } // // public void setOrderParameters(HashMap<String, String>
	 * orderParameters) { // this.orderParameters = orderParameters; // }
	 */
	private int CustID;
	private String Warranty;
	private String PaymentMethod;
	/**
	 * @param custID
	 * @param warranty
	 * @param paymentMethod
	 */
	public Order(int custID, String warranty, String paymentMethod) {
		super();
		CustID = custID;
		Warranty = warranty;
		PaymentMethod = paymentMethod;
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
	 * @return the warranty
	 */
	public String getWarranty() {
		return Warranty;
	}
	/**
	 * @param warranty the warranty to set
	 */
	public void setWarranty(String warranty) {
		Warranty = warranty;
	}
	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return PaymentMethod;
	}
	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}
	
}
