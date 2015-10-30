package G04;

import misc.SieveOfEratosthenes;

import org.junit.Test;

public class P035_CircularPrimes {
	SieveOfEratosthenes sieve = new SieveOfEratosthenes();
	public int countPrimes( int upperLimit ) {
		int circularPrimeCount = 0;		
		sieve.generatePrimes(upperLimit);

		for(int number = 2; number < upperLimit; number += 1) {
			String candidatePrime = Integer.toString(number);
			
			if ( isCircularPrime(candidatePrime) ) {
				circularPrimeCount += 1;
			}
		}
		return circularPrimeCount;
	}
	
	boolean isCircularPrime(String candidatePrime) {
		int rotations;
		int numLength = candidatePrime.length();
		for (rotations = 1; rotations <= numLength; rotations += 1) {
			if (sieve.isPrime(Integer.parseInt(candidatePrime)))
				candidatePrime = rotateString(candidatePrime);
			else
				break;
		}
		return isRotationComplete(rotations, numLength);
	}

	private boolean isRotationComplete(int rotations, int numLength) {
		return rotations == numLength + 1;
	}

	private String rotateString(String candidatePrime) {
		return candidatePrime.substring(1) + candidatePrime.substring(0,1);
	}
	
	@Test 
	public void runTest() {
		int upperLimit = 1_000_000;

		System.out.printf("Circular Prime Count = %d%n", countPrimes(upperLimit));
	}
}
