package com.objects;

import java.sql.Date;
import java.sql.PreparedStatement;
//import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DBlink.DB;

public class Product {

//	private HashMap<String,String> productParameters = new HashMap<>();
//	
//	public Product() {
//		productParameters.put("ProdName / VARCHAR(128)", null);
//		productParameters.put("Colour / VARCHAR(32)", null);
//		productParameters.put("BatterySize / VARCHAR(16)", null);
//		productParameters.put("Autopilot / BOOLEAN", null);
//		productParameters.put("DualMotor / BOOLEAN", null);
//		productParameters.put("ReleaseDate / DATE", null);
//		productParameters.put("ProductDelays / VARCHAR(32)", null);
//	}
//
//	/**
//	 * @return the productParameters
//	 */
//	public HashMap<String, String> getProductParameters() {
//		return productParameters;
//	}
//
//	/**
//	 * @param productParameters the productParameters to set
//	 */
//	public void setProductParameters(HashMap<String, String> productParameters) {
//		this.productParameters = productParameters;
//	}

	private int ProdID;
	private String ProdName;
	private String Colour;
	private String BatterySize;
	private Boolean Autopilot;
	private Boolean DualMotor;
	private Date ReleaseDate;
	private String ProductDelays;
	private int Price;
	/**
	 * @param prodName
	 * @param colour
	 * @param batterySize
	 * @param autopilot
	 * @param dualMotor
	 * @param releaseDate
	 * @param productDelays
	 */
	
	
	
	public Product(String prodName, String colour, String batterySize, Boolean autopilot, Boolean dualMotor,
			String releaseDate, String productDelays, int price) {
		super();
		ProdName = prodName;
		Colour = colour;
		BatterySize = batterySize;
		Autopilot = autopilot;
		DualMotor = dualMotor;
		ReleaseDate = Date.valueOf(releaseDate);
		ProductDelays = productDelays;
		Price = price;
	}
	
	/**
	 * @param prodID
	 */
	public Product(int prodID) {
		super();
		try {
			getFromDB(prodID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	/**
	 * 
	 */
	public Product() {
		super();
	}

	public String getFromDB(int prodID) throws SQLException  {
			ResultSet rs = DB.exQuery("SELECT * FROM products WHERE ProdID=" + prodID );
			
			while (rs.next()) {
				this.ProdID = rs.getInt("ProdID");
				this.ProdName    = rs.getString("ProdName");
				this.Colour = rs.getString("Colour");
				this.BatterySize  = rs.getString("BatterySize");
				this.Autopilot = rs.getBoolean("Autopilot");
				this.DualMotor = rs.getBoolean("DualMotor");
				this.ReleaseDate = rs.getDate("ReleaseDate");
				this.ProductDelays = rs.getString("ProductDelays");
				this.Price = rs.getInt("Price");
			}
			String ProdDesc = ProdName + " " + ReleaseDate.toString();
		return ProdDesc;
	}
	
	public int addToDb(){
		int changedKey = 0;
		try {
			PreparedStatement preparedStatement = DB.getConn().prepareStatement("INSERT INTO products (ProdName, Colour, BatterySize, Autopilot, DualMotor, ReleaseDate, ProductDelays, Price)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, ProdName);
			preparedStatement.setString(2, Colour);
			preparedStatement.setString(3, BatterySize);
			preparedStatement.setBoolean(4, Autopilot);
			preparedStatement.setBoolean(5, DualMotor);
			preparedStatement.setDate(6, ReleaseDate);
			preparedStatement.setString(7, ProductDelays);
			preparedStatement.setInt(8, Price);
			changedKey = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL Error in products class addtodb method");
		}
		return changedKey;
	}
	
	public int findProdID(String name) {
		ResultSet rs;
		
		try {
			int ProdID_found=0;
			
			PreparedStatement preparedStatement = DB.getConn().prepareStatement("SELECT * FROM products WHERE ProdName = ?");
			preparedStatement.setString(1, name);
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				//System.out.println(rs.getInt("CustID") + rs.getString("FirstName"));
				ProdID_found  = rs.getInt("ProdID");
			}
			
			return ProdID_found;
		} catch (SQLException e) {
			System.out.println("SQL Error in customer class findcust method"); 
			e.printStackTrace();
		} catch	(NullPointerException a){ 
				System.out.println("Nullpoint error in addToDb method \nShowing all variables" + toString()); 
		}
		return 0;
	}
	
	public void printAllProd() {
		try {
			ResultSet rs = DB.exQuery("SELECT * FROM products");

			while (rs.next()) {
				//System.out.println(rs.getInt("CustID") + rs.getString("FirstName"));
				int ProdID    = rs.getInt("ProdID");
				String ProdName = rs.getString("ProdName");
				String Price  = rs.getString("Price");
				System.out.println(ProdID + " " + ProdName + " " + Price);
			}

		} catch (SQLException e) { // TODO Auto-generated catch block
			System.out.println("SQL exception");
			System.out.println("Error with finding record with that ");
			e.printStackTrace(); 
		} catch (NullPointerException a) { // TODO: handle
			//exception System.out.println("Nullpointer exception");
			System.out.println("Error with finding record with that ");
			//e.printStackTrace(); 
			}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String stringy = "ProdName, Colour, BatterSize, Autopilot, Dualmotor, Product delays, Price\n";
		stringy += ProdName + ", " + Colour + ", " + BatterySize + ", " + Autopilot + ", " + DualMotor + ", " + ReleaseDate + ", " + ProductDelays + ", " + Price;
		return stringy;
	}
	
	public String toStringShort() {
		// TODO Auto-generated method stub
		String stringy = ProdName + " " + BatterySize + " " + Price; 
		return stringy;
	}

	/**
	 * @return the prodName
	 */
	public String getProdName() {
		return ProdName;
	}
	/**
	 * @param prodName the prodName to set
	 */
	public void setProdName(String prodName) {
		ProdName = prodName;
	}
	/**
	 * @return the colour
	 */
	public String getColour() {
		return Colour;
	}
	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		Colour = colour;
	}
	/**
	 * @return the batterySize
	 */
	public String getBatterySize() {
		return BatterySize;
	}
	/**
	 * @param batterySize the batterySize to set
	 */
	public void setBatterySize(String batterySize) {
		BatterySize = batterySize;
	}
	/**
	 * @return the autopilot
	 */
	public Boolean getAutopilot() {
		return Autopilot;
	}
	/**
	 * @param autopilot the autopilot to set
	 */
	public void setAutopilot(Boolean autopilot) {
		Autopilot = autopilot;
	}
	/**
	 * @return the dualMotor
	 */
	public Boolean getDualMotor() {
		return DualMotor;
	}
	/**
	 * @param dualMotor the dualMotor to set
	 */
	public void setDualMotor(Boolean dualMotor) {
		DualMotor = dualMotor;
	}
	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return ReleaseDate;
	}
	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}
	/**
	 * @return the productDelays
	 */
	public String getProductDelays() {
		return ProductDelays;
	}
	/**
	 * @param productDelays the productDelays to set
	 */
	public void setProductDelays(String productDelays) {
		ProductDelays = productDelays;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return Price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		Price = price;
	}
	
	
}