package ke.co.sendy.casestudy;

import ke.co.sendy.casestudy.models.Location;
import ke.co.sendy.casestudy.models.Order;
import ke.co.sendy.casestudy.models.Route;
import ke.co.sendy.casestudy.util.Helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the class that performs the application's estimation
 */
class Estimator {
	
	/**
	 * Holds a list of all locations
	 */
	private Set<Location> locations = new HashSet<>();
	
	/**
	 * Various points on which stops will occur when orders are being picked up or dropped
	 */
	private ArrayList<Location> stopPoints = new ArrayList<>();
	
	/**
	 * The location where a route is set to begin
	 */
	private Location routeStartLocation;
	
	/**
	 * The location where a route is set to begin
	 */
	private Location routeEndLocation;
	
	/**
	 * Get the location where a route is set to begin
	 *
	 * @return location where a route is set to begin
	 */
	Location getRouteStartLocation() {
		return routeStartLocation;
	}
	
	/**
	 * Set the location where a route to order's delivery is set to begin
	 *
	 * @param routeStartLocation location where a route to order's delivery is set to begin
	 */
	void setRouteStartLocation(Location routeStartLocation) {
		this.routeStartLocation = routeStartLocation;
	}
	
	/**
	 * Get an estimated location where a trip is set to end
	 *
	 * @return Location estimated where a trip is set to end
	 */
	public Location getRouteEndLocation() {
		return routeEndLocation;
	}
	
	/**
	 * Gets the best routes for delivery
	 *
	 * @param routeStartLocation the location where a route is set to begin
	 * @param orders             a list of orders to be delivered
	 */
	ArrayList<Route> selectBestRoute(Location routeStartLocation, ArrayList<Order> orders) throws Exception {
		this.routeStartLocation = routeStartLocation;
		return selectBestRoute(orders);
	}
	
	/**
	 * Gets the best routes for delivery
	 *
	 * @param orders a list of orders to be delivered
	 */
	ArrayList<Route> selectBestRoute(ArrayList<Order> orders) throws Exception {

        /*
        If no routeStartLocation is null, assume the pickupLocation of the first order is the routeStartLocation
         */
		if (routeStartLocation == null) {
			throw new Exception("Route Start Location Is Required");
		}

        /*
		  If an empty orders list is passed, avoid errors ahead by exiting.
         */
		if (orders.isEmpty()) {
			return new ArrayList<>();
		}
		
		/*
		Sort according to distance from routeStartLocation
		Get first dropOffLocation
		From there start getting the closest town from the dropOff and so on
		 */
		
		orders.forEach(order -> {
			locations.add(order.getPickUpLocation());
			locations.add(order.getDropOffLocation());
		});
		
		/*
		Get the shortest route from the start point to any location. That will be our first stop point
		 */
		final double[] closestDistanceFromStartPoint = {0};
		final Location[] closestLocationFromStartPoint = {null};
		
		locations.forEach(location -> {
			if (location != routeStartLocation) {
				double distance = Helpers.calculateDistance(
						routeStartLocation.getLatitude(), routeStartLocation.getLongitude(),
						location.getLatitude(), location.getLongitude()
				);
				if (distance < closestDistanceFromStartPoint[0] || closestDistanceFromStartPoint[0] == 0) {
					closestDistanceFromStartPoint[0] = distance;
					closestLocationFromStartPoint[0] = location;
				}
			}
		});
		
		/*
		Add where our route starts
		 */
		stopPoints.add(routeStartLocation);
		locations.remove(routeStartLocation);
		
		/*
		Get the closest location from the route start point which becomes a stop point
		 */
		stopPoints.add(closestLocationFromStartPoint[0]);
		locations.remove(closestLocationFromStartPoint[0]);
		
		/*
		Run a loop to get the closest location from each stop point.
		Once found remove the location from the ArrayList to eliminate repetition, duplicated and an infinite loop
		 */
		while (!locations.isEmpty()) {
			Location nextLocation = getClosestLocation(closestLocationFromStartPoint[0]);
			closestLocationFromStartPoint[0] = nextLocation;
			locations.remove(nextLocation);
			stopPoints.add(nextLocation);
		}
		
		/*
		Create a list of routes with various orders
		 */
		ArrayList<Route> routesWithOrders = new ArrayList<>();
		
		for (int index = 0; index < stopPoints.size(); index++) {
			
			/*
			Merge the last two stop points to make one trip. It all makes sense. Trust me.
			 */
			if (index + 1 == stopPoints.size()) {
				break;
			}
			
			Location location = stopPoints.get(index);
			
			Route route = new Route();
			
			route.setStartPoint(location);
			
			route.setEndPoint(stopPoints.get(index + 1));
			
			if (index == stopPoints.size() - 2) {
				
				route.addPickUpOrders(getPickUpOrders(orders, location));
				
				route.addDropOffOrders(getDropOffOrders(orders, location));
				
				location = stopPoints.get(index + 1);
				
			}
			
			route.addPickUpOrders(getPickUpOrders(orders, location));
			
			route.addDropOffOrders(getDropOffOrders(orders, location));
			
			routesWithOrders.add(route);
			
		}
		
		if (!routesWithOrders.isEmpty()) {
			this.routeEndLocation = routesWithOrders.get(routesWithOrders.size() - 1).getEndPoint();
		}
		
		return routesWithOrders;
	}
	
	/**
	 * Get a list of pickup orders from a location
	 *
	 * @param orders   List of all orders in a trip
	 * @param location Location where you'd like to extract the list of orders
	 * @return ArrayList of orders from a certain location
	 */
	private ArrayList<Order> getPickUpOrders(ArrayList<Order> orders, Location location) {
		ArrayList<Order> pickUpOrders = new ArrayList<>();
		orders.forEach(order -> {
			if (order.getPickUpLocation() == location) {
				pickUpOrders.add(order);
			}
		});
		return pickUpOrders;
	}
	
	/**
	 * Get a list of dropOff orders from a location
	 *
	 * @param orders   List of all orders in a trip
	 * @param location Location where you'd like to extract the list of orders
	 * @return ArrayList of orders from a certain location
	 */
	private ArrayList<Order> getDropOffOrders(ArrayList<Order> orders, Location location) {
		ArrayList<Order> dropOffOrders = new ArrayList<>();
		orders.forEach(order -> {
			if (order.getDropOffLocation() == location) {
				dropOffOrders.add(order);
			}
		});
		return dropOffOrders;
	}
	
	/**
	 * Checks for the closest location from one location using the global locations ArrayList
	 *
	 * @param checkLocation location to check for the closest
	 * @return the closest location to that given
	 */
	private Location getClosestLocation(Location checkLocation) {
		
		final double[] closestDistance = {0};
		final Location[] closestLocation = {null};
		
		locations.forEach(location -> {
			if (location != checkLocation) {
				double distance = Helpers.calculateDistance(
						checkLocation.getLatitude(), checkLocation.getLongitude(),
						location.getLatitude(), location.getLongitude()
				);
				if (distance < closestDistance[0] || closestDistance[0] == 0) {
					closestDistance[0] = distance;
					closestLocation[0] = location;
				}
			}
		});
		
		return closestLocation[0];
	}
	
}
