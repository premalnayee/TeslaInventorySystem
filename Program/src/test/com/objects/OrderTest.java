package test.com.objects;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.DBlink.DB;
import com.objects.Order;

class OrderTest {
	
	Order ord = new Order();
	
	int generatedIndex;
	
	@BeforeAll
	static void init() {
		DB.connect();
		System.out.println("connecting");
	}
	
	@AfterAll
	static void ending() {
		DB.exUpdate("DELETE FROM orders WHERE OrderID >= 2");
		DB.close();
	}
	
	
	@Test
	void testGetFromDB() throws SQLException {
		assertEquals("1 true 40000", ord.getFromDB(1) );
		assertEquals(1, ord.getProductList().size());
	}
	
	@Test
	void testAddToDb() throws SQLException {
		
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(1);
		aList.add(1);
		Order ord = new Order(1, false, "Cash", aList);
		int generatedIndex = ord.addToDb();
		Order findOrder = new Order();
		assertEquals("1 true 40000", findOrder.getFromDB(2));
		
		System.out.println(generatedIndex);
		
		ArrayList<Integer> aList2 = new ArrayList<Integer>();
		aList2.add(1);
		aList2.add(1);
		aList2.add(1);
		Order ord2 = new Order(1, false, "Sheep", aList2);
		int generatedIndex2 = ord2.addToDb();
		Order findOrder2 = new Order();
		assertEquals("1 true 40000", findOrder2.getFromDB(3));
		
		System.out.println(generatedIndex2);
		}
	}
