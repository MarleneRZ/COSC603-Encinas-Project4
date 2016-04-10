/**
 * 
 */
package edu.towson.cis.cosc603.project4.vendingmachine;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
//import org.junit.Rule;
import org.junit.Test;
//import org.junit.rules.ExpectedException;



/**

 * @author MarleneRZ
 *
 */
public class VendingMachineTest extends TestCase  {

	VendingMachine vMachine;
	VendingMachineItem item;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	
		vMachine= new VendingMachine();
		item = new VendingMachineItem("GummyBear", 2.25);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	
		vMachine = null;
		item = null;
	}

	

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem, java.lang.String)}.
	 */
	@Test
	public void testAddItem_EmptySlot() {
		
		/*Test slot code A is empty, then add item to slot A
		 * Expected result: item is at slot code A
		 */
		assertEquals(null, vMachine.getItem(VendingMachine.A_CODE));
		vMachine.addItem(item, VendingMachine.A_CODE);
		assertSame(item, vMachine.getItem(VendingMachine.A_CODE));
		
	}
	
	/**
	 * Test add item to occupied slot A
	 */

	@Test(expected=VendingMachineException.class)
	public void testAddItem_OccupiedSlot() {
	
		/* Test: Slot code A is occupied, add item to slot A
		 * Expected result: VendingMachineException thrown
		 */
	try {
		
		assertEquals(null, vMachine.getItem(VendingMachine.A_CODE));
	    vMachine.addItem(new VendingMachineItem("Snicker", 1.00), VendingMachine.A_CODE);
		vMachine.addItem (new VendingMachineItem("Snapple", 1.00),VendingMachine.A_CODE );
		} catch (VendingMachineException e) {
			//System.err.println("Caught Exception: " + e.getMessage());
	//		return;
			final String msg = "Slot A already occupied";
			 assertEquals(msg, e.getMessage());
			 // return;
		}
       //fail("Expected VendingMachineException - Slot A already occupied");
		

	}

	/**
	 * Test add item into an invalid slot E
	 */
