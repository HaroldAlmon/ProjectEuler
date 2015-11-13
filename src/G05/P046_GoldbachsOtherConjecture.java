package G05;

import static org.junit.Assert.assertEquals;
import java.util.BitSet;
import misc.SieveOfEratosthenes;
import org.junit.Test;

public class P046_GoldbachsOtherConjecture {
	public int compositeNumber( int upperPrime, int upperRoot ) {
		int result = 0;
		BitSet resultSieve = new BitSet ( upperPrime );
		SieveOfEratosthenes primeSieve = new SieveOfEratosthenes( upperPrime );
		
		enumeratePrimes( upperPrime, upperRoot, primeSieve, resultSieve );

		for ( int compositeNumber = 9; numberInRange(compositeNumber, upperPrime); compositeNumber += 2 ) {
			if ( primeSieve.isPrime( compositeNumber ) == false ) {
				if ( resultSieve.get( compositeNumber ) == false ) {
					result = compositeNumber;
					break;
				}
			}
		}
		return result;
	}

	private void enumeratePrimes( int upperPrime, int upperRoot,
			SieveOfEratosthenes primeSieve, BitSet resultSieve) {
		for ( int primeCandidate = 2; numberInRange( primeCandidate, upperPrime ); primeCandidate +=  1 ) {
			if ( primeSieve.isPrime(primeCandidate) == true ) {
				enumerateRoots( upperPrime, upperRoot, primeSieve, resultSieve, primeCandidate );
			}
		}
	}

	private void enumerateRoots( int upperPrime, int upperRoot, SieveOfEratosthenes primeSieve, BitSet resultSieve, int primeCandidate ) {
			for (int root=1; root <= upperRoot; root += 1 ) {
				int candidate;
				candidate = primeCandidate + 2 * (int)Math.pow( root, 2 );
				if( numberInRange(candidate, upperPrime) == true ) 
					resultSieve.set(candidate); 
				else
					break;
			}
	}

	private boolean numberInRange( int candidate, int upperPrime ) {
		return candidate < upperPrime;
	}
	
	@Test (timeout = 1_000)
	public void GoldbachsOtherConjecture() {
		int compositeNumber = compositeNumber( 6000, 50 );
		System.out.printf( "Answer = %d%n", compositeNumber );
		assertEquals( compositeNumber, 5777 );
	}
}
