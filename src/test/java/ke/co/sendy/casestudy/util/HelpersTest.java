package ke.co.sendy.casestudy.util;

import ke.co.sendy.casestudy.models.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a test class for testing the Helper class and methods
 */
public class HelpersTest {
	
	private Map<Order, String> items = new HashMap<>();
	private Map<Order, String> expected = new HashMap<>();
	private double number = 1.0456;
	
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
	
	@Test
	public void testRound() {
		double result = Helpers.round(number);
		Assert.assertEquals(1.05, result, 2);
	}
	
	@Test
	public void testRoundWithPlaces() {
		double result = Helpers.round(number, 1);
		Assert.assertEquals(1.0, result, 0);
	}
	
	@Test
	public void testCalculateDistance() {
		double result = Helpers.calculateDistance(-1.300176, 36.776714, -1.256631, 36.852722);
		Assert.assertEquals(10, Math.ceil(result), 0);
	}
	
	@Test
	public void testSortByValue() {
		Map<Order, String> sorted = Helpers.sortByValue(items);
		Assert.assertEquals(expected, sorted);
	}
	
}
