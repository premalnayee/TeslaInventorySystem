package test.com.objects;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.DBlink.DB;
import com.objects.Customer;

class CustomerTest {
	
	Customer harry = new Customer("Harry", "bob", "Beijing China", "harry@aol.com", "12345", 12);
	Customer findHarry = new Customer();
	Customer james = new Customer("James", "Gerry", "3500 Deer Creek Road. Palo Alto, CA 94304", "hello@john.com", "+1334324253543",12);
	Customer findJames = new Customer();
	Customer richard = new Customer("Richard", "Seinfeld", "10 downing street", "richard@gmail.com","+44842965896",53);
	Customer findRichard = new Customer();
	
	Customer custNull = new Customer(0);
	Customer john = new Customer("John", "Gerry", "10 fdsfds", "fdsfsd@gfadsf.com", "+1334324253543",12);
	Customer findJohn = new Customer();
	

	@BeforeAll
	static void init() {
		DB.connect();
		System.out.println("connecting");
	}
	
	@AfterAll
	static void ending() {
		DB.exUpdate("DELETE FROM customers WHERE FirstName = \"Harry\";");
		DB.exUpdate("DELETE FROM customers WHERE FirstName = \"James\";");
		DB.exUpdate("DELETE FROM customers WHERE FirstName = \"Richard\";");
		DB.close();
	}
	
	@Test
	public void testGetFromDB() throws SQLException  {
		assertEquals("John Gerry", findJohn.getFromDB(1));
	}

	@Test
	public void testAddToDb() throws SQLException  {
		harry.addToDb();
		int cust = findHarry.findCustID(harry.getFirstName(), harry.getLastName());
		assertEquals("Harry bob", findHarry.getFromDB(cust));
		
		james.addToDb();
		int cust1 = findJames.findCustID("James", "Gerry");
		assertEquals("James Gerry", findJames.getFromDB(cust1));
		
		richard.addToDb();
		int cust2 = findRichard.findCustID(richard.getFirstName(), richard.getLastName());
		assertEquals("Richard Seinfeld", findRichard.getFromDB(cust2));
	}
	
	@Test
	public void testtoString() {
		harry.setCustID(1);
		assertEquals("\nFirstName, LastName, Address, EmailAddress, PhoneNumber, Age \n1, Harry, bob, Beijing China, harry@aol.com, 12345, 12", harry.toString());
		
		john.setCustID(2);
		assertEquals("\nFirstName, LastName, Address, EmailAddress, PhoneNumber, Age \n2, John, Gerry, 10 fdsfds, fdsfsd@gfadsf.com, +1334324253543, 12", john.toString());
		
		james.setCustID(3);
		assertEquals("\nFirstName, LastName, Address, EmailAddress, PhoneNumber, Age \n3, James, Gerry, 3500 Deer Creek Road. Palo Alto, CA 94304, hello@john.com, +1334324253543, 12", james.toString());
		
		richard.setCustID(4);
		assertEquals("\nFirstName, LastName, Address, EmailAddress, PhoneNumber, Age \n4, Richard, Seinfeld, 10 downing street, richard@gmail.com, +44842965896, 53", richard.toString());
		
		custNull.setCustID(0);
		assertEquals(null, custNull.toString());
	}
	
	@AfterAll
	public static void endit() {
		
	}
	
	/*
	 * @Test void testCreateAddQuery() {
	 * assertEquals("INSERT INTO Customers (FirstName, LastName, Address, EmailAddress, PhoneNumber, Age) VALUES (Harry, bob, 10, f@f, 12345, 12)"
	 * , harry.createAddQuery()); }
	 */

}
