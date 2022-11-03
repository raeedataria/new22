package Junit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import methods.Money;
import methods.MoneyBag;

public class MoneyBagTest {

	private Money f12CHF;
	private Money f14CHF;
	private Money f7USD;
	private Money f21USD;
	private MoneyBag fMB1;
	private MoneyBag fMB2;

	// setting up all the variable that we are going to use.
	@Before
	public void setUp() throws Exception {
		f12CHF = new Money(12, "CHF")  ;
		f14CHF = new Money(14, "CHF");
		f7USD = new Money(7, "USD");
		f21USD = new Money(21, "USD");
		fMB1 = new MoneyBag(f12CHF, f7USD);
		fMB2 = new MoneyBag(f14CHF, f21USD);
	}

	// -------AddMoney tests-----------
	
	// Test to check add money from the same type
	// Input data: object money  7 + object money 21  from type USD
	// Expected: object money 28 type USD.
	@Test
	public void testAddSameTypeMoney() {
		Money expected = new Money(28, "USD");
		assertEquals(expected, f7USD.add(f21USD));
	}
    
	// Test to check add money from different types
	// Input data: object money  12 from type CHF + object money 7  from type USD
	// Expected: bag of 12CHF and 7 USD.
	@Test
	public void testAddMixedTypeMoney() {
		// [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
		Money bag[] = { f12CHF, f7USD };
		MoneyBag expected = new MoneyBag(bag);
		Assert.assertEquals(expected, f12CHF.add(f7USD));
	}

	// Test to check subtract money (add negative value)
	// Input data: Bag of 12 CHF and 7 USD
	// Expected: result of 7 USD.
	@Test
	public void testAddNegativeMoney() {
		// {[12 CHF][7 USD]} + [-12 CHF] == [7 USD]
		Money expected = new Money(7, "USD");
		assertEquals(expected, fMB1.add(new Money(-12, "CHF")));
	}

	// Test to check adding zero value to money
	// Input data: object money 12 type CHF
	// Expected: result 12 type CHF
	@Test
	public void testAddZeroMoney() {
		Money expected = new Money(12, "CHF");
		assertEquals(expected, f12CHF.add(new Money(0, "CHF")));
	}
	//gngfbgg
	//5544554
//kjuyhghyghhg
	//575888854
	// --------Contains tests----------
	
	// Test to check if	contains in bag 
	// Input data: Bag of 12 CHF and 7 USD  contains ? 12 CHF
	// Expected: True there is 12CHF in the bag
	@Test
	public void testContainsInBag() {
		assertTrue(fMB1.contains(f12CHF));	
	}
	
	// Test to check if	not contains in bag
	// Input data: Bag of 14 CHF and 21 USD  contains ? 7 USD
	// Expected: False there is not 7USD in the bag
	@Test
	public void testNotContainsInBag() {
		assertFalse(fMB2.contains(f7USD));	
	}
	
	// Test to check if	contains in bag after adding
	// Input data: Bag of 5 EUR and 14 CHF and 21 USD  contains ? 5 USD
	// Expected: True there is 5 USD in the bag
	@Test
	public void testContainsAfterAdd() {		
		MoneyBag bag = new MoneyBag(new Money(5,"EUR"),fMB2);
		assertTrue(bag.contains(new Money(5, "EUR")));
	}
	
	
	// Test to check if	contains in bag after subtracting
	// Input data: Bag of 14 CHF and 21 USD  contains afte sub ? 7 CHF
	// Expected: False there are no 7 CHF in the bag.
	@Test
	public void testContainsAfterSub() {				
		fMB2.add(new Money(-14,"CHF"));
		assertFalse(fMB2.contains(new Money(7, "CHF")));
		
	}
	

}
