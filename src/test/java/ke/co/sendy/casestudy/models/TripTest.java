/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.sendy.casestudy.models;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author sukavi
 */
public class TripTest {
	
	public TripTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	
	/**
	 * Test of getStartPoint method, of class Trip.
	 */
	@Test
	public void testGetStartPoint() {
		System.out.println("getStartPoint");
		Trip instance = new Trip();
		Location expResult = null;
		Location result = instance.getStartPoint();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setStartPoint method, of class Trip.
	 */
	@Test
	public void testSetStartPoint() {
		System.out.println("setStartPoint");
		Location startPoint = null;
		Trip instance = new Trip();
		instance.setStartPoint(startPoint);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getEndPoint method, of class Trip.
	 */
	@Test
	public void testGetEndPoint() {
		System.out.println("getEndPoint");
		Trip instance = new Trip();
		Location expResult = null;
		Location result = instance.getEndPoint();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setEndPoint method, of class Trip.
	 */
	@Test
	public void testSetEndPoint() {
		System.out.println("setEndPoint");
		Location location = null;
		Trip instance = new Trip();
		instance.setEndPoint(location);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of addOrder method, of class Trip.
	 */
	@Test
	public void testAddOrder() {
		System.out.println("addOrder");
		Order order = null;
		Trip instance = new Trip();
		instance.addOrder(order);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getOrders method, of class Trip.
	 */
	@Test
	public void testGetOrders() {
		System.out.println("getOrders");
		Trip instance = new Trip();
		ArrayList<Order> expResult = null;
		ArrayList<Order> result = instance.getOrders();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getFullDistance method, of class Trip.
	 */
	@Test
	public void testGetFullDistance() {
		System.out.println("getFullDistance");
		Trip instance = new Trip();
		double expResult = 0.0;
		double result = instance.getFullDistance();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setFullDistance method, of class Trip.
	 */
	@Test
	public void testSetFullDistance() {
		System.out.println("setFullDistance");
		double fullDistance = 0.0;
		Trip instance = new Trip();
		instance.setFullDistance(fullDistance);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
