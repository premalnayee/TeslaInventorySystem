package com.objects;

import java.util.HashMap;

public class Product {

	private HashMap<String,String> productParameters = new HashMap<>();
	
	public Product() {
		productParameters.put("ProdName / VARCHAR(128)", null);
		productParameters.put("Colour / VARCHAR(32)", null);
		productParameters.put("BatterySize / VARCHAR(16)", null);
		productParameters.put("Autopilot / BOOLEAN", null);
		productParameters.put("DualMotor / BOOLEAN", null);
		productParameters.put("ReleaseDate / DATE", null);
		productParameters.put("ProductDelays / VARCHAR(32)", null);
	}

	/**
	 * @return the productParameters
	 */
	public HashMap<String, String> getProductParameters() {
		return productParameters;
	}

	/**
	 * @param productParameters the productParameters to set
	 */
	public void setProductParameters(HashMap<String, String> productParameters) {
		this.productParameters = productParameters;
	}
	
}