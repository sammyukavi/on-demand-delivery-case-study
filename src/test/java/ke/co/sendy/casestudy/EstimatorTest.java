/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.sendy.casestudy;

import ke.co.sendy.casestudy.models.Location;
import ke.co.sendy.casestudy.models.Order;
import ke.co.sendy.casestudy.models.Route;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author sukavi
 */
public class EstimatorTest {
	
	public EstimatorTest() {
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
	 * Test of getRouteStartLocation method, of class Estimator.
	 */
	@Test
	public void testGetRouteStartLocation() {
		System.out.println("getRouteStartLocation");
		Estimator instance = new Estimator();
		Location expResult = null;
		Location result = instance.getRouteStartLocation();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setRouteStartLocation method, of class Estimator.
	 */
	@Test
	public void testSetRouteStartLocation() {
		System.out.println("setRouteStartLocation");
		Location routeStartLocation = null;
		Estimator instance = new Estimator();
		instance.setRouteStartLocation(routeStartLocation);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of selectBestRoute method, of class Estimator.
	 */
	@Test
	public void testSelectBestRoute_Location_ArrayList() throws Exception {
		System.out.println("selectBestRoute");
		Location routeStartLocation = null;
		ArrayList<Order> orders = null;
		Estimator instance = new Estimator();
		ArrayList<Route> expResult = null;
		ArrayList<Route> result = instance.selectBestRoute(routeStartLocation, orders);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of selectBestRoute method, of class Estimator.
	 */
	@Test
	public void testSelectBestRoute_ArrayList() throws Exception {
		System.out.println("selectBestRoute");
		ArrayList<Order> orders = null;
		Estimator instance = new Estimator();
		ArrayList<Route> expResult = null;
		ArrayList<Route> result = instance.selectBestRoute(orders);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
