package G02;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class P010_SummationOfPrimes {
	static int testNo = 1;

	public static void main(String[] args) {
		P010_SummationOfPrimes main = new P010_SummationOfPrimes();
		System.out.print( "prime=" + main.run(20));
	}
	
	private long run(int limit) {
		int candidate;
		int primeCount;
		long primeSum = 2;
		long primes[] = new long[200_000];
		
		primes[0] = 2;
		primeCount = 1;
		candidate = 3;
		
		System.out.printf("limit = %d\n", limit);

		while (candidate < limit) {

			boolean isPrime = true;		
			for(int i = 0; i < primeCount; i++) {
				if ( candidate % primes[i] == 0 ) {
					isPrime = false;
					break;
				}
			}
			if (isPrime == true) {
				primeSum += candidate;
				try {
					primes[primeCount] = candidate;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.printf("sum = %d\n", primeSum);
				}
				primeCount += 1;
			}
			candidate += 2;
		}
		return primeSum;
	}

	@Before
	public void before() {
		System.out.printf("Running unit test...%d\n", testNo);
		testNo += 1;
	}
	//@Test
	public void test1() {
		assertTrue( run(2_000_000) == 104_743 );
	}
	
	@Test
	public void test10() {
		// takes 133 seconds on an i7 laptop
		System.out.printf("Sum = %d\n", run(2_000_000));
	}
	
	//@Test
	public void test2() {
		assertTrue( run(6) == 13 );
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Starting unit test.");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Unit test completed.");
	}
}
