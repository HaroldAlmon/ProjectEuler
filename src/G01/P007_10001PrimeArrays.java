package G01;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/** Strategy: Brute Force. */
public class P007_10001PrimeArrays {
	static int testNo = 1;
	
	private long primeNumber(int upperLimit) {
		int oddPrimeCandidate;
		int primeCount;
		
		long primes[] = new long[upperLimit];
		
		primes[0] = 2;
		primeCount = 1;
		oddPrimeCandidate = 3;

		while (primeCount < upperLimit) {
			boolean isPrime = true;
			// Check the candidate to see if it is divisible by 
			// any of the known primes calculated so far.
			for(int i = 0; i < primeCount; i++) {
				if ( oddPrimeCandidate % primes[i] == 0 ) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				primes[primeCount] = oddPrimeCandidate;
				primeCount += 1;
			}
			oddPrimeCandidate = nextoddNumber(oddPrimeCandidate);
		}
		return primes[upperLimit - 1];
	}

	private int nextoddNumber(int oddNumber) {
		return oddNumber + 2;
	}

	@Test
	public void PrimeNumber() {
		assertEquals( "Incorrect prime number", 104_743, primeNumber(10_001) );
	}
}
