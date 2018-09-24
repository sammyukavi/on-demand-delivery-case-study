/**
 * Mock the location class
 */
package ke.co.sendy.casestudy.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author sukavi
 */
public class LocationTest {
	
	Location instance;
	
	@Before
	public void setUp() {
		instance = new Location();
	}
	
	
	/**
	 * Test of getLatitude method, of class Location.
	 */
	@Test
	public void testGetLatitude() {
		System.out.println("getLatitude");
		double expResult = 0.0;
		double result = instance.getLatitude();
		assertEquals(expResult, result, 0.0);
	}
	
	/**
	 * Test of setLatitude method, of class Location.
	 */
	@Test
	public void testSetLatitude() {
		System.out.println("setLatitude");
		double latitude = 0.0;
		instance.setLatitude(latitude);
	}
	
	/**
	 * Test of getLongitude method, of class Location.
	 */
	@Test
	public void testGetLongitude() {
		System.out.println("getLongitude");
		double expResult = 0.0;
		double result = instance.getLongitude();
		assertEquals(expResult, result, 0.0);
	}
	
	/**
	 * Test of setLongitude method, of class Location.
	 */
	@Test
	public void testSetLongitude() {
		System.out.println("setLongitude");
		double longitude = 0.0;
		instance.setLongitude(longitude);
	}
	
	/**
	 * Test of setName method, of class Location.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "";
		instance.setName(name);
	}
	
	/**
	 * Test of getName method, of class Location.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		String expResult = "Mock Location";
		String result = instance.getName();
		assertEquals(expResult, result);
	}
	
}
