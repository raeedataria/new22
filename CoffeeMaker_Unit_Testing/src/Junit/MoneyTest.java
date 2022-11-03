package Junit;
import methods.Money;
import junit.framework.TestCase;


public class MoneyTest extends TestCase {

	private Money m12chf;
	private Money m14chf;
	
	public MoneyTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		m12chf= new Money(13,"CHF");
		m14chf= new Money(14,"CHF");
	}

	
	public void testAdd() {
		Money expected= new Money(27,"CHF");
		Money result= (Money)m12chf.add(m14chf);
		assertTrue(expected.equals(result));
	}

	
	public void testEquals() {
		assertFalse(m12chf.equals(new Money(12, "CHF"))); /*test 1 of equals()*/
		assertTrue(!m12chf.equals(null)); 				/*test 2 of equals()*/
		assertTrue(!m12chf.equals(m14chf));				/*test 3 of equals()*/
	}
}
