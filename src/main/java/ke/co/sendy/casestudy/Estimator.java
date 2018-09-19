package ke.co.sendy.casestudy;

import ke.co.sendy.casestudy.models.Location;
import ke.co.sendy.casestudy.models.Order;
import ke.co.sendy.casestudy.models.Trip;
import ke.co.sendy.casestudy.util.HelperFunctions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static ke.co.sendy.casestudy.util.Constants.DistanceUnits.KILOMETRES;

/**
 * This is the class that performs the application's estimation
 */
class Estimator {
	
	private ArrayList<Location> locationArrayList = new ArrayList<>();
	private Map<Trip, Double> locationsMap = new LinkedHashMap<>();
	
	/**
	 * Gets the best routes for delivery
	 *
	 * @param orders a list of orders to be delivered
	 */
	ArrayList<Trip> selectBestRoute(ArrayList<Order> orders) {
		
		/*
		Create a list of orders with travel kilometers
		 */
		
		orders.forEach(order -> {
			locationArrayList.add(order.getPickUpLocation());
			locationArrayList.add(order.getDropOffLocation());
		});
		
		/*
		Create a map of locations with distances between each location
		 */
		locationArrayList.forEach(locationA -> locationArrayList.forEach(locationB -> {
			double distanceDifference = HelperFunctions.calculateDistance(locationA.getLatitude(), locationA.getLongitude(),
					locationB.getLatitude(), locationB.getLongitude(), KILOMETRES);
			if (locationA.getLatitude() != locationB.getLatitude()
					&& locationA.getLongitude() != locationB.getLongitude()) {
				Trip trip = new Trip();
				trip.setStartPoint(locationA);
				trip.setEndPoint(locationB);
				trip.setFullDistance(distanceDifference);
				if (!containsRoute(locationsMap, trip)) {
					locationsMap.put(trip, distanceDifference);
				}
			}
		}));
		
		locationsMap = HelperFunctions.sortByValue(locationsMap);
		
		/*
		Get all orders to be picked or dropped during a specific trip
		 */
		
		ArrayList<Trip> tripsWithOrders = new ArrayList<>();
		
		for (Trip trip : locationsMap.keySet()) {
			orders.forEach(order -> {
				if (order.getPickUpLocation() == trip.getStartPoint() && order.getDropOffLocation() == trip.getEndPoint()) {
					trip.addOrder(order);
					tripsWithOrders.add(trip);
				}
			});
		}
		
		return tripsWithOrders;
		
	}
	
	/**
	 * Checks if a route exists in an existing map
	 *
	 * @param tripsMap    a map containing trips
	 * @param tripToCheck route to check if exists in the map
	 * @return true if the route exists in the map or false if the route does not exist in a map
	 */
	private boolean containsRoute(Map<Trip, Double> tripsMap, Trip tripToCheck) {
		
		for (Trip trip : tripsMap.keySet()) {
			if ((trip.getStartPoint() == tripToCheck.getStartPoint()) &&
					trip.getEndPoint() == tripToCheck.getEndPoint()) {
				return true;
			}
		}
		
		Trip similarTrip = new Trip();
		similarTrip.setStartPoint(tripToCheck.getEndPoint());
		similarTrip.setEndPoint(tripToCheck.getStartPoint());
		
		for (Trip trip : tripsMap.keySet()) {
			if ((trip.getStartPoint() == similarTrip.getStartPoint()) &&
					trip.getEndPoint() == similarTrip.getEndPoint()) {
				return true;
			}
		}
		
		return false;
	}
	
}


