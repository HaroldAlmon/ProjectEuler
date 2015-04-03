package G01;

/**
 * Strategy: Simple Mathematics.
 * @author Harold Almon
 */
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class P005_SmallestMultipleArray {
	public static void main(String[] args) {
		new P005_SmallestMultipleArray().run(20);
	}

	long run(int maxDivisor) {
		P003_LargestPrimeFactor maxFactor = new P003_LargestPrimeFactor();
		
		// factorCount the *count* of the factor N in position int[N] for a number.
		// If 2*3*3 are factors then factorCount[2] = 1, factorCount[2] = 3;
		
		// This might be faster with a HashMap.
		int[] factorCount = new int[20];
		int[] finalCount = new int[20];
		int[] factors;
		
		// Get all of the prime factors of all the numbers from 2 thru N
		// Note that the prime factors will repeat like 2*2*3.
		for(int divisor=2; divisor<=maxDivisor; divisor += 1) {
			factors = maxFactor.getFactors(divisor);
			
			// Count the identical factors in the current number...
			for(int factIdx = 0; factIdx < factors.length; factIdx++) {
				factorCount[factors[factIdx]] += 1;
			}
			
			// Copy the factor count to the final count if we have a bigger total.
			// This causes some numbers to drop out of the final product. e.g. 4
			// is not include because 12 = 2 * 2 * 3 that includes 4 as a sub-product.
			// So if the final product includes 2 * 2 and (* 3) then that number is
			// divisible by both 4 and 12.
			for(int factIdx = 0; factIdx < maxDivisor; factIdx++) {
				if(factorCount[factIdx] > finalCount[factIdx]) {
					finalCount[factIdx] = factorCount[factIdx];
				}
			}
			Arrays.fill(factorCount, 0);
			
			System.out.printf("Factors of %d: %s\n", divisor, Arrays.toString(factors));
		};
		
		long result = 1;

		// Take the factors and multiply them together to get the result...
		for(int factIdx = 0; factIdx < maxDivisor; factIdx++) {
			if(finalCount[factIdx] != 0 ) {
				System.out.printf("Factor %d count %d\n", factIdx, finalCount[factIdx]);
				result *= (long) Math.pow(factIdx, finalCount[factIdx]);
			}
		}
		System.out.println("Total = " + result);
		return result;
	}
	
	@Test
	public void test1() {
		assertTrue( run(20) == 232792560 );
	}
	
	@Test
	public void test2() {
		assertTrue( run(10) == 2520);
	}
	
	@Test
	public void test3() {
		assertTrue( run(15) == 360360);
	}
}
