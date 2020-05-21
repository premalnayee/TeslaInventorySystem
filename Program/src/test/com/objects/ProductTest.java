package test.com.objects;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.DBlink.DB;
import com.objects.Product;

class ProductTest {
	
	Product prodModelX = new Product("Model X", "Space Grey", "75 KW", true, true, "2015-09-29", "6 months", 60000);
	Product prodModelY = new Product("Model Y", "Black", "75KW",true, true, "2020-03-13", "", 40000);
	Product prodModel3 = new Product("Model 3", "Black", "75KW", true, true, "2017-07-07", "", 30000);
	

	@BeforeAll
	static void init() {
		DB.connect();
		System.out.println("connecting");
	}
	
	@AfterAll
	static void ending() {
		DB.exUpdate("DELETE FROM Products WHERE ProdID >= 2");
		DB.close();
	}
	
	/*
	 * @Test void testGetFromDB() throws SQLException {
	 * assertEquals("Model Y 2020-03-13", prod.getFromDB(1) );
	 * assertEquals("Model X 2015-09-29", prod.getFromDB(2) );
	 * assertEquals("Model X 2015-09-29", prod.getFromDB(3) );
	 * assertEquals("Model X 2015-09-29", prod.getFromDB(4) );
	 * 
	 * }
	 */
	
	@Test
	void testAddToDb() throws SQLException {
		Product findProd = new Product();
		
		prodModelX.addToDb();
		int ProdIDAdded = findProd.findProdID( prodModelX.getProdName() );
		assertEquals("Model X 2015-09-29", findProd.getFromDB( ProdIDAdded ) );
		
		prodModelY.addToDb();
		ProdIDAdded = findProd.findProdID( prodModelY.getProdName() );
		assertEquals("Model Y 2020-03-13", findProd.getFromDB( ProdIDAdded ) );
		
		prodModel3.addToDb();
		ProdIDAdded = findProd.findProdID( prodModel3.getProdName() );
		assertEquals("Model 3 2017-07-07", findProd.getFromDB( ProdIDAdded ) );		
	}





}
