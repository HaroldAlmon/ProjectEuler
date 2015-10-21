package G04;

import misc.SieveOfEratosthenes;

import org.junit.Test;

public class P035_CircularPrimes {
	SieveOfEratosthenes sieve = new SieveOfEratosthenes();
	public int sum( int upperLimit ) {
		int sum = 0;		
		int primeCount = sieve.generatePrimes(upperLimit);
		System.out.printf("Prime Count = %d%n", primeCount);

		for(int number = 2; number < upperLimit; number += 1) {
			String candidatePrime = Integer.toString(number);
			
			int numLength = candidatePrime.length();
			
			int rotations;
			for(rotations = 1; rotations <= numLength; rotations += 1) {
				if(sieve.isPrime(Integer.parseInt(candidatePrime)))
					candidatePrime = candidatePrime.substring(1) + candidatePrime.substring(0,1);
				else
					break;
			}
		
			if( rotations == numLength + 1) {
				sum += 1;
				System.out.printf("Circular Prime: %d%n", number);
			}
		}
		return sum;
	}
	
	@Test 
	public void runTest() {
		int upperLimit = 100;

		System.out.printf("Circular Prime Count = %d%n", sum(upperLimit));
	}
}
