/**
 * 
 */
package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author MarleneRZ
 *
 */
public class VendingMachineItemTest {

	VendingMachineItem gummybear;
	VendingMachineItem cracker;
	String name;
	double price;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		
		try{
			
			gummybear = new VendingMachineItem("GummyBear", 1.00);
			cracker = new VendingMachineItem("AnimalCracker", -1.00);
		

		}
		catch (VendingMachineException vme)
		{
			return;
		}
		fail("Expected VendingMachineException - Price cannot be less than zero");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	
		gummybear = null;
		cracker = null;
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 */
	
	@Test
	public void testVendingMachineItem() {

		
		
		
		// Existence test
	    assertNotNull("GummyBear item exists", 
	    		gummybear);
	    assertNull("AnimalCracker item does not exist", cracker);
	    
	    // Type test
	    assertTrue("GummyBear is a vending machine item", 
	    		gummybear instanceof VendingMachineItem);
	    assertFalse("AnimalCracker is NOT a vending machine item", 
	    		cracker instanceof VendingMachineItem);
	  

	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#getName()}.
	 */
	@Test
	public void testGetName() {
		
		assertEquals("GummyBear",gummybear.getName());
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#getPrice()}.
	 */
	@Test
	public void testGetPrice_PositiveNumber() {

		assertEquals(1.00,gummybear.getPrice(),0.0);
	}
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#getPrice()}.
	 */
	/*
	@Test
	public void testGetPrice_NegativeNumber() {
		
		try
		{
			assertEquals(-1.00,cracker.getPrice(),0.01);
		}
		catch (VendingMachineException vme)
		{
		  return;
		}
		
	}
	*/	
	
		



}
