package G01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class P007_10001PrimeArrays {
	static int testNo = 1;
	
	private long findPrimeNumber(int limit) {
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

	@Test
	public void test1() {
		assertEquals( "", 104_743, findPrimeNumber(10_001) );
	}
}
