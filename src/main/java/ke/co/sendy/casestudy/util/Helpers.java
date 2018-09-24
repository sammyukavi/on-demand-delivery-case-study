package ke.co.sendy.casestudy.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static ke.co.sendy.casestudy.util.Constants.BillingUnits.ROUND_TO_PLACES;

/**
 * This class contains helper functions used in the application
 */
public class Helpers {
	
	private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM
	
	
	/**
	 * Rounds numbers to defined decimal places
	 *
	 * @param value  The number to be rounded off
	 * @param places The decimal places to be used
	 * @return The rounded number
	 */
	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();
		
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	
	/**
	 * Rounds numbers to defined decimal places
	 *
	 * @param value The number to be rounded off
	 * @return The rounded number
	 */
	public static double round(double value) {
		return round(value, ROUND_TO_PLACES);
	}
	
	/**
	 * Calculates the distance between two locations using the Haversine formula.
	 *
	 * @param latitude1  Latitude of location 1
	 * @param longitude1 Longitude of location 1
	 * @param latitude2  Latitude of location 2
	 * @param longitude2 Latitude of location 2
	 * @return distance in the given units
	 */
	public static double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
		
		double dLat = Math.toRadians((latitude2 - latitude1));
		double dLong = Math.toRadians((longitude2 - longitude1));
		
		latitude1 = Math.toRadians(latitude1);
		latitude2 = Math.toRadians(latitude2);
		
		double a = haversin(dLat) + Math.cos(latitude1) * Math.cos(latitude2) * haversin(dLong);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		
		return EARTH_RADIUS * c;
	}
	
	/**
	 * Calculates a sin for use with the Haversine formula.
	 *
	 * @param value number to use for calculation
	 * @return calculated value
	 */
	private static double haversin(double value) {
		return Math.pow(Math.sin(value / 2), 2);
	}
}