package ke.co.sendy.casestudy;

import ke.co.sendy.casestudy.models.Location;
import ke.co.sendy.casestudy.models.Order;
import ke.co.sendy.casestudy.models.Trip;
import ke.co.sendy.casestudy.util.Helpers;

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
    private Location tripStartLocation;

    /**
     * Set the location where a trip is set to begin
     *
     * @param location location where a trip is supposed to begin
     */
    void setTripStartLocation(Location location) {
        this.tripStartLocation = location;
    }

    /**
     * get the location where a trip is set to begin
     * @return location where a trip is set to begin
     */
    Location setTripStartLocation() {
        return tripStartLocation;
    }

    /**
     * Gets the best routes for delivery
     *
     * @param orders a list of orders to be delivered
     */
    ArrayList<Trip> selectBestRoute(ArrayList<Order> orders) {
        
        /*
        Get the difference between the start location and the different delivery
        locations
        */
        orders.forEach(order -> {
            System.out.println("============================================");
            System.out.println(order.getExpectedTravelDistanceKiloMetres());
            //locationArrayList.add(order.getPickUpLocation());
            //locationArrayList.add(order.getDropOffLocation());
        });
       

        return new ArrayList<>();
    }
    
    /**
     * Gets the best routes for delivery
     *
     * @param tripStartLocation the location where a trip is set to begin
     * @param orders a list of orders to be delivered
     */
    ArrayList<Trip> selectBestRoute(Location tripStartLocation, ArrayList<Order> orders) {
        this.tripStartLocation = tripStartLocation;
        return selectBestRoute(orders);
    }

    /**
     * Checks if a route exists in an existing map
     *
     * @param tripsMap a map containing trips
     * @param tripToCheck route to check if exists in the map
     * @return true if the route exists in the map or false if the route does
     * not exist in a map
     */
    private boolean containsTrip(Map<Trip, Double> tripsMap, Trip tripToCheck) {

        if (tripsMap.keySet().stream().anyMatch((trip) -> ((trip.getStartPoint() == tripToCheck.getStartPoint())
                && trip.getEndPoint() == tripToCheck.getEndPoint()))) {
            return true;
        }

        Trip similarTrip = new Trip();
        similarTrip.setStartPoint(tripToCheck.getEndPoint());
        similarTrip.setEndPoint(tripToCheck.getStartPoint());

        return tripsMap.keySet().stream().anyMatch((trip) -> ((trip.getStartPoint() == similarTrip.getStartPoint())
                && trip.getEndPoint() == similarTrip.getEndPoint()));
    }

}
