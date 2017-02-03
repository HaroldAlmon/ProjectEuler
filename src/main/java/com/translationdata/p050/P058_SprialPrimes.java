package com.translationdata.p050;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import com.translationdata.util.SieveOfEratosthenes;

// NOTE: increase heap size to -Xmx2000m
public class P058_SprialPrimes {
	SieveOfEratosthenes primeSieve = new SieveOfEratosthenes(1_300_000_000);

	int calcPrimes() {
		int height = 1;
		int squareMax = 1;
		int argLeftPrimeCount = 0;
		int argRightPrimeCount = 0;
		float ratio;
		int nextHeight;
		do {
			int upperRight = squareMax + (height + 1) * 1;
			int upperLeft = squareMax + (height + 1) * 2;
			int lowerLeft = squareMax + (height + 1) * 3;
			int lowerRight = squareMax + (height + 1) * 4;
			nextHeight = height + 2;

			int leftPrimeCount = argLeftPrimeCount 
					+ (primeSieve.isPrime(upperLeft) ? 1 : 0)
					+ (primeSieve.isPrime(lowerRight) ? 1 : 0);

			int rightPrimeCount = argRightPrimeCount 
					+ (primeSieve.isPrime(upperRight) ? 1 : 0)
					+ (primeSieve.isPrime(lowerLeft) ? 1 : 0);

			ratio = ((((float) leftPrimeCount + (float) rightPrimeCount) / ((float) nextHeight * 2 - 1)) * 100);
			height = nextHeight;
			squareMax = lowerRight;
			argLeftPrimeCount = leftPrimeCount;
			argRightPrimeCount = rightPrimeCount;

			/*
			 * System.out.println("height = " + height + ", upperRight = " +
			 * upperRight + ", " + "leftPrimeCount = " + leftPrimeCount +
			 * ", rightPrimeCount = " + rightPrimeCount + ", ratio = " + ratio);
			 */
		} while (ratio > 10);
		return nextHeight;
	}

	@Test
	public void spiralPrimes() {
		int result = calcPrimes();
		System.out.println("P058_SprialPrimes: Height = " + result);
		assertThat("Incorrect height", result, is(26241));
	}
}
