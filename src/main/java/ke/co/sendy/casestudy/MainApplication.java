package ke.co.sendy.casestudy;

import ke.co.sendy.casestudy.models.Location;
import ke.co.sendy.casestudy.models.Order;

import java.util.ArrayList;

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
		
		/*
		We are going to simulate an order's journey from Nairobi to Kampala
		In  the trip another package will be leaving Malaba for Kampala
		,another package will be leaving Kisumu for Busia
		and another package will be leaving Busia for Kampala
		*/
		
		/*
		To simulate the process we first create pickup and delivery locations for various orders
		*/
		
		Location nairobi = new Location(-1.28333d, 36.81667d);
		nairobi.setName("Nairobi");
		
		Location malaba = new Location(0.63457d, 34.2756d);
		malaba.setName("Malaba");
		
		Location jinja = new Location(0.43902d, 33.20317d);
		jinja.setName("Jinja");
		
		Location kampala = new Location(0.347596d, 32.582520d);
		kampala.setName("Kampala");
		
		Location busia = new Location(0.46005d, 34.11169d);
		busia.setName("Busia");
		
		Location kisumu = new Location(-0.10221d, 34.76171d);
		kisumu.setName("Kisumu");
		
		/*
		Then we create orders and add them to a list
		 */
		ArrayList<Order> orders = new ArrayList<>();
		
		Order orderA = new Order();
		orderA.setName("Order A");
		orderA.setPickUpLocation(nairobi);
		orderA.setDropOffLocation(malaba);
		orders.add(orderA);
		
		Order orderB = new Order();
		orderB.setName("Order B");
		orderB.setPickUpLocation(nairobi);
		orderB.setDropOffLocation(kampala);
		orders.add(orderB);
		
		Order orderC = new Order();
		orderC.setName("Order C");
		orderC.setPickUpLocation(malaba);
		orderC.setDropOffLocation(kampala);
		orders.add(orderC);
		
		Order orderD = new Order();
		orderD.setName("Order D");
		orderD.setPickUpLocation(malaba);
		orderD.setDropOffLocation(jinja);
		orders.add(orderD);
		
		Order orderE = new Order();
		orderE.setName("Order E");
		orderE.setPickUpLocation(malaba);
		orderE.setDropOffLocation(busia);
		orders.add(orderE);
		
		Order orderF = new Order();
		orderF.setName("Order F");
		orderF.setPickUpLocation(kisumu);
		orderF.setDropOffLocation(busia);
		orders.add(orderF);
		
		/*
		Create an instance of our estimator class
		 */
		Estimator estimator = new Estimator();
		
		/*
		Set where the trip begins
		 */
		estimator.setTripStartLocation(nairobi);
		
		/*
		Ask for the best route
		 */
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
					System.out.println("\tOrder distance (KM): " + Helpers.round(order.getExpectedTravelDistance()));
					System.out.println("\tCost (KES): " + order.getOrderCost());
					System.out.println("\n");
				});
			}
		} else {
			System.out.println("\nNo orders for today\n");
		}*/
		
	}
}
