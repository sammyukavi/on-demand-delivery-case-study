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
public class RouteTest {
	
	public RouteTest() {
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
	 * Test of getStartPoint method, of class Route.
	 */
	@Test
	public void testGetStartPoint() {
		System.out.println("getStartPoint");
		Route instance = new Route();
		Location expResult = null;
		Location result = instance.getStartPoint();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setStartPoint method, of class Route.
	 */
	@Test
	public void testSetStartPoint() {
		System.out.println("setStartPoint");
		Location startPoint = null;
		Route instance = new Route();
		instance.setStartPoint(startPoint);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getEndPoint method, of class Route.
	 */
	@Test
	public void testGetEndPoint() {
		System.out.println("getEndPoint");
		Route instance = new Route();
		Location expResult = null;
		Location result = instance.getEndPoint();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setEndPoint method, of class Route.
	 */
	@Test
	public void testSetEndPoint() {
		System.out.println("setEndPoint");
		Location location = null;
		Route instance = new Route();
		instance.setEndPoint(location);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of addPickUpOrder method, of class Route.
	 */
	@Test
	public void testAddPickUpOrder() {
		System.out.println("addPickUpOrder");
		Order order = null;
		Route instance = new Route();
		instance.addPickUpOrder(order);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getPickUpOrders method, of class Route.
	 */
	@Test
	public void testGetPickUpOrders() {
		System.out.println("getPickUpOrders");
		Route instance = new Route();
		ArrayList<Order> expResult = null;
		ArrayList<Order> result = instance.getPickUpOrders();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setPickUpOrders method, of class Route.
	 */
	@Test
	public void testSetPickUpOrders() {
		System.out.println("setPickUpOrders");
		ArrayList<Order> pickUpOrders = null;
		Route instance = new Route();
		instance.setPickUpOrders(pickUpOrders);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getName method, of class Route.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Route instance = new Route();
		String expResult = "";
		String result = instance.getName();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setName method, of class Route.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "";
		Route instance = new Route();
		instance.setName(name);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getDistance method, of class Route.
	 */
	@Test
	public void testGetDistance() {
		System.out.println("getDistance");
		Route instance = new Route();
		double expResult = 0.0;
		double result = instance.getDistance();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of addDropOffOrder method, of class Route.
	 */
	@Test
	public void testAddDropOffOrder() {
		System.out.println("addDropOffOrder");
		Order order = null;
		Route instance = new Route();
		instance.addDropOffOrder(order);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getDropOffOrders method, of class Route.
	 */
	@Test
	public void testGetDropOffOrders() {
		System.out.println("getDropOffOrders");
		Route instance = new Route();
		ArrayList<Order> expResult = null;
		ArrayList<Order> result = instance.getDropOffOrders();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
