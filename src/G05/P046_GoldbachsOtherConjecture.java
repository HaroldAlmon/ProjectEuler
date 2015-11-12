package G05;

import java.util.BitSet;

import misc.SieveOfEratosthenesBitSet;

import org.junit.Test;

public class P046_GoldbachsOtherConjecture {
/*
generate 100 prime numbers
create a sieve that adds the primes to 2(1..100)
check the sieve for the first number that is not generated
 */

	public int smallestNumber( int numberOfPrimes, int upperRoot ) {
		int result = 0;
		int candidate;
		BitSet resultSieve = new BitSet(numberOfPrimes * upperRoot * upperRoot);
		SieveOfEratosthenesBitSet primeSieve = new SieveOfEratosthenesBitSet( numberOfPrimes );
		
		for (int prime = 2; prime < numberOfPrimes; prime += 1) {
			if ( primeSieve.isPrime(prime) == true ) {
				for (int number=1; number <= upperRoot; number += 1) {
					candidate = prime + 2 * (int)Math.pow( number, 2 );
					resultSieve.set(candidate); 
				}
			}
		}
		for (int i = 3; i < resultSieve.size(); i += 2) {
			if (resultSieve.get(i) == true) {
				System.out.printf("%d = true%n", i);
			} else
				if( primeSieve.isPrime(i) == false )
					System.out.printf("%d = false%n", i);
		}
		return result;
	}
	
	@Test
	public void GoldbachsOtherConjecture() {
		smallestNumber( 11, 5 );
	}
}
