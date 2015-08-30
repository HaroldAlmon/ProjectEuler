package G01;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import common.SlowTest;

/** Strategy: Brute Force. */
@Category(SlowTest.class)
public class P007_10001PrimeArrays {
	static int testNo = 1;
	
	// TODO: To solve problem 243, I need to return a set of all the prime
	// numbers generated. I need to:
	// 1. Change this function to return an array of primes.
	// 2. Create a wrapper function, with the original function name (primeNumber), to solve problem 7.
	// 3. Create a wrapper function to return a set of primes.
	private long primeNumber( int upperLimit ) {
		int oddPrimeCandidate;
		int primeCount;
		
		long primes[] = new long[ upperLimit ];
		
		primes[0] = 2;
		primeCount = 1;
		oddPrimeCandidate = 3;

		while ( primeCount < upperLimit ) {
			boolean isPrime = true;
			// Check the candidate to see if it is divisible by 
			// any of the known primes calculated so far.
			for( int i = 0; i < primeCount; i++ ) {
				if ( oddPrimeCandidate % primes[ i ] == 0 ) {
					isPrime = false;
					break;
				}
			}

			if ( isPrime ) {
				primes[ primeCount ] = oddPrimeCandidate;
				primeCount += 1;
			}
			oddPrimeCandidate = nextoddNumber(oddPrimeCandidate);
		}
		return primes[upperLimit - 1];
	}

	private int nextoddNumber( int oddNumber ) {
		return oddNumber + 2;
	}

	@Test
	public void PrimeNumber() {
		long prime = primeNumber( 10_001 );
		assertEquals( "Incorrect prime number", 104_743, prime );
		System.out.printf("Prime = %s%n", prime);
	}
}
