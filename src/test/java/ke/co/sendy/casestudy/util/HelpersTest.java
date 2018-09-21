package ke.co.sendy.casestudy.util;

import ke.co.sendy.casestudy.models.Order;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This is a test class for testing the Helper class and methods
 */
public class HelpersTest {
	
	private Map<Order, String> items = new HashMap<>();
	private Map<Order, String> expected = new HashMap<>();
	private double number = 1.0456;
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		items.put(new Order(), "E");
		items.put(new Order(), "D");
		items.put(new Order(), "C");
		items.put(new Order(), "B");
		items.put(new Order(), "A");
		
		expected.put(new Order(), "A");
		expected.put(new Order(), "B");
		expected.put(new Order(), "C");
		expected.put(new Order(), "D");
		expected.put(new Order(), "E");
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testRound() {
		double result = Helpers.round(number);
		assertEquals(1.05, result, 2);
	}
	
	@Test
	public void testRoundWithPlaces() {
		double result = Helpers.round(number, 1);
		assertEquals(1.0, result, 0);
	}
	
	@Test
	public void testCalculateDistance() {
		double result = Helpers.calculateDistance(-1.300176, 36.776714, -1.256631, 36.852722);
		assertEquals(10, Math.ceil(result), 0);
	}
	
	@Test
	public void testSortByValue() {
		Map<Order, String> sorted = Helpers.sortByValue(items);
		assertEquals(expected, sorted);
	}
	
	/**
	 * Test of round method, of class Helpers.
	 */
	@Test
	public void testRound_double_int() {
		System.out.println("round");
		double value = 0.0;
		int places = 0;
		double expResult = 0.0;
		double result = Helpers.round(value, places);
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of round method, of class Helpers.
	 */
	@Test
	public void testRound_double() {
		System.out.println("round");
		double value = 0.0;
		double expResult = 0.0;
		double result = Helpers.round(value);
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of calculateDistance method, of class Helpers.
	 */
	@Test
	public void testCalculateDistance_5args() {
		System.out.println("calculateDistance");
		double lat1 = 0.0;
		double lon1 = 0.0;
		double lat2 = 0.0;
		double lon2 = 0.0;
		String unit = "";
		double expResult = 0.0;
		double result = Helpers.calculateDistance(lat1, lon1, lat2, lon2, unit);
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of calculateDistance method, of class Helpers.
	 */
	@Test
	public void testCalculateDistance_4args() {
		System.out.println("calculateDistance");
		double lat1 = 0.0;
		double lon1 = 0.0;
		double lat2 = 0.0;
		double lon2 = 0.0;
		double expResult = 0.0;
		double result = Helpers.calculateDistance(lat1, lon1, lat2, lon2);
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
