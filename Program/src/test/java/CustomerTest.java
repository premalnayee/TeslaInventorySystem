package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.objects.Customer;

class CustomerTest {
	
	Customer harry = new Customer("Harry", "bob", "10", "f@f", "12345", 12);

	@Test
	void testGetFromDB() {
		assertEquals(" ", harry.getFromDB(0));
	}

	@Test
	void testAddToDb() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateAddQuery() {
		assertEquals("INSERT INTO Customers (FirstName, LastName, Address, EmailAddress, PhoneNumber, Age) VALUES (Harry, bob, 10, f@f, 12345, 12)", harry.createAddQuery());
	}

}
