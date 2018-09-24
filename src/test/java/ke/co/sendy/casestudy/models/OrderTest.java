package ke.co.sendy.casestudy.models;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the order class
 *
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
		Assert.assertEquals(62, Math.ceil(order.getExpectedTravelDistance()), 0);
		Assert.assertEquals(1857.86, order.getOrderCost(), 0);
		
		Order order2 = new Order("Test Order 2", kiambu, kitui);
		
		Assert.assertEquals("Test Order 2", order2.getName());
		Assert.assertEquals(133, Math.ceil(order2.getExpectedTravelDistance()), 0);
		Assert.assertEquals(3982.51, order2.getOrderCost(), 0);
		
		Order order3 = new Order();
		order3.setName("Stationary Order");
		order3.setPickUpLocation(machakos);
		order3.setDropOffLocation(machakos);
		
		Assert.assertEquals("Stationary Order", order3.getName());
		Assert.assertEquals(machakos, order3.getPickUpLocation());
		Assert.assertEquals(machakos, order3.getDropOffLocation());
		
	}
	
}
