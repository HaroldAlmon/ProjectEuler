package com.translationdata.p030;

import org.junit.Test;

import misc.SieveOfEratosthenes;
/** Strategy: Brute Force. */
public class P037_TruncatablePrimes {
	SieveOfEratosthenes sieve = new SieveOfEratosthenes();
	
	public int truncatablePrimesSum( int upperLimit ) {
		int truncatablePrimeCount = 0;
		int primeSum = 0;
		boolean debug = false;
		int primeCount = sieve.generatePrimes( upperLimit );

		for( int number = 11; number < upperLimit; number += 1 ) {
			String candidatePrime = Integer.toString( number );

			if( isRightTtruncatable(candidatePrime) && isLeftTruncatable(candidatePrime) ) { 
				truncatablePrimeCount += 1;
				primeSum += number;
				if (debug == true) {
					System.out.printf( "Truncatable Prime: %d%n", number );
				}
			}
		}
		return primeSum;
	}

	private boolean isLeftTruncatable( String candidatePrime ) {
		// Truncate left
		int numLength = candidatePrime.length();
		int truncateLeftCount;
		for( truncateLeftCount = 1; truncateLeftCount <= numLength; truncateLeftCount += 1 ) {
			if( sieve.isPrime( Integer.parseInt( candidatePrime ) ) )
				candidatePrime = candidatePrime.substring( 0, numLength - truncateLeftCount );
			else
				break;
		}
		return truncateLeftCount == numLength + 1;
	}

	private boolean isRightTtruncatable( String candidatePrime ) {
		int numLength = candidatePrime.length();
		
		int truncateRightCount;
		for(truncateRightCount = 1; truncateRightCount <= numLength; truncateRightCount += 1 ) {
			if(sieve.isPrime( Integer.parseInt( candidatePrime ) ) )
				candidatePrime = candidatePrime.substring( 1 );
			else
				break;
		}
		return truncateRightCount == numLength + 1;
	}
	
	@Test 
	public void runTest() {
		int upperLimit = 750_000;
		System.out.printf( "Truncatable Prime Sum = %d%n", truncatablePrimesSum( upperLimit ) );
	}
}
