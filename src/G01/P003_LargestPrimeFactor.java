package G01;

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
	public static void main(String[] args) {
		long product = 2520 ;
		System.out.println("Factors: " + Arrays.toString(new P003_LargestPrimeFactor().getFactorsLong(product) ));
	}
	
	long getMaxFactor(long product) {
		long[] result = new P003_LargestPrimeFactor().getFactorsLong(product);

		return result[result.length-1];
	}
	
	// 64 bit max version...
	long[] getFactorsLong(long value) {
		// Each position of a[] stores a factor.  Factors are not always unique (e.g. 2*2*7).
	    long[] factors = new long[100];
	    int i = 0, oddNum;
	    long product = value;
	    
	    // Find all the factors that are 2. Need to find these
	    // because we need to test for odd factors later.
	    while (product % 2 == 0) {
	        factors[i++] = 2;
	        product /= 2;
	    }
	    
	    // Now find the other factors starting at 3...
	    oddNum = 3;

	    // The largest possible factor of a number is the square root,
	    // so when you go larger than that, you can stop.
	    while (oddNum <= Math.sqrt(product) + 1) {
	        if (product % oddNum == 0) {
	        	
	        	// Store the factor in the array...
	            factors[i++] = oddNum;
	            
	            // Remove the factors from the number...
	            product /= oddNum;
	        } else {
	        	// Try the next odd number that might be a factor...
	            oddNum += 2;
	        }
	    }
	    
	    // Do not include 1 as a factor.  This happens with prime numbers
	    // like 13 that only have 1 factor. So 13/13 leaves a 1 in num.
	    if (product > 1) {
	        factors[i++] = product;
	    }
	    
	    // Copy the factors to a new array...
	    long[] trimmedCopy = Arrays.copyOf(factors, i);
	    //System.out.println(Arrays.toString(b));
	    return trimmedCopy;
	}

	// 32 bit max version...
	// Return an array with all of the factors for a number.
	int[] getFactors(final int value) {
	    int[] factors = new int[100];
	    int i = 0, oddNum;
	    int product = value;
	    
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

	@Test
	public void test1() {
		long result = getMaxFactor(600851475143L);
		assertTrue(result == 6857);
		System.out.println(result);
	}
}
