package test.com.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.DBlink.DB;
import com.objects.Customer;

class CustomerTest {
	
	Customer harry = new Customer("Harry", "bob", "10", "f@f", "12345", 12);

	@BeforeEach
	void init() {
		DB.connect();
	}
	
	@Test
	void testGetFromDB() throws SQLException  {
		DB.connect();
		assertEquals("John Gerry", harry.getFromDB(1));
//		assertEquals("Harry bob", harry.getFromDB(2));
		DB.close();
	}

	@Test
	void testAddToDb() throws SQLException  {
		harry.addToDb();
		assertEquals("Harry bob", harry.getFromDB(2));
	}
	
	@AfterEach
	void ending() {
		DB.close();
	}

	/*
	 * @Test void testCreateAddQuery() {
	 * assertEquals("INSERT INTO Customers (FirstName, LastName, Address, EmailAddress, PhoneNumber, Age) VALUES (Harry, bob, 10, f@f, 12345, 12)"
	 * , harry.createAddQuery()); }
	 */

}
