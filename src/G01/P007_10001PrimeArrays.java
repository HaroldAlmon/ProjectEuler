package G01;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class P007_10001PrimeArrays {
	static int testNo = 1;

	public static void main(String[] args) {
		P007_10001PrimeArrays main = new P007_10001PrimeArrays();
		System.out.print( "prime=" + main.run(20));
	}
	
	private long run(int limit) {
		int candidate;
		int primeCount;
		
		long primes[] = new long[limit];
		
		primes[0] = 2;
		primeCount = 1;
		candidate = 3;

		while (primeCount < limit) {
			boolean isPrime = true;
			// Check the candidate to see if it is divisible by 
			// any of the known primes calculated so far.
			for(int i = 0; i < primeCount; i++) {
				if ( candidate % primes[i] == 0 ) {
					isPrime = false;
					break;
				}
			}

			if (isPrime == true) {
				primes[primeCount] = candidate;
				primeCount += 1;
			}
			candidate += 2;
		}
		//System.out.printf("Primes = %s\n", Arrays.toString(primes));
		return primes[limit - 1];
	}

	@Before
	public void before() {
		System.out.printf("Running unit test...%d\n", testNo);
		testNo += 1;
	}
	@Test
	public void test1() {
		assertTrue( run(10_001) == 104_743 );
	}
}
