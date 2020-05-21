package test.com.objects;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.DBlink.DB;
import com.objects.Order;

class OrderTest {
	
	Order ord = new Order(1, true, "credit card", 40000);
	int generatedIndex;
	
	@BeforeEach
	void init() {
		DB.connect();
	}
	
	@Test
	void testAddToDb() {
		generatedIndex = ord.addToDb();
		System.out.println(generatedIndex);
	}

	@Test
	void testGetFromDB() throws SQLException {
		assertEquals("0 true", ord.getFromDB(generatedIndex) );
	}

	@AfterEach
	void ending() {
		DB.close();
	}

}
