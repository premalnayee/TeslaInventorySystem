package com.objects;

import java.sql.Date;
//import java.util.HashMap;

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

	private String ProdName;
	private String Colour;
	private String BatterySize;
	private Boolean Autopilot;
	private Boolean DualMotor;
	private Date ReleaseDate;
	private String ProductDelays;
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
			Date releaseDate, String productDelays) {
		super();
		ProdName = prodName;
		Colour = colour;
		BatterySize = batterySize;
		Autopilot = autopilot;
		DualMotor = dualMotor;
		ReleaseDate = releaseDate;
		ProductDelays = productDelays;
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
	
	
}