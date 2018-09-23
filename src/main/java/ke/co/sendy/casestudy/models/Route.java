package ke.co.sendy.casestudy.models;

import ke.co.sendy.casestudy.util.Helpers;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * This class is the blue print of a route that occurs during the picking up and delivery of pickUpOrders
 *
 * @author sukavi
 */
public class Route {
	
	/*
	A location where a route starts
	 */
	private Location startPoint;
	
	/*
	A location where the route ends
	 */
	private Location endPoint;
	
	/*
	A list of pick Up Orders belonging to the route
	 */
	private ArrayList<Order> pickUpOrders = new ArrayList<>();
	
	/*
	A list of drop off Orders belonging to the route
	 */
	private ArrayList<Order> dropOffOrders = new ArrayList<>();
	
	/**
	 * The name of the route.
	 */
	private String name;
	
	public Route() {
	
	}
	
	/**
	 * Get the starting point of a route
	 *
	 * @return Location where the route starts
	 */
	public Location getStartPoint() {
		return startPoint;
	}
	
	/**
	 * Set the starting point of a route
	 *
	 * @param startPoint Location where the route starts
	 */
	public void setStartPoint(Location startPoint) {
		this.startPoint = startPoint;
	}
	
	/**
	 * Get the ending point of a route
	 *
	 * @return Location where the route ends
	 */
	public Location getEndPoint() {
		return endPoint;
	}
	
	/**
	 * Set the ending point of a route
	 *
	 * @param location Location where the route ends
	 */
	public void setEndPoint(Location location) {
		this.endPoint = location;
	}
	
	/**
	 * Add an order to the list of pick Up Orders belonging to the route
	 *
	 * @param order the order to be added to the list of pick Up Orders
	 */
	public void addPickUpOrder(Order order) {
		this.pickUpOrders.add(order);
		Set<Order> linkedHashSet = new LinkedHashSet<>(this.pickUpOrders);
		this.pickUpOrders.clear();
		this.pickUpOrders.addAll(linkedHashSet);
	}
	
	/**
	 * Add an order to the list of pickUpOrders belonging to the route
	 *
	 * @return of pickUpOrders belonging to the route
	 */
	public ArrayList<Order> getPickUpOrders() {
		return pickUpOrders;
	}
	
	public void setPickUpOrders(ArrayList<Order> pickUpOrders) {
		this.pickUpOrders = pickUpOrders;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getDistance() {
		return Helpers.calculateDistance(startPoint.getLatitude(), startPoint.getLongitude(),
				endPoint.getLatitude(), endPoint.getLongitude());
	}
	
	public void addDropOffOrder(Order order) {
		this.dropOffOrders.add(order);
		Set<Order> linkedHashSet = new LinkedHashSet<>(this.dropOffOrders);
		this.dropOffOrders.clear();
		this.dropOffOrders.addAll(linkedHashSet);
	}
	
	public ArrayList<Order> getDropOffOrders() {
		return dropOffOrders;
	}
	
	public void setDropOffOrders(ArrayList<Order> dropOffOrders) {
		this.dropOffOrders = dropOffOrders;
	}
}
