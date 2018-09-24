package ke.co.sendy.casestudy;

import ke.co.sendy.casestudy.models.Location;
import ke.co.sendy.casestudy.models.Order;
import ke.co.sendy.casestudy.models.Route;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Test the estimator class
 *
 * @author sukavi
 */
public class EstimatorTest {
	
	@Test
	public void testEstimatorObject() throws Exception {
		
		Location maua = new Location("Maua", 0.23206, 37.94052);
		Location meru = new Location("Meru", 0.04626, 37.65587);
		Location embu = new Location("Embu", -0.53112, 37.45061);
		Location thika = new Location("Thika", -1.03326, 37.06933);
		Location kitui = new Location("Kitui", -1.36696d, 38.01055d);
		Location kiambu = new Location("Kiambu", -1.16667d, 36.83333d);
		Location nairobi = new Location("Nairobi", -1.28333d, 36.81667d);

		ArrayList<Route> expectedRoutesList = new ArrayList<>();
		Route route = new Route();
		route.setStartPoint(maua);
		route.setEndPoint(meru);
		route.addPickUpOrder(new Order("From Maua To Nairobi", maua, nairobi));
		expectedRoutesList.add(route);

		Route route1 = new Route();
		route1.setStartPoint(meru);
		route1.setEndPoint(embu);
		route1.addPickUpOrder(new Order("From Meru To Nairobi", meru, nairobi));
		route1.addPickUpOrder(new Order("From Meru To Embu", meru, embu));
		expectedRoutesList.add(route1);

		Route route2 = new Route();
		route2.setStartPoint(embu);
		route2.setEndPoint(thika);
		route2.addPickUpOrder(new Order("From Embu To Nairobi", embu, nairobi));
		route2.addDropOffOrder(new Order("From Meru To Embu", meru, embu));
		expectedRoutesList.add(route2);

		Route route3 = new Route();
		route3.setStartPoint(thika);
		route3.setEndPoint(kiambu);
		route3.addPickUpOrder(new Order("From Thika To Nairobi", thika, nairobi));
		route3.addDropOffOrder(new Order("From Kitui To Thika", kitui, thika));
		expectedRoutesList.add(route3);

		Route route4 = new Route();
		route4.setStartPoint(kiambu);
		route4.setEndPoint(nairobi);
		route4.addDropOffOrder(new Order("From Kitui To Kiambu", kitui, kiambu));
		expectedRoutesList.add(route4);

		Route route5 = new Route();
		route5.setStartPoint(nairobi);
		route5.setEndPoint(kitui);
		route5.addPickUpOrder(new Order("From Kitui To Thika", kitui, thika));
		route5.addPickUpOrder(new Order("From Kitui To Kiambu", kitui, kiambu));
		route5.addDropOffOrder(new Order("From Maua To Nairobi", maua, nairobi));
		route5.addDropOffOrder(new Order("From Meru To Nairobi", meru, nairobi));
		route5.addDropOffOrder(new Order("From Thika To Nairobi", thika, nairobi));
		route5.addDropOffOrder(new Order("From Embu To Nairobi", embu, nairobi));
		expectedRoutesList.add(route5);
		
		
		Estimator estimator = new Estimator();
		estimator.setRouteStartLocation(maua);
		assertEquals(maua, estimator.getRouteStartLocation());
		
		ArrayList<Order> orders = new ArrayList<>();
		
		orders.add(new Order("From Maua To Nairobi", maua, nairobi));
		orders.add(new Order("From Meru To Nairobi", meru, nairobi));
		orders.add(new Order("From Meru To Embu", meru, embu));
		orders.add(new Order("From Kitui To Thika", kitui, thika));
		orders.add(new Order("From Kitui To Kiambu", kitui, kiambu));
		orders.add(new Order("From Thika To Nairobi", thika, nairobi));
		orders.add(new Order("From Embu To Nairobi", embu, nairobi));
		
		Estimator instance = new Estimator();
		ArrayList<Route> actualRoutesList = instance.selectBestRoute(maua, orders);


		assertTrue(expectedRoutesList.containsAll(actualRoutesList));
		assertTrue(actualRoutesList.containsAll(expectedRoutesList));
		assertEquals(kitui, instance.getRouteEndLocation());
		assertEquals(expectedRoutesList, actualRoutesList);
	}
	
}
