package G01;

import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/** Strategy: Brute Force. */
public class P007_10001PrimeLinkList {
	static int testNo = 1;
	private long primeNumber(int upperLimit) {
		int oddNumber;
		List<Integer> primeNumberList = new LinkedList<>();
		primeNumberList.add(2);
		primeNumberList.add(3);
		oddNumber = 5;

		while (primeNumberList.size() < upperLimit) {
			boolean isPrime = true;
			
			// Boxing takes longer, use an array instead
			Iterator<Integer> primeIter = primeNumberList.iterator();
			while(primeIter.hasNext()) {
				if ( (oddNumber % ( primeIter.next()) ) == 0 ) {
					isPrime = false;
					break;
				}
			}
			if (isPrime == true) {
				primeNumberList.add(oddNumber);
			}
			oddNumber = nextOddNumber(oddNumber);
		}

		return primeNumberList.get(upperLimit - 1);
	}

	private int nextOddNumber(int oddNumber) {
		return oddNumber + 2;
	}

	@Before
	public void Before() {
		System.out.printf("Running unit test...%d%n", testNo);
		testNo += 1;
	}

	@Test(timeout = 5_000)
	public void PrimeNumber10_001() {
		assertEquals( "Incorrect prime number", 104_743, primeNumber(10_001) );
	}
	
	@Test(timeout = 500)
	public void PrimeNumber6() {
		assertEquals( "Incorrect prime number", 13, primeNumber(6) );
	}
	
	@BeforeClass
	public static void BeforeClass() {
		System.out.println("Starting unit test.");
	}
	
	@AfterClass
	public static void AfterClass() {
		System.out.println("Unit test completed.");
	}
}

