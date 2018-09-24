package ke.co.sendy.casestudy.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Test the route class
 *
 * @author sukavi
 */
public class RouteTest {
	
	@Test
	public void testRouteObject() {
		
		String routeName = "Test Route";
		String orderName = "Test Order";
		Location kiambu = new Location(-1.16667d, 36.83333d);
		Location machakos = new Location(-1.51667d, 37.26667d);
		Location kitui = new Location(-1.36696d, 38.01055d);
		
		
		Order pickUpOrder = new Order();
		pickUpOrder.setName(orderName);
		pickUpOrder.setPickUpLocation(machakos);
		pickUpOrder.setDropOffLocation(kitui);
		
		
		Order dropOffOrder = new Order();
		dropOffOrder.setName(orderName);
		dropOffOrder.setPickUpLocation(kitui);
		dropOffOrder.setDropOffLocation(kiambu);
		
		
		/*
		Test the getters and the setters
		 */
		Route route = new Route();
		route.setName(routeName);
		route.setStartPoint(kiambu);
		route.setEndPoint(machakos);
		route.addPickUpOrder(pickUpOrder);
		route.addDropOffOrder(dropOffOrder);
		
		ArrayList<Order> pickUpOrders = new ArrayList<>();
		pickUpOrders.add(pickUpOrder);
		
		ArrayList<Order> dropOffOrders = new ArrayList<>();
		dropOffOrders.add(dropOffOrder);
		
		
		Assert.assertEquals(routeName, route.getName());
		Assert.assertEquals(kiambu, route.getStartPoint());
		Assert.assertEquals(machakos, route.getEndPoint());
		Assert.assertEquals(pickUpOrders, route.getPickUpOrders());
		Assert.assertEquals(dropOffOrders, route.getDropOffOrders());
		
		Route route1 = new Route(routeName, kiambu, machakos);
		Assert.assertEquals(62, Math.ceil(route1.getDistance()), 0);
		
	}
}
