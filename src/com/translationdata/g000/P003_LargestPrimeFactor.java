package com.translationdata.g000;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import JUnitTests.FastTest;

/** Strategy: Brute Force. */
@Category(FastTest.class)
public class P003_LargestPrimeFactor {
	public long largestPrimeFactor(long product) {
		long[] factors = factors(product);
		return factors[factors.length-1];
	}
	
	private long[] factors(long longNumber) {
	    long[] factors = new long[100];
	    int freePosition = 0, candidateFactor;
	    long product = longNumber;
	    
	    // Find all the factors of 2.
	    while (product % 2 == 0) {
	        factors[freePosition] = 2;
	        freePosition += 1;
	        product /= 2;
	    }
	    
	    candidateFactor = 3;
	    int largestPossibleFactor = (int) Math.sqrt(product) + 1;
	    while ( candidateFactor <= largestPossibleFactor ) {
	        if (product % candidateFactor == 0) {
	        	factors[freePosition++] = candidateFactor;
	            product = removeFactorFromProduct(candidateFactor, product);
	        } else {
	            candidateFactor += 2;
	        }
	    }
	    
	    // Do not include 1 as a factor.  This happens with prime numbers
	    // like 13 that only have 1 factor. So 13/13 leaves a 1 in num.
	    if (product > 1) {
	        factors[freePosition++] = product;
	    }
	    
	    long[] trimmedCopy = Arrays.copyOf(factors, freePosition);
	    return trimmedCopy;
	}

	private long removeFactorFromProduct(int candidateFactor, long product) {
		return product / candidateFactor;
	}

	int[] factors(final int intNumber) {
	    int[] factors = new int[100];
	    int i = 0;
	    int candidateFactor;
	    int product = intNumber;
	    
	    while (product % 2 == 0) {
	        factors[i++] = 2;
	        product /= 2;
	    }
	    candidateFactor = 3;

	    while (candidateFactor <= Math.sqrt(product) + 1) {
	        if (product % candidateFactor == 0) {
	            factors[i++] = candidateFactor;
	            product = removeFactorFromProduct(candidateFactor, product);
	        } else {
	            candidateFactor += 2;
	        }
	    }
	    
	    if (product > 1) {
	        factors[i++] = product;
	    }
	    
	    int[] trimmedCopy = Arrays.copyOf(factors, i);

	    return trimmedCopy;
	}

	private int removeFactorFromProduct(int candidateFactor, int product) {
		return product /= candidateFactor;
	}

	@Test(timeout=100)
	public void GetLargestPrimeFactorOf600851475143() {
		long result = largestPrimeFactor(600851475143L);
		System.out.printf("largestFactor(600851475143) = %d%n", result);
		assertEquals("Maximum prime factor of 600851475143", 6857, result);
	}
}
