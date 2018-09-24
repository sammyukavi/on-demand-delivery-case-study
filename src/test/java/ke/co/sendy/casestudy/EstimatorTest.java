package ke.co.sendy.casestudy;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ke.co.sendy.casestudy.models.Location;
import ke.co.sendy.casestudy.models.Order;
import ke.co.sendy.casestudy.models.Route;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;


/**
 * Test the estimator class
 *
 * @author sukavi
 */
public class EstimatorTest {
	
	@Test
	public void testEstimatorObject() throws Exception {
		
		String expectedResultsJson = "[{\"startPoint\":{\"name\":\"Maua\",\"latitude\":0.23206,\"longitude\":37.94052},\"endPoint\":{\"name\":\"Meru\",\"latitude\":0.04626,\"longitude\":37.65587},\"pickUpOrders\":[{\"name\":\"From Maua To Nairobi\",\"dropOffLocation\":{\"name\":\"Nairobi\",\"latitude\":-1.28333,\"longitude\":36.81667},\"pickUpLocation\":{\"name\":\"Maua\",\"latitude\":0.23206,\"longitude\":37.94052}}],\"dropOffOrders\":[]},{\"startPoint\":{\"name\":\"Meru\",\"latitude\":0.04626,\"longitude\":37.65587},\"endPoint\":{\"name\":\"Embu\",\"latitude\":-0.53112,\"longitude\":37.45061},\"pickUpOrders\":[{\"name\":\"From Meru To Nairobi\",\"dropOffLocation\":{\"name\":\"Nairobi\",\"latitude\":-1.28333,\"longitude\":36.81667},\"pickUpLocation\":{\"name\":\"Meru\",\"latitude\":0.04626,\"longitude\":37.65587}},{\"name\":\"From Meru To Embu\",\"dropOffLocation\":{\"name\":\"Embu\",\"latitude\":-0.53112,\"longitude\":37.45061},\"pickUpLocation\":{\"name\":\"Meru\",\"latitude\":0.04626,\"longitude\":37.65587}}],\"dropOffOrders\":[]},{\"startPoint\":{\"name\":\"Embu\",\"latitude\":-0.53112,\"longitude\":37.45061},\"endPoint\":{\"name\":\"Thika\",\"latitude\":-1.03326,\"longitude\":37.06933},\"pickUpOrders\":[],\"dropOffOrders\":[{\"name\":\"From Meru To Embu\",\"dropOffLocation\":{\"name\":\"Embu\",\"latitude\":-0.53112,\"longitude\":37.45061},\"pickUpLocation\":{\"name\":\"Meru\",\"latitude\":0.04626,\"longitude\":37.65587}}]},{\"startPoint\":{\"name\":\"Thika\",\"latitude\":-1.03326,\"longitude\":37.06933},\"endPoint\":{\"name\":\"Kiambu\",\"latitude\":-1.16667,\"longitude\":36.83333},\"pickUpOrders\":[],\"dropOffOrders\":[{\"name\":\"From Kitui To Thika\",\"dropOffLocation\":{\"name\":\"Thika\",\"latitude\":-1.03326,\"longitude\":37.06933},\"pickUpLocation\":{\"name\":\"Kitui\",\"latitude\":-1.36696,\"longitude\":38.01055}}]},{\"startPoint\":{\"name\":\"Kiambu\",\"latitude\":-1.16667,\"longitude\":36.83333},\"endPoint\":{\"name\":\"Nairobi\",\"latitude\":-1.28333,\"longitude\":36.81667},\"pickUpOrders\":[],\"dropOffOrders\":[{\"name\":\"From Kitui To Kiambu\",\"dropOffLocation\":{\"name\":\"Kiambu\",\"latitude\":-1.16667,\"longitude\":36.83333},\"pickUpLocation\":{\"name\":\"Kitui\",\"latitude\":-1.36696,\"longitude\":38.01055}},{\"name\":\"From Kitui To Kiambu\",\"dropOffLocation\":{\"name\":\"Kiambu\",\"latitude\":-1.16667,\"longitude\":36.83333},\"pickUpLocation\":{\"name\":\"Kitui\",\"latitude\":-1.36696,\"longitude\":38.01055}},{\"name\":\"From Thika To Nairobi\",\"dropOffLocation\":{\"name\":\"Kiambu\",\"latitude\":-1.16667,\"longitude\":36.83333},\"pickUpLocation\":{\"name\":\"Kitui\",\"latitude\":-1.36696,\"longitude\":38.01055}},{\"name\":\"From Embu To Nairobi\",\"dropOffLocation\":{\"name\":\"Kiambu\",\"latitude\":-1.16667,\"longitude\":36.83333},\"pickUpLocation\":{\"name\":\"Kitui\",\"latitude\":-1.36696,\"longitude\":38.01055}}]},{\"startPoint\":{\"name\":\"Nairobi\",\"latitude\":-1.28333,\"longitude\":36.81667},\"endPoint\":{\"name\":\"Kitui\",\"latitude\":-1.36696,\"longitude\":38.01055},\"pickUpOrders\":[],\"dropOffOrders\":[{\"name\":\"From Maua To Nairobi\",\"dropOffLocation\":{\"name\":\"Nairobi\",\"latitude\":-1.28333,\"longitude\":36.81667},\"pickUpLocation\":{\"name\":\"Maua\",\"latitude\":0.23206,\"longitude\":37.94052}},{\"name\":\"From Meru To Nairobi\",\"dropOffLocation\":{\"name\":\"Nairobi\",\"latitude\":-1.28333,\"longitude\":36.81667},\"pickUpLocation\":{\"name\":\"Meru\",\"latitude\":0.04626,\"longitude\":37.65587}}]},{\"startPoint\":{\"name\":\"Nairobi\",\"latitude\":-1.28333,\"longitude\":36.81667},\"endPoint\":{\"name\":\"Kitui\",\"latitude\":-1.36696,\"longitude\":38.01055},\"pickUpOrders\":[{\"name\":\"From Kitui To Thika\",\"dropOffLocation\":{\"name\":\"Thika\",\"latitude\":-1.03326,\"longitude\":37.06933},\"pickUpLocation\":{\"name\":\"Kitui\",\"latitude\":-1.36696,\"longitude\":38.01055}},{\"name\":\"From Kitui To Kiambu\",\"dropOffLocation\":{\"name\":\"Kiambu\",\"latitude\":-1.16667,\"longitude\":36.83333},\"pickUpLocation\":{\"name\":\"Kitui\",\"latitude\":-1.36696,\"longitude\":38.01055}},{\"name\":\"From Kitui To Kiambu\",\"dropOffLocation\":{\"name\":\"Kiambu\",\"latitude\":-1.16667,\"longitude\":36.83333},\"pickUpLocation\":{\"name\":\"Kitui\",\"latitude\":-1.36696,\"longitude\":38.01055}},{\"name\":\"From Thika To Nairobi\",\"dropOffLocation\":{\"name\":\"Kiambu\",\"latitude\":-1.16667,\"longitude\":36.83333},\"pickUpLocation\":{\"name\":\"Kitui\",\"latitude\":-1.36696,\"longitude\":38.01055}},{\"name\":\"From Embu To Nairobi\",\"dropOffLocation\":{\"name\":\"Kiambu\",\"latitude\":-1.16667,\"longitude\":36.83333},\"pickUpLocation\":{\"name\":\"Kitui\",\"latitude\":-1.36696,\"longitude\":38.01055}}],\"dropOffOrders\":[]}]";
		Gson gson = new Gson();
		ArrayList<Route> actualAnswer = gson.fromJson(expectedResultsJson, new TypeToken<ArrayList<Route>>() {
		}.getType());
		
		Location maua = new Location("Maua", 0.23206, 37.94052);
		Location meru = new Location("Meru", 0.04626, 37.65587);
		Location embu = new Location("Embu", -0.53112, 37.45061);
		Location thika = new Location("Thika", -1.03326, 37.06933);
		Location kitui = new Location("Kitui", -1.36696d, 38.01055d);
		Location kiambu = new Location("Kiambu", -1.16667d, 36.83333d);
		Location nairobi = new Location("Nairobi", -1.28333d, 36.81667d);
		
		
		Estimator estimator = new Estimator();
		estimator.setRouteStartLocation(maua);
		Assert.assertEquals(maua, estimator.getRouteStartLocation());
		
		ArrayList<Order> orders = new ArrayList<>();
		
		orders.add(new Order("From Maua To Nairobi", maua, nairobi));
		orders.add(new Order("From Meru To Nairobi", meru, nairobi));
		orders.add(new Order("From Meru To Embu", meru, embu));
		orders.add(new Order("From Kitui To Thika", kitui, thika));
		orders.add(new Order("From Kitui To Kiambu", kitui, kiambu));
		orders.add(new Order("From Kitui To Kiambu", kitui, kiambu));
		orders.add(new Order("From Thika To Nairobi", kitui, kiambu));
		orders.add(new Order("From Embu To Nairobi", kitui, kiambu));
		
		Estimator instance = new Estimator();
		ArrayList<Route> routes = instance.selectBestRoute(maua, orders);
		
		assertTrue(actualAnswer.containsAll(routes));
		assertTrue(routes.containsAll(actualAnswer));
		
	}
	
	
	
}
