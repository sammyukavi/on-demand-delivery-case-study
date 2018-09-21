package ke.co.sendy.casestudy.models;

import org.junit.*;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This is a test class for testing the Order class and methods
 */
public class OrderTest {
	
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
	
	@Test
	public void testOrdersObject() {
		
		Location pickUpLocation = new Location(-1.300176, 36.776714);
		Location dropOffLocation = new Location(-1.300176, 36.776714);
		Location dropOffLocation2 = new Location(-1.256631, 36.852722);

        /*
		  Test an order that does not change location
         */
		Order order = new Order("Test Order 1", pickUpLocation, dropOffLocation);
		
		assertEquals("Test Order 1", order.getName());
		assertEquals(0, order.getExpectedTravelDistanceKiloMetres(), 0);
		assertEquals(0, order.getOrderCost(), 0);

        /*
		  Test an order being dropped almost 10 Kilometres away
         */
		Order order2 = new Order("Test Order 2", pickUpLocation, dropOffLocation2);
		
		assertEquals("Test Order 2", order2.getName());
		assertEquals(10, Math.ceil(order2.getExpectedTravelDistanceKiloMetres()), 0);
		assertEquals(293, Math.ceil(order2.getOrderCost()), 0);
		
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
	 * Test of getExpectedTravelDistanceKiloMetres method, of class Order.
	 */
	@Test
	public void testGetExpectedTravelDistanceKiloMetres() {
		System.out.println("getExpectedTravelDistanceKiloMetres");
		Order instance = new Order();
		double expResult = 0.0;
		double result = instance.getExpectedTravelDistanceKiloMetres();
		assertEquals(expResult, result, 0.0);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of getDropOffTime method, of class Order.
	 */
	@Test
	public void testGetDropOffTime() {
		System.out.println("getDropOffTime");
		Order instance = new Order();
		Date expResult = null;
		Date result = instance.getDropOffTime();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
	/**
	 * Test of setDropOffTime method, of class Order.
	 */
	@Test
	public void testSetDropOffTime() {
		System.out.println("setDropOffTime");
		Date dropOffTime = null;
		Order instance = new Order();
		instance.setDropOffTime(dropOffTime);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
