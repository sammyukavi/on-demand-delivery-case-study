package ke.co.sendy.casestudy.models;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the order class
 * @author sukavi
 */
public class OrderTest {
	
	@Test
	public void testOrdersObject() {
		
		String orderName = "Some Order";
		Location kiambu = new Location(-1.16667d, 36.83333d);
		Location machakos = new Location(-1.51667d, 37.26667d);
		Location kitui = new Location(-1.36696d, 38.01055d);
		
		Order orderObj = new Order();
		orderObj.setName(orderName);
		orderObj.setPickUpLocation(machakos);
		orderObj.setDropOffLocation(kitui);
		
		Assert.assertEquals(orderName, orderObj.getName());
		Assert.assertEquals(machakos, orderObj.getPickUpLocation());
		Assert.assertEquals(kitui, orderObj.getDropOffLocation());
		
		Order order = new Order("Test Order 1", kiambu, machakos);
		
		Assert.assertEquals("Test Order 1", order.getName());
		Assert.assertEquals(61.9257091142683, order.getExpectedTravelDistance(), 0);
		Assert.assertEquals(1857.77, order.getOrderCost(), 0);
		
		Order order2 = new Order("Test Order 2", kiambu, kitui);
		
		Assert.assertEquals("Test Order 2", order2.getName());
		Assert.assertEquals(132.7439737437885, order2.getExpectedTravelDistance(), 0);
		Assert.assertEquals(3982.32, order2.getOrderCost(), 0);
		
	}
	
}
