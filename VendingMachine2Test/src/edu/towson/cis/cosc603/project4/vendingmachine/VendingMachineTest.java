package edu.towson.cis.cosc603.project4.vendingmachine;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>VendingMachineTest</code> contains tests for the class <code>{@link VendingMachine}</code>.
 *
 * @generatedBy CodePro at 4/10/16 12:25 PM
 * @author MarleneRZ
 * @version $Revision: 1.0 $
 */
public class VendingMachineTest {
	/**
	 * Run the VendingMachine() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 * 
	 */
	VendingMachine fixture;
	VendingMachineItem item, snacks, pepsi, cookies, popcorn, chips, candies;
	
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
		
		fixture = new VendingMachine();
		 //item = new VendingMachineItem ();
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
		fixture = null;
		item = null;
		snacks = null;
		pepsi = null;
		cookies = null;
		popcorn = null;
		chips = null;
		candies = null;
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	
	@Test
	public void testVendingMachine_1()
		throws Exception {

		VendingMachine result = new VendingMachine();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.getBalance(), 1.0);
		assertEquals(0.0, result.returnChange(), 1.0);
	}

	/**
	 * Run the VendingMachine() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test
	public void testVendingMachine_2()
		throws Exception {

		VendingMachine result = new VendingMachine();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0.0, result.getBalance(), 1.0);
		assertEquals(0.0, result.returnChange(), 1.0);
	}

	/**
	 * Run the void addItem(VendingMachineItem,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test
	public void testAddItem_1()
		throws Exception {
		//VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;
		snacks = new VendingMachineItem("snacks", 1.0);
		String code = "A";

		fixture.addItem(snacks, code);

		// add additional test code here
	}



	@Test
	public void testAddItem_4()
		throws Exception {
		//VendingMachine vendingMachine = new VendingMachine();
		candies = new VendingMachineItem("candies", 1.0);
		String code = "B";
		fixture.addItem(candies, code);
	}

	@Test
	public void testAddItem_5()
		throws Exception {
		//VendingMachine vendingMachine = new VendingMachine();
		chips = new VendingMachineItem("chips", 1.0);
		String code = "C";
		fixture.addItem(chips, code);
	}

	@Test
	public void testAddItem_6()
		throws Exception {
		//VendingMachine vendingMachine = new VendingMachine();
		popcorn = new VendingMachineItem("popcorn", 1.0);
		String code = "D";
		fixture.addItem(popcorn, code);
	}


	/**
	 * Run the void addItem(VendingMachineItem,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test(expected = edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineException.class)
	public void testAddItem_2()
		throws Exception {
	//	VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;
		pepsi = new VendingMachineItem("pepsi", 1.0);
		VendingMachineItem pepsi2 = new VendingMachineItem("pepsi", 1.0);
		String code = "A";
       try{
		fixture.addItem(pepsi, code);
		fixture.addItem(pepsi2, code);
       }catch (Exception e)
       {
    	   final String expected = "Slot A already occupied"; 
    	   assertEquals( expected, e.getMessage()); 

    	   //System.out.println(e.getMessage());
       }
		// add additional test code here
	}

	
	/**
	 * Run the void addItem(VendingMachineItem,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test(expected = edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineException.class)
	public void testAddItem_3()
		throws Exception {
		//VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;
		cookies = new VendingMachineItem("cookies", 1.0);
		String code = "";

		fixture.addItem(cookies, code);

		// add additional test code here
	}
	/**
	 * Run the double getBalance() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test
	public void testGetBalance_1()
		throws Exception {
		//VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;

		double result = fixture.getBalance();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the VendingMachineItem getItem(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test
	public void testGetItem_1()
		throws Exception {
		//VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;
		String code = "A";

		VendingMachineItem result = fixture.getItem(code);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the VendingMachineItem getItem(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test(expected = edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineException.class)
	public void testGetItem_2()
		throws Exception {
		//VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;
		String code = "";

		VendingMachineItem result = fixture.getItem(code);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void insertMoney(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test
	public void testInsertMoney_1()
		throws Exception {
	//	VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;
		double amount = 1.0;

		fixture.insertMoney(amount);

		// add additional test code here
	}

	/**
	 * Run the void insertMoney(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test(expected = edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineException.class)
	public void testInsertMoney_2()
		throws Exception {
		VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;
		double amount = -4.9E-324;

		fixture.insertMoney(amount);

		// add additional test code here
	}

	/**
	 * Run the boolean makePurchase(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test
	public void testMakePurchase_1()
		throws Exception {
		//VendingMachine fixture = new VendingMachine();
		fixture.balance = Double.MAX_VALUE;
		String code = "A";

		boolean result = fixture.makePurchase(code);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean makePurchase(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test
	public void testMakePurchase_2()
		throws Exception {
	//	VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;
		String code = "A";

		boolean result = fixture.makePurchase(code);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean makePurchase(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test
	public void testMakePurchase_3()
		throws Exception {
		//VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;
		String code = "A";

		boolean result = fixture.makePurchase(code);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean makePurchase(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test(expected = edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineException.class)
	public void testMakePurchase_4()
		throws Exception {
	//	VendingMachine fixture = new VendingMachine();
		fixture.balance = 2.0;
		String code = "B";

		VendingMachineItem item = new VendingMachineItem("", 1.0);
		//String code = "A";

		fixture.addItem(item, code);
		boolean result = fixture.makePurchase(code);

		// add additional test code here
		assertTrue(result);
	}

	@Test
	public void testMakePurchase_5()
		throws Exception {
	//	VendingMachine vendingMachine = new VendingMachine();
		fixture.balance = 1.0;
		String code = "B";
		VendingMachineItem item = new VendingMachineItem("", 1.0);
		//String code = "A";

		fixture.addItem(item, code);
		boolean result = fixture.makePurchase(code);
		assertTrue(result);
	}

	/**
	 * Run the VendingMachineItem removeItem(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test(expected = edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineException.class)
	public void testRemoveItem_1()
		throws Exception {
		//VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;
		String code = "";

		VendingMachineItem result = fixture.removeItem(code);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the VendingMachineItem removeItem(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test(expected = edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineException.class)
	public void testRemoveItem_2()
		throws Exception {
	    VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;
		String code = "A";

		VendingMachineItem result = fixture.removeItem(code);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the VendingMachineItem removeItem(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test(expected = edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineException.class)
	public void testRemoveItem_3()
		throws Exception {
		VendingMachine fixture = new VendingMachine();
		fixture.balance = 1.0;
		String code = "A";
		VendingMachineItem item = new VendingMachineItem("snack", 1.0);
		fixture.addItem(item, code);
		VendingMachineItem result = fixture.removeItem(code);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the double returnChange() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	@Test
	public void testReturnChange_1()
		throws Exception {
		
		fixture.balance = 1.0;

		double result = fixture.returnChange();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 4/10/16 12:25 PM
	 */
	
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(VendingMachineTest.class);
	}
}