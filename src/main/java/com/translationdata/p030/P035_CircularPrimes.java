package com.translationdata.p030;

import org.junit.Test;

import com.translationdata.util.SieveOfEratosthenes;

public class P035_CircularPrimes {
	SieveOfEratosthenes sieve = new SieveOfEratosthenes();
	public int countPrimes( int upperLimit ) {
		int circularPrimeCount = 0;	
		sieve.generatePrimes(upperLimit);
		circularPrimeCount = enumeratePrimeCandidates( upperLimit );
		return circularPrimeCount;
	}
	private int enumeratePrimeCandidates( int upperLimit ) {
		int circularPrimeCount = 0;	
		for(int candidate = 2; candidate < upperLimit; candidate += 1) {
			String candidatePrime = Integer.toString(candidate);
			
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
