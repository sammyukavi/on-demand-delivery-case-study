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
	
	public Route(String name, Location startPoint, Location endPoint) {
		this.name = name;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
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
	 * Add a list of orders to the list of pick Up Orders belonging to the route
	 *
	 * @param orders A list of orders to be added to the list of pick Up Orders
	 */
	public void addPickUpOrders(ArrayList<Order> orders) {
		this.pickUpOrders.addAll(orders);
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
	
	/**
	 * Get the name of a route
	 *
	 * @return the name of a route
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name of a route
	 *
	 * @param name the name of the route
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the length of a route in Kilometres. Calculated as the difference between a start point and  end point of a
	 * route
	 *
	 * @return length of a route in Kilometres
	 */
	public double getDistance() {
		return Helpers.calculateDistance(startPoint.getLatitude(), startPoint.getLongitude(),
				endPoint.getLatitude(), endPoint.getLongitude());
	}
	
	/**
	 * Add an order that should be dropped off
	 *
	 * @param order the order to be dropped off.
	 */
	public void addDropOffOrder(Order order) {
		this.dropOffOrders.add(order);
		Set<Order> linkedHashSet = new LinkedHashSet<>(this.dropOffOrders);
		this.dropOffOrders.clear();
		this.dropOffOrders.addAll(linkedHashSet);
	}
	
	/**
	 * Add a list of orders that should be dropped off
	 *
	 * @param orders The list of orders to be dropped off.
	 */
	public void addDropOffOrders(ArrayList<Order> orders) {
		this.dropOffOrders.addAll(orders);
		Set<Order> linkedHashSet = new LinkedHashSet<>(this.dropOffOrders);
		this.dropOffOrders.clear();
		this.dropOffOrders.addAll(linkedHashSet);
	}
	
	/**
	 * Get list of orders that should be dropped off
	 *
	 * @return list of orders to be dropped off
	 */
	public ArrayList<Order> getDropOffOrders() {
		return dropOffOrders;
	}
	
}
