package test.com.objects;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.DBlink.DB;
import com.objects.Customer;

class CustomerTest {
	
	Customer harry = new Customer("Harry", "bob", "10", "f@f", "12345", 12);
	Customer findHarry = new Customer();
	Customer john = new Customer("John", "Gerry", "10 fdsfds", "fdsfsd@gfadsf.com", "+1334324253543",12);
	Customer findJohn = new Customer();
	Customer custNull = new Customer(0);

	@BeforeEach
	void init() {
		DB.connect();
	}
	
	@Test
	void testGetFromDB() throws SQLException  {
		assertEquals("John Gerry", findJohn.getFromDB(1));
	}

	@Test
	void testAddToDb() throws SQLException  {
		harry.addToDb();
		assertEquals("Harry bob", findHarry.getFromDB(2));
	}
	
	@Test
	void testtoString() {
		harry.setCustID(1);
		assertEquals("\nFirstName, LastName, Address, EmailAddress, PhoneNumber, Age \n1, Harry, bob, 10, f@f, 12345, 12", harry.toString());
		john.setCustID(2);
		assertEquals("\nFirstName, LastName, Address, EmailAddress, PhoneNumber, Age \n2, John, Gerry, 10 fdsfds, fdsfsd@gfadsf.com, +1334324253543, 12", john.toString());
		custNull.setCustID(0);
		assertEquals(null, custNull.toString());
	}
	
	@AfterEach
	void ending() {
		DB.close();
	}
	
	@AfterAll
	static void endit() {
		DB.connect();
		DB.exUpdate("DELETE FROM customers WHERE FirstName = \"Harry\";");
		DB.close();
	}

	/*
	 * @Test void testCreateAddQuery() {
	 * assertEquals("INSERT INTO Customers (FirstName, LastName, Address, EmailAddress, PhoneNumber, Age) VALUES (Harry, bob, 10, f@f, 12345, 12)"
	 * , harry.createAddQuery()); }
	 */

}
