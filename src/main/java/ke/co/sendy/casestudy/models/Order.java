package ke.co.sendy.casestudy.models;

import static ke.co.sendy.casestudy.util.Constants.BillingUnits.COST_PER_KILOMETRE;
import static ke.co.sendy.casestudy.util.Constants.DistanceUnits.KILOMETRES;

/**
 * This is a blueprint for the Order model
 *
 * @author Sammy Ukavi
 */
public class Order {
	
	/**
	 * The name of the order to be picked/delivered
	 */
	private String name;
	
	/**
	 * The location where an order is going to be dropped off
	 */
	private Location dropOffLocation;
	
	/**
	 * The location where an order is going to be picked up
	 */
	private Location pickUpLocation;
	
	Order(String name, Location pickUpLocation, Location dropOffLocation) {
		this.name = name;
		this.pickUpLocation = pickUpLocation;
		this.dropOffLocation = dropOffLocation;
	}
	
	Order() {
	
	}
	
	/**
	 * Converts decimal degrees to radians
	 *
	 * @param deg a double containing the degrees to convert
	 * @return a double containing the converted radians
	 */
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	/**
	 * Converts radians to decimal degrees
	 *
	 * @param rad a double containing the radians to convert to degrees
	 * @return a double containing the converted degrees
	 */
	private double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	
	private double calculateDistance(double lat1, double lon1, double lat2, double lon2, String unit) {
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
	
	/**
	 * Get the name of the order
	 *
	 * @return a string containing the name of the order
	 */
	String getName() {
		return name;
	}
	
	/**
	 * Set the name of the order
	 *
	 * @param name a string containing the name of the order
	 */
	void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the drop off location of an order
	 *
	 * @return a location object with co-ordinates
	 */
	public Location getDropOffLocation() {
		return dropOffLocation;
	}
	
	/**
	 * Set the drop off location of an order
	 *
	 * @param dropOffLocation a location object with co-ordinates
	 */
	void setDropOffLocation(Location dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}
	
	/**
	 * Get the pickup location of an order
	 *
	 * @return a location object with co-ordnates
	 */
	public Location getPickUpLocation() {
		return pickUpLocation;
	}
	
	/**
	 * Set the pick up location of an order
	 *
	 * @param pickUpLocation a location object with co-ordinates
	 */
	void setPickUpLocation(Location pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
	
	/**
	 * Get the calculated cost of an order
	 *
	 * @return a float containing the cost of the order
	 */
	double getOrderCost() {
		return getTravelDistanceKiloMetres() * COST_PER_KILOMETRE;
	}
	
	/**
	 * Get the distance between the pick up location and drop off location in kilometres
	 *
	 * @return a double indicating the distance between the pick up location and drop off location in kilometres
	 */
	double getTravelDistanceKiloMetres() {
		return calculateDistance(pickUpLocation.getLatitude(), pickUpLocation.getLongitude(), dropOffLocation.getLatitude(),
				dropOffLocation.getLongitude(), KILOMETRES);
	}
	
}
