package ke.co.sendy.casestudy;

import ke.co.sendy.casestudy.models.Location;
import ke.co.sendy.casestudy.models.Order;

import java.util.ArrayList;
import org.joda.time.DateTime;

/**
 * This application finds the shortest routes to deliver packages given the origin and destination
 */
public class MainApplication {
	
	
	/**
	 * This is the main entry point of the application
	 *
	 * @param args Any params passed via command line to the application
	 */
	public static void main(String[] args) {
		
		//We are going to simulate a package from Nairobi to Kampala
		//Another package will be leaving Malaba for Kampala
		//To simulate the process we first create locations for various orders
		
		Location nairobi = new Location(-1.28333d, 36.81667d);
		nairobi.setName("Nairobi");
                
		Location malaba = new Location(0.63457d, 34.2756d);
		malaba.setName("Malaba");
                
		Location jinja = new Location(0.43902d, 33.20317d);
		jinja.setName("Jinja");
                
		Location kampala = new Location(0.347596d, 32.582520d);
		kampala.setName("Kampala");
		
		//Then we create orders and add them to a list
		
		ArrayList<Order> orders = new ArrayList<>();
                DateTime dateTime = new DateTime();
		
		Order orderA = new Order();
		orderA.setName("Order A");
		orderA.setPickUpLocation(nairobi);
		orderA.setDropOffLocation(malaba);
		orderA.setDropOffTime(dateTime);
		orders.add(orderA);
		
		
		Order orderB = new Order();
		orderB.setName("Order B");
		orderB.setPickUpLocation(nairobi);
		orderB.setDropOffLocation(kampala);
                orderB.setDropOffTime(dateTime.plusMinutes(1));
		orders.add(orderB);
		
		
		Order orderC = new Order();
		orderC.setName("Order C");
		orderC.setPickUpLocation(malaba);
		orderC.setDropOffLocation(kampala);
                orderC.setDropOffTime(dateTime.minusHours(6));
		orders.add(orderC);
                
		Order orderD = new Order();
		orderD.setName("Order C");
		orderD.setPickUpLocation(malaba);
		orderD.setDropOffLocation(jinja);
                orderD.setDropOffTime(dateTime.minusHours(5));
		orders.add(orderD);
		
		//Create an instance of our estimator class
		Estimator estimator = new Estimator();
                estimator.setTripStartLocation(nairobi);		
		estimator.selectBestRoute(orders);
		
		/*
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
		}*/
		
	}
}
