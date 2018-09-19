package ke.co.sendy.casestudy.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static ke.co.sendy.casestudy.util.Constants.BillingUnits.ROUND_TO_PLACES;

/**
 * This class contains helper functions used in the application
 */
public class HelperFunctions {
	
	/**
	 * Sorts a map by value
	 *
	 * @param map the map to be sorted
	 * @param <K> any object
	 * @param <V> any object
	 * @return sorted map
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue());
		
		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		
		return result;
	}
	
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
	 * Converts decimal degrees to radians
	 *
	 * @param deg a double containing the degrees to convert
	 * @return a double containing the converted radians
	 */
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	/**
	 * Converts radians to decimal degrees
	 *
	 * @param rad a double containing the radians to convert to degrees
	 * @return a double containing the converted degrees
	 */
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	/**
	 * Calculates the distance between two locations
	 *
	 * @param lat1 Latitude of location 1
	 * @param lon1 Longitude of location 1
	 * @param lat2 Latitude of location 2
	 * @param lon2 Latitude of location 2
	 * @param unit Measurement unit to be used in calculation
	 * @return distance in the given units
	 */
	public static double calculateDistance(double lat1, double lon1, double lat2, double lon2, String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (("K").equals(unit)) {
			dist = dist * 1.609344;
		} else if (("N").equals(unit)) {
			dist = dist * 0.8684;
		}
		
		return (dist);
	}
	
}