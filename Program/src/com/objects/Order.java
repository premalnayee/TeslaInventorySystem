package com.objects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DBlink.DB;

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
	private ArrayList<Integer> ProductList;
	private int Total;
	/**
	 * @param custID
	 * @param warranty
	 * @param paymentMethod
	 */
	
	
	
	public Order(int custID, boolean warranty, String paymentMethod, int total) {
		super();
		CustID = custID;
		Warranty = warranty;
		PaymentMethod = paymentMethod;
		Total = total;
	}
	
	/**
	 * 
	 */
	public Order() {
		super();
	}

	// This constructor takes in the products as IDs and calculates the price of the item
	/**
	 * @param orderID
	 * @param custID
	 * @param warranty
	 * @param paymentMethod
	 * @param products
	 */
	public Order(int custID, boolean warranty, String paymentMethod, ArrayList<Integer> productList) {
		super();
		CustID = custID;
		Warranty = warranty;
		PaymentMethod = paymentMethod;
		ProductList = productList;
		Total = calculateTotal();
	}

	/**
	 * @param orderID
	 */
	public Order(int orderID) {
		super();
		try {
			getFromDB(orderID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public String getFromDB(int orderID) throws SQLException  {
		String orderdesc;
		ResultSet rs;
		ArrayList<Integer> ProductListNew = new ArrayList<Integer>();

		try {		
			rs = DB.exQuery("SELECT * FROM orders WHERE OrderID=" + orderID );

			while (rs.next()) {
				this.OrderID = rs.getInt("OrderID");
				this.CustID    = rs.getInt("CustID");
				this.Warranty = rs.getBoolean("Warranty");
				this.PaymentMethod  = rs.getString("PaymentMethod");
				this.Total = rs.getInt("Total");
			}
			System.out.println(toString());
			rs = DB.exQuery("SELECT * FROM ProductOrderLookup WHERE OrderID = " + orderID );

			while (rs.next()) {
				int ProdID_New = rs.getInt("ProdID");
				if (ProdID_New != 0) {
					ProductListNew.add(ProdID_New);
				}
			}
			System.out.println(ProductListNew.get(0).toString());
			this.ProductList = ProductListNew;
		} catch (SQLException s) {
			System.out.println("SQL exception issue in Order.getFromDB");
		} catch (NullPointerException n) {
			System.out.println("Null point exception issue in Order.getFromDB");
		}

		this.Total = calculateTotal();
		orderdesc = OrderID + " " + Warranty + " " + Total;
		return orderdesc;
	}
	
	public int addToDb(){
		/*
		 * String Query =
		 * "INSERT INTO orders (CustID, Warranty, PaymentMethod, Total) "; Query +=
		 * "VALUES (\" " + CustID + "\", \"" + Boolean.compare(Warranty, false)+
		 * "\", \"" + PaymentMethod + "\", " + Total + ")"; int changedKey =
		 * DB.exUpdate(Query); return changedKey;
		 */
		
		int changedKey = 0;
		try {
			PreparedStatement preparedStatement = DB.getConn().prepareStatement("INSERT INTO orders (CustID, Warranty, PaymentMethod, Total)"
					+ "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, CustID);
			preparedStatement.setBoolean(2, Warranty);
			preparedStatement.setString(3, PaymentMethod);
			preparedStatement.setInt(4, Total);
			changedKey = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL Error in products class addtodb method");
		}
		return changedKey;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String stringy = "\nOrderID, CustID, Warranty, Payment method, Total\n";
		stringy += OrderID + ", " + CustID + ", " + Warranty + ", " + PaymentMethod + ", " + Total; 
		return stringy;
	}

	// Uses productList to calculate the total of the order
	int calculateTotal() {
		int sum = 0;
		for (int prodID : this.ProductList) {
			Product prodObj = new Product(prodID);
			sum += prodObj.getPrice();
		}
		return sum;
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

	/**
	 * @return the total
	 */
	public int getTotal() {
		return Total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		Total = total;
	}

	/**
	 * @return the orderID
	 */
	public int getOrderID() {
		return OrderID;
	}

	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	/**
	 * @return the productList
	 */
	public ArrayList<Integer> getProductList() {
		return ProductList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(ArrayList<Integer> productList) {
		ProductList = productList;
	}
	
}
