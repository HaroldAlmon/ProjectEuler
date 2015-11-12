package G05;

import java.util.BitSet;

import misc.SieveOfEratosthenes;
import org.junit.Test;

public class P046_GoldbachsOtherConjecture {
	public int smallestNumber( int upperPrime, int upperRoot ) {
		int result = 0;
		BitSet resultSieve = new BitSet ( upperPrime );
		SieveOfEratosthenes primeSieve = new SieveOfEratosthenes( upperPrime );
		
		for (int primeCandidate = 2; primeCandidate < upperPrime; primeCandidate += 1) {
			if ( primeSieve.isPrime(primeCandidate) == true ) {
				for (int root=1; root <= upperRoot; root += 1 ) {
					int candidate;
					candidate = primeCandidate + 2 * (int)Math.pow( root, 2 );
					if( candidate < upperPrime ) 
						resultSieve.set(candidate); 
				}
			}
		}

		for ( int compositeNumber = 9; compositeNumber < upperPrime; compositeNumber += 2 ) {
			if ( primeSieve.isPrime( compositeNumber ) == false ) {
				if ( resultSieve.get( compositeNumber ) == false ) {
					System.out.printf( "answer = %d%n", compositeNumber );
					return compositeNumber;
				}
			}
		}
		return result;
	}
	
	@Test (timeout = 1_000)
	public void GoldbachsOtherConjecture() {
		smallestNumber( 6000, 50 );
	}
}
