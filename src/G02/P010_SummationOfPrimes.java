package G02;
/** Strategy: Brute Force. */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import common.FastTest;
import common.SlowTest;
public class P010_SummationOfPrimes {
	static int testNo = 1;

	private long primesSum(int upperLimit) {
		int primeCandidate;
		int primeCount;
		long primeSum = 2;
		long primes[] = new long[200_000];
		
		primes[0] = 2;
		primeCount = 1;
		primeCandidate = 3;
		
		while (primeCandidate < upperLimit) {
			boolean isPrime = true;		
			for(int i = 0; i < primeCount; i++) {
				if ( isRemainderOfDivisionZero(primeCandidate, primes[i]) ) {
					isPrime = false;
					break;
				}
			}

			if (isPrime == true) {
				primeSum += primeCandidate;
				try {
					primes[primeCount] = primeCandidate;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.printf("sum = %d\n", primeSum);
				}
				primeCount += 1;
			}
			primeCandidate = nextCandidate(primeCandidate);
		}
		System.out.printf("Result(%d) = %d, no. of primes %d%n", upperLimit, primeSum, primeCount);
		return primeSum;
	}

	private int nextCandidate(int candidate) {
		return candidate + 2;
	}
	private boolean isRemainderOfDivisionZero (int numerator, long denominator) {
		return numerator % denominator == 0;
	}

	@Before
	public void before() {
		System.out.printf("Running unit test...%d%n", testNo);
		testNo += 1;
	}
	
	@Test(timeout = 300_000)
	@Category(SlowTest.class)
	public void TwoMillionPrimes() {
		// takes ~133 seconds on an i7 laptop
		long primeSum = primesSum(2_000_000);
		assertEquals( "Incorrect sum", 142913828922L, primeSum );

	}
	
	@Test(timeout = 500)
	@Category(FastTest.class)
	public void SixPrimes() {
		long primeSum = primesSum(6);
		assertEquals( "Incorrect sum", 10, primeSum );
	}
	
	@Test(timeout = 500)
	@Category(FastTest.class)
	public void TenPrimes() {
		long primeSum = primesSum(10);
		assertEquals("Incorrect sum", 17, primeSum);
	}
}
