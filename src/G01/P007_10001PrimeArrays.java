package G01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class P007_10001PrimeArrays {
	static int testNo = 1;
	
	private long findPrimeNumber(int limit) {
		int oddNumber;
		int primeCount;
		
		long primes[] = new long[limit];
		
		primes[0] = 2;
		primeCount = 1;
		oddNumber = 3;

		while (primeCount < limit) {
			boolean isPrime = true;
			// Check the candidate to see if it is divisible by 
			// any of the known primes calculated so far.
			for(int i = 0; i < primeCount; i++) {
				if ( oddNumber % primes[i] == 0 ) {
					isPrime = false;
					break;
				}
			}

			if (isPrime == true) {
				primes[primeCount] = oddNumber;
				primeCount += 1;
			}
			oddNumber = nextoddNumber(oddNumber);
		}
		return primes[limit - 1];
	}

	private int nextoddNumber(int oddNumber) {
		return oddNumber + 2;
	}

	@Test
	public void FindprimeNumber10_001() {
		assertEquals( "Incorrect prime number", 104_743, findPrimeNumber(10_001) );
	}
}
