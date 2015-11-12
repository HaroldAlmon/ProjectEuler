package G05;

import java.util.BitSet;

import misc.SieveOfEratosthenes;
import org.junit.Test;

public class P046_GoldbachsOtherConjecture {
	public int smallestNumber( int upperPrime, int upperRoot ) {
		int result = 0;
		int candidate;
		BitSet resultSieve = new BitSet (upperPrime * 2 * upperRoot * upperRoot + 1 );
		SieveOfEratosthenes primeSieve = new SieveOfEratosthenes( upperPrime );
		
		for (int prime = 2; prime < upperPrime; prime += 1) {
			if ( primeSieve.isPrime(prime) == true ) {
				for (int number=1; number <= upperRoot; number += 1 ) {
					candidate = prime + 2 * (int)Math.pow( number, 2 );
					resultSieve.set(candidate); 
				}
			}
		}
		for ( int i = 3; i < upperPrime; i += 2 ) {
			if ( primeSieve.isPrime(i) == false ) {
				if ( resultSieve.get(i) == true ) {
					//System.out.printf("%d = true%n", i);
				} else {
					System.out.printf( "answer = %d%n", i );
					return i;
				}
			}
		}
		return result;
	}
	
	@Test
	public void GoldbachsOtherConjecture() {
		smallestNumber( 6000, 50 );
	}
}
