package ke.co.sendy.casestudy;

import ke.co.sendy.casestudy.models.Location;
import ke.co.sendy.casestudy.models.Order;
import ke.co.sendy.casestudy.models.Trip;
import ke.co.sendy.casestudy.util.Console;
import ke.co.sendy.casestudy.util.Helpers;

import java.util.*;

/**
 * This is the class that performs the application's estimation
 */
class Estimator {
	
	private Map<Order, Double> orderDistanceToDropOffMap = new LinkedHashMap<>();
	private Location tripStartLocation;
	private Location tripEndLocation;
	private ArrayList<Order> orderTripsArrayList = new ArrayList<>();
	private Order precedingOrder = null;
	private double previousOrderDistanceToDropOff;
	
	/**
	 * Get the location where a trip is set to begin
	 *
	 * @return location where a trip is set to begin
	 */
	Location getTripStartLocation() {
		return tripStartLocation;
	}
	
	/**
	 * Set the tripStartLocation where a trip is set to begin
	 *
	 * @param tripStartLocation tripStartLocation where a trip is supposed to begin
	 */
	void setTripStartLocation(Location tripStartLocation) {
		this.tripStartLocation = tripStartLocation;
	}
	
	/**
	 * Get the location where a trip is set to end
	 *
	 * @return location where a trip is supposed to end
	 */
	public Location getTripEndLocation() {
		return tripEndLocation;
	}
	
	/**
	 * Gets the best routes for delivery
	 *
	 * @param tripStartLocation the location where a trip is set to begin
	 * @param orders            a list of orders to be delivered
	 */
	ArrayList<Trip> selectBestRoute(Location tripStartLocation, ArrayList<Order> orders) {
		this.tripStartLocation = tripStartLocation;
		return selectBestRoute(orders);
	}
	
	/**
	 * Gets the best routes for delivery
	 *
	 * @param tripStartLocation the location where a trip is set to begin
	 * @param orders            a list of orders to be delivered
	 */
	ArrayList<Trip> selectBestRoute(Location tripStartLocation, Location tripEndLocation, ArrayList<Order> orders) {
		this.tripStartLocation = tripStartLocation;
		this.tripEndLocation = tripEndLocation;
		return selectBestRoute(orders);
	}
	
	/**
	 * Gets the best routes for delivery
	 *
	 * @param orders a list of orders to be delivered
	 */
	ArrayList<Trip> selectBestRoute(ArrayList<Order> orders) {
		
		/*
		  If an empty orders list is passed, avoid future errors by exiting.
		 */
		if (orders.isEmpty()) {
			return new ArrayList<>();
		}
        
        /*
        If no tripStartLocation is null, assume the pickupLocation of the first order is the tripStartLocation
        */
		
		if (tripStartLocation == null) {
			Order firstOrder = orders.get(0);
			tripStartLocation.setName(firstOrder.getPickUpLocation().getName());
			tripStartLocation.setLatitude(firstOrder.getPickUpLocation().getLatitude());
			tripStartLocation.setLongitude(firstOrder.getPickUpLocation().getLongitude());
		}
        
        /*
        Get the difference between the start location and the different delivery
        locations
        */
		orders.forEach(order -> {
			double distanceToDropOff = Helpers.calculateDistance(tripStartLocation.getLatitude(),
					tripStartLocation.getLongitude(), order.getDropOffLocation().getLatitude(),
					order.getDropOffLocation().getLongitude());
			orderDistanceToDropOffMap.put(order, distanceToDropOff);
		});
		
		/*
		 sort the orderDistanceToDropOffMap ascendingly, closest locations first
		 */
		orderDistanceToDropOffMap = Helpers.sortByValue(orderDistanceToDropOffMap);
		
		
		/*loop through orderDistanceToDropOffMap, if there is a duplicate in distance, check if the previous order's
		expectedTravelDistance is greater to the current, add them in order, else just add it to the list
		 */
		
		orderDistanceToDropOffMap.keySet().forEach((order) -> {
			
			if (precedingOrder != null) {
				if (previousOrderDistanceToDropOff == orderDistanceToDropOffMap.get(order)) {
					if (order.getExpectedTravelDistance() < precedingOrder.getExpectedTravelDistance()) {
						int orderIndex = orderTripsArrayList.indexOf(precedingOrder);
						orderTripsArrayList.add(orderIndex, order);
					}
				}
				orderTripsArrayList.add(order);
			} else {
				orderTripsArrayList.add(order);
			}
			precedingOrder = order;
			previousOrderDistanceToDropOff = orderDistanceToDropOffMap.get(order);
		});
		
		/*
		 * Remove duplicated orders in case some were created during our insert
		 */
		Set<Order> linkedHashSet = new LinkedHashSet<>(orderTripsArrayList);
		orderTripsArrayList.clear();
		orderTripsArrayList.addAll(linkedHashSet);
		
		orderTripsArrayList.forEach(order -> {
			Console.log(order.getDropOffLocation().getName());
		});
		
		
		return new ArrayList<>();
	}
	
	
}
