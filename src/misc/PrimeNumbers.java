package misc;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import common.SlowTest;

/** Strategy: Brute Force. */
@Category(SlowTest.class)
public class PrimeNumbers {
	static int testNo = 1;
	
	public Set<Integer> primeNumberSet( int upperLimit ) {
		int oddPrimeCandidate;
		int primeCount;
		
		Set<Integer> primes = new HashSet( upperLimit ) ;
		
		primes.add( 2 );
		primeCount = 1;
		oddPrimeCandidate = 3;

		while ( primeCount < upperLimit ) {
			boolean isPrime = true;
			// Check the candidate to see if it is divisible by 
			// any of the known primes calculated so far.
			for( int i : primes ) {
				if ( oddPrimeCandidate % i == 0 ) {
					isPrime = false;
					break;
				}
			}

			if ( isPrime ) {
				primes.add( oddPrimeCandidate );
				primeCount += 1;
			}
			oddPrimeCandidate = nextoddNumber(oddPrimeCandidate);
		}
		return primes;
	}

	private int nextoddNumber( int oddNumber ) {
		return oddNumber + 2;
	}

	@Test
	public void PrimeNumber() {
		Set<Integer> primes = primeNumberSet( 10_001 );
		assertEquals( "Incorrect set size", 10_001, primes.size() );
	}
}
