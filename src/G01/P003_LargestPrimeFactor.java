package G01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * Strategy: Brute force. 
 * The largest factor a number can have is the square root.
 * Find all the even factors and then find all of the odd factor.
 * @author Harold Almon
 *
 */
public class P003_LargestPrimeFactor {
	public long largestFactor(long product) {
		long[] result = getLongFactors(product);
		return result[result.length-1];
	}
	
	private long[] getLongFactors(long longNumber) {
	    long[] factors = new long[100];
	    int freePosition = 0, factor;
	    long product = longNumber;
	    
	    // Find all the factors that are 2. Need to find these
	    // because we need to test for odd factors later.
	    while (product % 2 == 0) {
	        factors[freePosition] = 2;
	        freePosition += 1;
	        product /= 2;
	    }
	    
	    // Now find the other factors starting at 3...
	    factor = 3;

	    // The largest possible factor of a number is the square root,
	    // so when you go larger than that, you can stop.
	    while (factor <= Math.sqrt(product) + 1) {
	        if (product % factor == 0) {
	        	
	        	// Store the factor in the array...
	            factors[freePosition++] = factor;
	            
	            // Remove the factors from the number...
	            product /= factor;
	        } else {
	        	// Try the next odd number that might be a factor...
	            factor += 2;
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

	int[] getFactors(final int intNumber) {
	    int[] factors = new int[100];
	    int i = 0, oddNum;
	    int product = intNumber;
	    
	    while (product % 2 == 0) {
	        factors[i++] = 2;
	        product /= 2;
	    }
	    oddNum = 3;

	    while (oddNum <= Math.sqrt(product) + 1) {
	        if (product % oddNum == 0) {
	            factors[i++] = oddNum;
	            product /= oddNum;
	        } else {
	            oddNum += 2;
	        }
	    }
	    
	    if (product > 1) {
	        factors[i++] = product;
	    }
	    
	    int[] trimmedCopy = Arrays.copyOf(factors, i);

	    return trimmedCopy;
	}

	@Test(timeout=100)
	public void GetLargestPrimeFactorOf600851475143() {
		long result = largestFactor(600851475143L);
		System.out.printf("largestFactor(600851475143) = %d%n", result);
		assertEquals("Maximum prime factor of 600851475143", 6857, result);
	}
}
