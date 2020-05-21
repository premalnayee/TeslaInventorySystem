package test.com.objects;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.DBlink.DB;
import com.objects.Product;

class ProductTest {
	
	Product prod = new Product("Model X", "Space Grey", "75 KW", true, true, "2015-09-29", "6 months",60000);

	@BeforeEach
	void init() {
		DB.connect();
	}
	
	@Test
	void testAddToDb() {
		//int generatedIndex = prod.addToDb();
		//System.out.println(generatedIndex);
	}

	@Test
	void testGetFromDB() throws SQLException {
		assertEquals("Model Y 2020-03-13", prod.getFromDB(1) );
		assertEquals("Model X 2015-09-29", prod.getFromDB(2) );
		assertEquals("Model X 2015-09-29", prod.getFromDB(3) );
		assertEquals("Model X 2015-09-29", prod.getFromDB(4) );

	}

	@AfterEach
	void ending() {
		DB.close();
	}


}
