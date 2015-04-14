package G02;

import static org.junit.Assert.assertEquals;
import static G01.Formatter.errorText;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
public class P010_SummationOfPrimes {
	static int testNo = 1;
	private long run(int limit) {
		int candidate;
		int primeCount;
		long primeSum = 2;
		long primes[] = new long[200_000];
		
		primes[0] = 2;
		primeCount = 1;
		candidate = 3;
		
		//System.out.printf("limit = %d\n", limit);

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
		System.out.printf("Result(%d) = %d\n", limit, primeSum);
		return primeSum;
	}

	@Before
	public void before() {
		System.out.printf("Running unit test...%d\n", testNo);
		testNo += 1;
	}
	
	@Test(timeout = 300_000)
	@Ignore
	public void TwoMillionPrimes() {
		// takes ~133 seconds on an i7 laptop
		assertEquals( errorText("Incorrect sum"), 142913828922L, run(2_000_000) );

	}
	
	@Test(timeout = 500)
	public void SixPrimes() {
		assertEquals( errorText("Incorrect sum"), run(6), 10 );
	}
	
	@Test(timeout = 500)
	public void TenPrimes() {
		assertEquals( errorText("Incorrect sum"), run(10), 17 );
	}
}
