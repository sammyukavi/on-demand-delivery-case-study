package ke.co.sendy.casestudy.util;

import org.junit.*;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test the helpers class
 * @author sukavi
 */
public class HelpersTest {
	
	public HelpersTest() {
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
	 * Test of sortByValue method, of class Helpers.
	 */
	@Test
	public void testSortByValue() {
		System.out.println("sortByValue");
		Map expResult = null;
		Map result = Helpers.sortByValue(null);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
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
		double latitude1 = 0.0;
		double longitude1 = 0.0;
		double latitude2 = 0.0;
		double longitude2 = 0.0;
		double expResult = 0.0;
		double result = Helpers.calculateDistance(latitude1, longitude1, latitude2, longitude2);
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
