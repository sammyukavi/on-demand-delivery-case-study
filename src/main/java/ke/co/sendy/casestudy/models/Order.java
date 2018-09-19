package ke.co.sendy.casestudy.models;

import com.sun.istack.internal.NotNull;
import ke.co.sendy.casestudy.util.Helpers;

import java.util.Date;

import static ke.co.sendy.casestudy.util.Constants.BillingUnits.COST_PER_KILOMETRE;
import static ke.co.sendy.casestudy.util.Constants.BillingUnits.ROUND_TO_PLACES;
import static ke.co.sendy.casestudy.util.Constants.DistanceUnits.KILOMETRES;
import static ke.co.sendy.casestudy.util.Helpers.calculateDistance;

/**
 * This class is a blueprint for the Order model
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
	 * The time when an order was dropped off for delivery
	 */
	private Date dropOffTime;
	
	/**
	 * The location where an order is going to be picked up
	 */
	private Location pickUpLocation;
	
	
	Order(String name, Location pickUpLocation, Location dropOffLocation) {
		this.name = name;
		this.pickUpLocation = pickUpLocation;
		this.dropOffLocation = dropOffLocation;
	}
	
	public Order() {
	
	}
	
	/**
	 * Get the name of the order
	 *
	 * @return a string containing the name of the order
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name of the order
	 *
	 * @param name a string containing the name of the order
	 */
	public void setName(@NotNull String name) {
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
	public void setDropOffLocation(@NotNull Location dropOffLocation) {
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
	public void setPickUpLocation(@NotNull Location pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
	
	/**
	 * Get the calculated cost of an order
	 *
	 * @return a float containing the cost of the order
	 */
	public double getOrderCost() {
		return Helpers.round(getExpectedTravelDistanceKiloMetres() * COST_PER_KILOMETRE, ROUND_TO_PLACES);
	}
	
	/**
	 * Get the distance between the pick up location and drop off location in kilometres
	 *
	 * @return a double indicating the distance between the pick up location and drop off location in kilometres
	 */
	public double getExpectedTravelDistanceKiloMetres() {
		return calculateDistance(pickUpLocation.getLatitude(), pickUpLocation.getLongitude(), dropOffLocation.getLatitude(),
				dropOffLocation.getLongitude(), KILOMETRES);
	}
	
	/**
	 * Get the time when an order was dropped off.
	 *
	 * @return the time when an order was dropped off
	 */
	public Date getDropOffTime() {
		return dropOffTime;
	}
	
	/**
	 * Set the time when an order was dropped off
	 *
	 * @param dropOffTime the time when an order was dropped off
	 */
	public void setDropOffTime(@NotNull Date dropOffTime) {
		this.dropOffTime = dropOffTime;
	}
}
