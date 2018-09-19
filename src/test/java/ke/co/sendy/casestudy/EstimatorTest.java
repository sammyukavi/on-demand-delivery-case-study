package ke.co.sendy.casestudy;

import ke.co.sendy.casestudy.models.Location;
import ke.co.sendy.casestudy.models.Order;
import ke.co.sendy.casestudy.models.Trip;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * This is a test class for testing the Estimator class and methods
 */
public class EstimatorTest {
	
	private Estimator estimator;
	private ArrayList<Order> orders;
	private Location x, y, z;
	private Order orderOne, orderTwo, orderThree;
	
	@Before
	public void setUp() {
		
		this.estimator = new Estimator();
		orders = new ArrayList<>();
		
		x = new Location(-1.1539109d, 36.8425681d);
		y = new Location(-1.2178389d, 36.4852861d);
		z = new Location(-1.3283943d, 36.8679232d);
		
		
		orderOne = new Order();
		orderOne.setName("Order One");
		orderOne.setPickUpLocation(x);
		orderOne.setDropOffLocation(y);
		orders.add(orderOne);
		
		
		orderTwo = new Order();
		orderTwo.setName("Order Two");
		orderTwo.setPickUpLocation(x);
		orderTwo.setDropOffLocation(z);
		orders.add(orderTwo);
		
		
		orderThree = new Order();
		orderThree.setName("Order Three");
		orderThree.setPickUpLocation(y);
		orderThree.setDropOffLocation(z);
		orders.add(orderThree);
	}
	
	@Test
	public void testSelectBestRoute() {
		
		ArrayList<Trip> expectedResult = new ArrayList<>();
		
		Trip tripOne = new Trip();
		tripOne.setStartPoint(x);
		tripOne.setEndPoint(z);
		tripOne.addOrder(orderTwo);
		expectedResult.add(tripOne);
		
		Trip tripTwo = new Trip();
		tripTwo.setStartPoint(x);
		tripTwo.setEndPoint(y);
		tripTwo.addOrder(orderOne);
		expectedResult.add(tripTwo);
		
		Trip tripThree = new Trip();
		tripThree.setStartPoint(y);
		tripThree.setEndPoint(z);
		tripThree.addOrder(orderThree);
		expectedResult.add(tripThree);
		
		ArrayList<Trip> bestRoute = estimator.selectBestRoute(orders);
		
		Assert.assertEquals(expectedResult, bestRoute);
		
	}
}
