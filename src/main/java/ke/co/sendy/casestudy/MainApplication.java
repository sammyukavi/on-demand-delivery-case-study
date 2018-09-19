package ke.co.sendy.casestudy;

import ke.co.sendy.casestudy.models.Location;
import ke.co.sendy.casestudy.models.Order;
import ke.co.sendy.casestudy.models.Trip;
import ke.co.sendy.casestudy.util.Helpers;

import java.util.ArrayList;

/**
 * This application finds the shortest routes to deliver packages given the origin and destination
 */
public class MainApplication {
	
	
	/**
	 * This is the main entry point of the application
	 *
	 * @param args Any params passed via commandline to the application
	 */
	public static void main(String[] args) {
		
		//To simulate the process we first create locations for various orders
		
		Location x = new Location(-1.2833d, 36.8167d);
		Location y = new Location(-1.3178389d, 36.8425681d);
		Location z = new Location(-1.3283943d, 36.8679232d);
		
		//Then we create orders and add them to a list
		
		ArrayList<Order> orders = new ArrayList<>();
		
		Order orderA = new Order();
		orderA.setName("Order A");
		orderA.setPickUpLocation(x);
		orderA.setDropOffLocation(y);
		orders.add(orderA);
		
		
		Order orderB = new Order();
		orderB.setName("Order B");
		orderB.setPickUpLocation(x);
		orderB.setDropOffLocation(z);
		orders.add(orderB);
		
		
		Order orderC = new Order();
		orderC.setName("Order C");
		orderC.setPickUpLocation(y);
		orderC.setDropOffLocation(z);
		orders.add(orderC);
		
		//Create an instance of our estimator class
		Estimator estimator = new Estimator();
		
		ArrayList<Trip> tripsWithOrders = estimator.selectBestRoute(orders);
		
		if (!tripsWithOrders.isEmpty()) {
			
			System.out.println("\nWe suggest the following routes for delivery of orders\n");
			
			for (int index = 0; index < tripsWithOrders.size(); index++) {
				Trip trip = tripsWithOrders.get(index);
				ArrayList<Order> fullTripOrders = trip.getOrders();
				System.out.println("Route: " + (index + 1));
				System.out.println("Route Distance (KM): " + Helpers.round(trip.getFullDistance()));
				System.out.println("Route Start Point: " + trip.getStartPoint().getLatitude() + "," +
						trip.getStartPoint().getLongitude());
				System.out.println("Route End Point: " + trip.getEndPoint().getLatitude() + "," +
						trip.getEndPoint().getLongitude());
				System.out.println("\n\tTrip Orders");
				System.out.println("\tTotal Orders: " + fullTripOrders.size() + "\n\t---");
				fullTripOrders.forEach(order -> {
					System.out.println("\tOrder name: " + order.getName());
					System.out.println("\tOrder destination: " + order.getDropOffLocation().getLatitude() + "," +
							order.getDropOffLocation().getLongitude());
					System.out.println("\tOrder distance (KM): " + Helpers.round(order.getExpectedTravelDistanceKiloMetres()));
					System.out.println("\tCost (KES): " + order.getOrderCost());
					System.out.println("\n");
				});
			}
		} else {
			System.out.println("\nNo orders for today\n");
		}
		
	}
}
