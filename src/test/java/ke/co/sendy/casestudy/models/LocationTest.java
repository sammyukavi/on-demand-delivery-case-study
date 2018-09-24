package ke.co.sendy.casestudy.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the location class
 *
 * @author sukavi
 */
public class LocationTest {
	
	@Test
	public void testLocationObject() {
		
		String name = "Name";
		double latitude = 0.53112d;
		double longitude = 37.45061d;
		
		Location instance = new Location();
		instance.setName(name);
		instance.setLatitude(latitude);
		instance.setLongitude(longitude);
		
		assertEquals(name, instance.getName());
		assertEquals(latitude, instance.getLatitude(), 0.0);
		assertEquals(longitude, instance.getLongitude(), 0.0);
		
	}
	
}
