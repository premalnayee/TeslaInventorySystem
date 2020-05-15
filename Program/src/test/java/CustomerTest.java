package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.objects.Customer;

class CustomerTest {
	
	Customer harry = new Customer("Harry", "bob", "10", "f@f", "12345", 12);

	@Test
	void testGetFromDB() throws SQLException  {
		assertEquals("John Gerry", harry.getFromDB(1));
//		assertEquals("Harry bob", harry.getFromDB(2));
	}

	@Test
	void testAddToDb() throws SQLException  {
		harry.addToDb();
		assertEquals("Harry bob", harry.getFromDB(2));
	}

	/*
	 * @Test void testCreateAddQuery() {
	 * assertEquals("INSERT INTO Customers (FirstName, LastName, Address, EmailAddress, PhoneNumber, Age) VALUES (Harry, bob, 10, f@f, 12345, 12)"
	 * , harry.createAddQuery()); }
	 */

}
