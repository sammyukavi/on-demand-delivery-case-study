/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.co.sendy.casestudy;

import org.junit.*;

import static org.junit.Assert.fail;

/**
 * @author sukavi
 */
public class MainApplicationTest {
	
	public MainApplicationTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	
	/**
	 * Test of main method, of class MainApplication.
	 */
	@Test
	public void testMain() {
		System.out.println("main");
		String[] args = null;
		MainApplication.main(args);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
	
}
