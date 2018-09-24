package ke.co.sendy.casestudy.util;

import ke.co.sendy.casestudy.models.Location;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test the helpers class
 * @author sukavi
 */
public class HelpersTest {
	
	@Test
	public void testRound() {
		Assert.assertEquals(12.3, Helpers.round(12.25, 1), 0);
	}
	
	@Test
	public void testCalculateDistance() {
		
		Location nairobi = new Location(-1.28333d, 36.81667d);
		nairobi.setName("Nairobi");
		
		Location kiambu = new Location(-1.16667d, 36.83333d);
		kiambu.setName("Kiambu");
		
		double distance = Helpers.calculateDistance(nairobi.getLatitude(), nairobi.getLongitude(),
				kiambu.getLatitude(), kiambu.getLongitude());
		
		Assert.assertEquals(13.10, Helpers.round(distance, 2), 0);
		
	}
	
}
