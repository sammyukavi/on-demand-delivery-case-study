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
public class LocationTest {
	
	public LocationTest() {
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
	 * Test of getLatitude method, of class Location.
	 */
	@Test
	public void testGetLatitude() {
		System.out.println("getLatitude");
		Location instance = new Location();
		double expResult = 0.0;
		double result = instance.getLatitude();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setLatitude method, of class Location.
	 */
	@Test
	public void testSetLatitude() {
		System.out.println("setLatitude");
		double latitude = 0.0;
		Location instance = new Location();
		instance.setLatitude(latitude);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getLongitude method, of class Location.
	 */
	@Test
	public void testGetLongitude() {
		System.out.println("getLongitude");
		Location instance = new Location();
		double expResult = 0.0;
		double result = instance.getLongitude();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setLongitude method, of class Location.
	 */
	@Test
	public void testSetLongitude() {
		System.out.println("setLongitude");
		double longitude = 0.0;
		Location instance = new Location();
		instance.setLongitude(longitude);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
