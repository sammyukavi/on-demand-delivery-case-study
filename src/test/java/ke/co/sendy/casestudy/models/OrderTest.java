/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.sendy.casestudy.models;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author sukavi
 */
public class OrderTest {
	
	public OrderTest() {
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
	 * Test of getName method, of class Order.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Order instance = new Order();
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setName method, of class Order.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "";
		Order instance = new Order();
		instance.setName(name);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getDropOffLocation method, of class Order.
	 */
	@Test
	public void testGetDropOffLocation() {
		System.out.println("getDropOffLocation");
		Order instance = new Order();
		Location expResult = null;
		Location result = instance.getDropOffLocation();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setDropOffLocation method, of class Order.
	 */
	@Test
	public void testSetDropOffLocation() {
		System.out.println("setDropOffLocation");
		Location dropOffLocation = null;
		Order instance = new Order();
		instance.setDropOffLocation(dropOffLocation);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getPickUpLocation method, of class Order.
	 */
	@Test
	public void testGetPickUpLocation() {
		System.out.println("getPickUpLocation");
		Order instance = new Order();
		Location expResult = null;
		Location result = instance.getPickUpLocation();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setPickUpLocation method, of class Order.
	 */
	@Test
	public void testSetPickUpLocation() {
		System.out.println("setPickUpLocation");
		Location pickUpLocation = null;
		Order instance = new Order();
		instance.setPickUpLocation(pickUpLocation);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getOrderCost method, of class Order.
	 */
	@Test
	public void testGetOrderCost() {
		System.out.println("getOrderCost");
		Order instance = new Order();
		double expResult = 0.0;
		double result = instance.getOrderCost();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getExpectedTravelDistance method, of class Order.
	 */
	@Test
	public void testGetExpectedTravelDistance() {
		System.out.println("getExpectedTravelDistance");
		Order instance = new Order();
		double expResult = 0.0;
		double result = instance.getExpectedTravelDistance();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
