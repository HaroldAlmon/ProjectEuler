package G04;

import org.junit.Test;

import misc.SieveOfEratosthenes;

public class P037_TruncatablePrimes {
	SieveOfEratosthenes sieve = new SieveOfEratosthenes();
	
	public int truncatablePrimesSum(int upperLimit) {
		int sum = 0;
		int primeCount = sieve.generatePrimes(upperLimit);
		System.out.printf("Prime Count = %d%n", primeCount);

		for(int number = 37; number < upperLimit; number += 1) {
			String candidatePrime = Integer.toString(number);
			
			int numLength = candidatePrime.length();
			
			// Truncate right
			int truncateRightCount;
			for(truncateRightCount = 1; truncateRightCount <= numLength; truncateRightCount += 1) {
				if(sieve.isPrime(Integer.parseInt(candidatePrime)))
					candidatePrime = candidatePrime.substring(1);
				else
					break;
			}
			
			if( truncateRightCount == numLength + 1) {
				// Truncate left
				int truncateLeftCount;
				for(truncateLeftCount = 1; truncateLeftCount <= numLength; truncateLeftCount += 1) {
					if(sieve.isPrime(Integer.parseInt(candidatePrime)))
						candidatePrime = candidatePrime.substring(0, numLength - truncateLeftCount);
					else
						break;
				}
				
				sum += 1;
				System.out.printf("Truncatable Prime: %d%n", number);
			}
		}
		return sum;
	}
	
	@Test 
	public void runTest() {
		int upperLimit = 100;

		System.out.printf("Truncatable Prime Count = %d%n", truncatablePrimesSum(upperLimit));
	}
}
