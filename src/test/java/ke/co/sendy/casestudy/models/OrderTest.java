package ke.co.sendy.casestudy.models;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is a test class for testing the Order class and methods
 */
public class OrderTest {
	
	@Test
	public void testOrdersObject() {
		
		Location pickUpLocation = new Location(-1.300176, 36.776714);
		Location dropOffLocation = new Location(-1.300176, 36.776714);
		Location dropOffLocation2 = new Location(-1.256631, 36.852722);
		
		/*
		  Test an order that does not change location
		 */
		
		Order order = new Order("Test Order 1", pickUpLocation, dropOffLocation);
		
		Assert.assertEquals("Test Order 1", order.getName());
		Assert.assertEquals(0, order.getExpectedTravelDistanceKiloMetres(), 0);
		Assert.assertEquals(0, order.getOrderCost(), 0);
		
		
		/*
		  Test an order being dropped almost 10 Kilometres away
		 */
		Order order2 = new Order("Test Order 2", pickUpLocation, dropOffLocation2);
		
		Assert.assertEquals("Test Order 2", order2.getName());
		Assert.assertEquals(10, Math.ceil(order2.getExpectedTravelDistanceKiloMetres()), 0);
		Assert.assertEquals(293, Math.ceil(order2.getOrderCost()), 0);
		
	}
	
}