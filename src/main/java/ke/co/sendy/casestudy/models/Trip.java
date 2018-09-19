package ke.co.sendy.casestudy.models;

import java.util.ArrayList;

/**
 * This class is the blue print of a trip that occurs during the picking up and delivery of orders
 *
 * @author sukavi
 */
public class Trip {
	
	/*
	A location where a trip starts
	 */
	private Location startPoint;
	
	/*
	A location where the trip ends
	 */
	private Location endPoint;
	
	/*
	A list of orders belonging to the trip
	 */
	private ArrayList<Order> orders = new ArrayList<>();
	
	
	private double fullDistance;
	
	public Trip() {
	
	}
	
	/**
	 * Get the starting point of a trip
	 *
	 * @return Location where the trip starts
	 */
	public Location getStartPoint() {
		return startPoint;
	}
	
	/**
	 * Set the starting point of a trip
	 *
	 * @param startPoint Location where the trip starts
	 */
	public void setStartPoint(Location startPoint) {
		this.startPoint = startPoint;
	}
	
	/**
	 * Get the ending point of a trip
	 *
	 * @return Location where the trip ends
	 */
	public Location getEndPoint() {
		return endPoint;
	}
	
	/**
	 * Set the ending point of a trip
	 *
	 * @param location Location where the trip ends
	 */
	public void setEndPoint(Location location) {
		this.endPoint = location;
	}
	
	/**
	 * Add an order to the list of orders belonging to the trip
	 *
	 * @param order the order to be added to the list of orders
	 */
	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
	/**
	 * Add an order to the list of orders belonging to the trip
	 *
	 * @return of orders belonging to the trip
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	/**
	 * Get the full distance to be covered in a trip
	 *
	 * @return the full distance covered in a trip
	 */
	public double getFullDistance() {
		return fullDistance;
	}
	
	/**
	 * Set the full distance to be covered in a trip
	 *
	 * @param fullDistance the full distance to be covered in a trip
	 */
	public void setFullDistance(double fullDistance) {
		this.fullDistance = fullDistance;
	}
}
