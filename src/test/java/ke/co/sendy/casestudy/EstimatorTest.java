package ke.co.sendy.casestudy;

import ke.co.sendy.casestudy.models.Location;
import ke.co.sendy.casestudy.models.Order;
import ke.co.sendy.casestudy.models.Trip;
import org.junit.*;

import java.util.ArrayList;

/**
 * This is a test class for testing the Estimator class and methods
 */
public class EstimatorTest {
	
	private Estimator estimator;
	private ArrayList<Order> orders;
	private Location busia, thika, mombasa;
	private Order orderOne, orderTwo, orderThree;
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		
		this.estimator = new Estimator();
		orders = new ArrayList<>();
		
		busia = new Location(-1.1539109d, 36.8425681d);
		busia.setName("Busia");
		thika = new Location(-1.2178389d, 36.4852861d);
		thika.setName("Thika");
		mombasa = new Location(-1.3283943d, 36.8679232d);
		mombasa.setName("Mombasa");
		
		orderOne = new Order();
		orderOne.setName("Order One");
		orderOne.setPickUpLocation(busia);
		orderOne.setDropOffLocation(thika);
		orders.add(orderOne);
		
		orderTwo = new Order();
		orderTwo.setName("Order Two");
		orderTwo.setPickUpLocation(busia);
		orderTwo.setDropOffLocation(mombasa);
		orders.add(orderTwo);
		
		orderThree = new Order();
		orderThree.setName("Order Three");
		orderThree.setPickUpLocation(thika);
		orderThree.setDropOffLocation(mombasa);
		orders.add(orderThree);
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testSelectBestRoute() {
		
		ArrayList<Trip> expectedResult = new ArrayList<>();
		
		Trip tripOne = new Trip();
		tripOne.setStartPoint(busia);
		tripOne.setEndPoint(mombasa);
		tripOne.addOrder(orderTwo);
		expectedResult.add(tripOne);
		
		Trip tripTwo = new Trip();
		tripTwo.setStartPoint(busia);
		tripTwo.setEndPoint(thika);
		tripTwo.addOrder(orderOne);
		expectedResult.add(tripTwo);
		
		Trip tripThree = new Trip();
		tripThree.setStartPoint(thika);
		tripThree.setEndPoint(mombasa);
		tripThree.addOrder(orderThree);
		expectedResult.add(tripThree);
		
		ArrayList<Trip> bestRoute = estimator.selectBestRoute(orders);
		
		Assert.assertEquals(expectedResult, bestRoute);
		
	}
}
