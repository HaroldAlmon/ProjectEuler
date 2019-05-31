package com.translationdata.p020;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
/** Strategy: Brute force. */
public class P027_QuadraticPrimes {
	static Set<Integer> primes;
	private final boolean isDebug = false;

	public int quadraticPrimes(int limit) {
		primes = getPrimes(168);
		
		int maxCoefficientA = 0;
		int maxCoefficientB = 0;
		int maxNumOfPrimes = 0;

		for (int a = -limit - 1; a < limit; a++) {
			for (int b = -limit + 1; b < limit; b++) {
				int numOfPrimes;
				numOfPrimes = 0;
				numOfPrimes = calculatePrimesForAandB(limit, a, b);
				if (numOfPrimes > maxNumOfPrimes)  {
					maxNumOfPrimes = numOfPrimes;
					maxCoefficientA = a;
					maxCoefficientB = b;
				}
			}
		}

		if(isDebug) {
			System.out.printf("max no. of primes = %d, a=%d, b=%d%n", maxNumOfPrimes, maxCoefficientA, maxCoefficientB);
		}
		return maxCoefficientA * maxCoefficientB;
	}
	private int calculatePrimesForAandB(int limit, int a, int b) {
		int sum;
		int numOfPrimes = 0;
		for (int n = 0; n < limit; n++) {
			sum = n*n + a*n + b;
			if ( isPrime(sum) )
				numOfPrimes += 1;
			else
				break;
		}
		return numOfPrimes;
	}
	private boolean isPrime(int n) {
		return primes.contains(n);
	}
	
	// This function is adapted from P007 so that it
	// wraps the prime numbers in Integer objects
	// and then returns a Set.
	private Set<Integer> getPrimes(int limit) {
		int primeCandidate;
		int primeCount;
		
		Integer primes[] = new Integer[limit];
		
		primes[0] = 2;
		primeCount = 1;
		primeCandidate = 3;

		while (primeCount < limit) {
			boolean isPrime = true;
			// Check the candidate to see if it is divisible by 
			// any of the known primes calculated so far.
			for(int i = 0; i < primeCount; i++) {
				if ( primeCandidate % primes[i] == 0 ) {
					isPrime = false;
					break;
				}
			}

			if (isPrime == true) {
				primes[primeCount] = primeCandidate;
				primeCount += 1;
			}
			primeCandidate += 2;
		}
		// Primes must be Integer wrapped for the HashSet constructor.
		return new HashSet<Integer>( Arrays.asList(primes) );
	}

	@Test(timeout = 2_000)
	public void QuadraticPrimes() {
		int productOfCoeffiecients = 0;

		productOfCoeffiecients = quadraticPrimes(1_000);
		System.out.printf("quadraticPrimes(1_000) = %s%n", productOfCoeffiecients);
		assertEquals( productOfCoeffiecients, -59231);
	}
}
