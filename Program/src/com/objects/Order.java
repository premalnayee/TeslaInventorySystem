package com.objects;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.DBlink.DB;
import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;

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
	private int OrderID;
	private int CustID;
	private boolean Warranty;
	private String PaymentMethod;
	/**
	 * @param custID
	 * @param warranty
	 * @param paymentMethod
	 */
	public Order(int custID, boolean warranty, String paymentMethod) {
		super();
		CustID = custID;
		Warranty = warranty;
		PaymentMethod = paymentMethod;
	}
	
	public String getFromDB(int orderID) throws SQLException  {
			ResultSet rs = DB.exQuery("SELECT * FROM orders WHERE OrderID=" + orderID );
			
			while (rs.next()) {
				this.OrderID = rs.getInt("OrderID");
				this.CustID    = rs.getInt("CustID");
				this.Warranty = rs.getBoolean("Warranty");
				this.PaymentMethod  = rs.getString("PaymentMethod");
			}
			String orderdesc = OrderID + " " + Warranty;
			//System.out.println(orderdesc);
		return orderdesc;
	}
	
	public int addToDb(){
			String Query = "INSERT INTO orders (CustID, Warranty, PaymentMethod) ";
			Query += "VALUES (\" " + CustID + "\", \"" + Boolean.compare(Warranty, false)+ "\", \"" + PaymentMethod + "\")";
			int changedKey = DB.exUpdate(Query);
		return changedKey;
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
	public boolean getWarranty() {
		return Warranty;
	}
	/**
	 * @param warranty the warranty to set
	 */
	public void setWarranty(boolean warranty) {
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