//	@Rule
  //  public final ExpectedException exception = ExpectedException.none();

	@Test(expected=VendingMachineException.class)
	
	public void testAddItem_InvalidSlot() {
	
		/* Test: Slot code E does not exist, add item to slot E
		 * Expected result: VendingMachineException thrown
		 */
		try {
		vMachine.addItem(item, "E");
		fail("Expected VendingMachineException - Slot E does not exist");
		
		//exception.expect(VendingMachineException.class);
		//exception.expect(vMachine.addItem(item, "E"));
		//exception.expectMessage(vMachine.);
		//vMachine.addItem(item, "E");
		
			
			//assertTrue((Arrays.asList(vMachine.itemArray[3]).contains(vendingMachineItem3)));
		} catch (VendingMachineException vme) {
		  final String msg = "Invalid code for vending machine item";
		  assertEquals(msg, vme.getMessage());
			//return;
		}
	}
	
		

	//}

	/**
	 * Remove item from empty slot
	 */
	@Test(expected=VendingMachineException.class)
	public void testRemoveItem_EmptySlot() {
		
		/*
		 * Test: Remove item from empty slot B
		 * Expected result:  VendingMachineException thrown
		 */
		assertNull(vMachine.getItem(VendingMachine.B_CODE));
		try {
			vMachine.removeItem(VendingMachine.B_CODE);
		} catch (VendingMachineException vme) {
			return;
		}
		//fail("Expected VendingMachineException - Slot B is empty");

		
	}
	
	/**
	 * Remove item from invalid slot E
	 */
	@Test(expected=VendingMachineException.class)
	public void testRemoveItem_IvalidSlot() {
		
		/*
		 * Test: Remove item from empty slot E
		 * Expected result:  VendingMachineException thrown
		 */
		
		try {
			vMachine.removeItem("E");
			fail("Expected VendingMachineException - Slot E does not exist");	
			
		} catch (VendingMachineException vme) {
			return;
		}
		

		
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 */
	@Test(expected=VendingMachineException.class)
	public void testRemoveItem_NoEmptyValidSlot() {
		
		//make sure item exists in slot firs
		vMachine.addItem(item, VendingMachine.A_CODE);
		assertNotNull(vMachine.getItem(VendingMachine.A_CODE));
		
	// Expected result:  item removed and slot A is empty
			
		vMachine.removeItem(VendingMachine.A_CODE);
		assertNull(vMachine.getItem(VendingMachine.A_CODE));

		
	}

	/**
	 * Test method for inserting money less than zero
	 *
	 */
	@Test(expected=VendingMachineException.class)
	public void testInsertMoney_LessZero() {
		
		/*
		 * Test: Insert money < 0
		 * Expected result:  VendingMachineException thrown
		 */
		
		try {
			vMachine.insertMoney(-.75);
			fail("Expected VendingMachineException - Amount less than 0");
		} catch (VendingMachineException vme) {
			final String msg = "Invalid amount.  Amount must be >= 0"; 
			assertEquals( msg, vme.getMessage()); 

		}
		


	}

	/**
	 * Test method for inserting money equal to zero
	 *
	 */
	@Test
	public void testInsertMoney_Zero() {
		
		/*
		 * Test: Insert money equal zero
		 * Expected result:  balance is 0.00
		 */
		
		//make sure initial balance is 0.00
		assertEquals(0.00, vMachine.getBalance());
		vMachine.insertMoney(0.00);
		assertEquals(0.00, vMachine.getBalance());


	}
	
	
	/**
	 * Test method for inserting money greater than zero
	 *Inserting 3.50
	 */
	@Test
	public void testInsertMoney_GreaterZero() {
		
		/*
		 * Test: Insert money > 0 . Initial balance is 0.00
		 * Expected result:  balance is 3.50
		 */
		
		//make sure initial balance is 0.00
		assertEquals(0.00, vMachine.getBalance());
		vMachine.insertMoney(3.50);
		assertEquals(3.50, vMachine.getBalance());


	}
	
	
	/**
	 * Test method for inserting money greater with balance Greater than zero
	 *Inserting 3.50. Initial balance 5.0
	 */
	@Test
	public void testInsertMoney_BalanceGTZero() {
		
		/*
		 * Test: Insert money 3.50 . Initial balance is 5.00
		 * Expected result:  balance is 8.50
		 */
		
		//make sure initial balance is 0.00
		
		assertEquals(0.00, vMachine.getBalance());
		vMachine.insertMoney(5.00);
		assertEquals(5.00, vMachine.getBalance());
		vMachine.insertMoney(3.50);
		assertEquals(8.50, vMachine.getBalance());


	}
	/**
	 * Test Balance starts at zero
	 */
	@Test
	public void testGetBalance_Zero() {
		
		/*
		 * Test: Vending machine balance starts with 0.00
		 * Expected result: balance is 0.00
		 */
		assertEquals(0.00, vMachine.getBalance());

	}

	/**
	 * Test Balance sGreater than zero
	 */
	@Test
	public void testGetBalance_GTZero() {
		
		/*
		 * Test: Vending machine balance starts with 3.00
		 * Expected result: balance =3.00
		 */
		vMachine.balance = 3.00;
		assertEquals(3.00, vMachine.balance);
		assertEquals(vMachine.balance, vMachine.getBalance());


	}
	
	
	/**
	 * Test Balance less than zero
	 */
	@Test(expected=VendingMachineException.class)
	public void testGetBalance_LTZero() {
		
		/*
		 * Test: Vending machine balance -2.00
		* Expected Result: VendingMachineException thrown (balance should not be less than 0)
    	 */
		
		
		try {
			vMachine.balance = -2.00;
			double balance2 = vMachine.getBalance();
			System.out.println(balance2);
	//	} catch (VendingMachineException e) {
			//System.err.println("Caught Exception: " + e.getMessage());
		//	return;
			
		} catch (VendingMachineException vme) {
			  final String msg = "Invalid amount.  Amount must be >= 0";
			  assertEquals(msg, vme.getMessage());
			//System.err.println("Caught Exception: " + vme.getMessage());
		}
		//fail("Expected VendingMachineException - Balance is less than 0");

	}
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 */
	@Test
	public void testMakePurchase_BalanceTHZero() {
		
		
		/*
		 * Test: Make purchase from occupied slot A, 
		 * item costs is 2.25
		 * initial balance is 3.00  > 2.25
		 * Expected result: return true
		 *     final balance is 0.75 > 0
		 *     item at slot A is null
		 */
		vMachine.addItem(item, VendingMachine.A_CODE);
		vMachine.balance = 3.00;
		assertTrue(vMachine.makePurchase(VendingMachine.A_CODE));
		assertNull(vMachine.getItem(VendingMachine.A_CODE));
		assertEquals(0.75, vMachine.getBalance());

		
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 */
	@Test
	public void testMakePurchase_BalanceEQZero() {
		
		
		/*
		 * Test: Make purchase from occupied slot A, 
		 * item costs is 2.25
		 * initial balance is 2.25 > 0
		 * Expected result: return true
		 *     final balance is 0
		 *     item at slot A is null
		 */
		vMachine.addItem(item, VendingMachine.A_CODE);
		vMachine.balance = 2.25;
		assertTrue(vMachine.makePurchase(VendingMachine.A_CODE));
		assertNull(vMachine.getItem(VendingMachine.A_CODE));
		assertEquals(0.00, vMachine.getBalance());

		
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 */
	@Test
	public void testMakePurchase_InitBalanceLTPrice() {
		
		
		/*
		 * Test: Make purchase from occupied slot A, 
		 * item costs is 2.25
		 * initial balance is 1.00 <2.25 purchase price
		 * Expected result: return false
		 *     final balance is 1.00
		 *     item at slot A is not null
		 */
		vMachine.addItem(item, VendingMachine.A_CODE);
		vMachine.balance = 1.00;
		assertFalse(vMachine.makePurchase(VendingMachine.A_CODE));
		assertNotNull(vMachine.getItem(VendingMachine.A_CODE));
		assertEquals(1.00, vMachine.getBalance());

		
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 */
	@Test
	public void testMakePurchase_EmptySlot() {
		
		
		/*
		 * Test: Make purchase from unoccupied slot C, 
		 * item costs is 2.25
		 * initial balance is 2.25 > 0
		 * Expected result: return false
		 *     
		 *     item at slot B is null
		 */
		//vMachine.addItem(item, VendingMachine.A_CODE);
		vMachine.balance = 2.25;
		assertFalse(vMachine.makePurchase(VendingMachine.C_CODE));
		assertNull(vMachine.getItem(VendingMachine.C_CODE));
		assertEquals(2.25, vMachine.getBalance());

		
	}
	
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 */
	@Test
	public void testMakePurchase_EmptySlotD() {
		
		
		/*
		 * Test: Make purchase from unoccupied slot D, 
		 * item costs is 2.25
		 * initial balance is 2.25 > 0
		 * Expected result: return false
		 *     
		 *     item at slot B is null
		 */
		//vMachine.addItem(item, VendingMachine.A_CODE);
		vMachine.balance = 2.25;
		assertFalse(vMachine.makePurchase(VendingMachine.D_CODE));
		assertNull(vMachine.getItem(VendingMachine.D_CODE));
		assertEquals(2.25, vMachine.getBalance());

		
	}
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#returnChange()}.
	 */
	@Test
	public void testReturnChange_InitBalanceGTZero() {
		
		/*
		 * Test: Return change when purchasing 2.25 item with initial balance of 3.00
		 * Expected Result: return change 0.75 >0
		 * final Balance = 0.00
		 */
		vMachine.balance = 3.00;
		vMachine.addItem(item, VendingMachine.A_CODE);
		vMachine.makePurchase(VendingMachine.A_CODE);
		assertEquals(0.75, vMachine.returnChange());
		assertEquals(0.00, vMachine.getBalance());
		
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#returnChange()}.
	 */
	@Test
	public void testReturnChange_InitBalanceLTPrice() {
		
		/*
		 * Test: Return change when purchasing 2.25 item with initial balance of 1.00
		 * Expected Result: return change 1.00 >0
		 * final Balance = 0.00
		 */
		vMachine.balance = 1.00;
		vMachine.addItem(item, VendingMachine.A_CODE);
		vMachine.makePurchase(VendingMachine.A_CODE);
		assertEquals(1.00, vMachine.returnChange());
		assertEquals(0.00, vMachine.getBalance());
		
	}


	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#returnChange()}.
	 */
	@Test(expected=VendingMachineException.class)
	public void testMakePurchase_InitBalanceLTZero() {
		
		/*
		 * Test: Make Purchase when purchasing 2.25 item with initial balance of -1.00
		 * Expected Result: Exception thrown
		 * final Balance = 0.00
		try { */
		try{
		vMachine.balance = -1.00;
		
			vMachine.makePurchase(VendingMachine.A_CODE);
		} catch (VendingMachineException vme) {
			return;
		}
		//fail("Expected VendingMachineException - Cannot return negative change");
		
	}

	
}
