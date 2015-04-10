package G01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

import org.junit.Test;
public class P005_SmallestMultipleHashMap {
	public static void main(String[] args) {
		new P005_SmallestMultipleHashMap().run(20);
	}

	long run(int maxDivisor) {
		P003_LargestPrimeFactor maxFactor = new P003_LargestPrimeFactor();
		
		// Holds the *count* of the factor n in position int[n] for a number.
		// If 2*2*2 are factors then factorCount[2] = 3;
		
		HashMap<Integer, Integer> factorCount = new HashMap<>();

		// Use a TreeMap instead of a HashMap so I can retrieve the keys in a sorted order.
		// Each entry contains the factor and the number of times the factor appears.
		// 2*3*3=18 would be represented by (2,1), (3,2).
		TreeMap<Integer, Integer> finalCount = new TreeMap<>();
		int[] factors;

		for(int divisor=2; divisor<=maxDivisor; divisor += 1) {
			factors = maxFactor.getFactors(divisor);
			
			// Count the identical factors in the current number...
			for(int factIdx = 0; factIdx < factors.length; factIdx++) {
				if (factorCount.containsKey( factors[factIdx] )) {
					
					// Increment the factor count.  There is hidden unboxing and boxing here.
					factorCount.put(factors[factIdx], factorCount.get(factors[factIdx]) + 1);
				} else {
					
					
					// A new factor, set the count to 1...
					factorCount.put(factors[factIdx], 1);
				};
			}
			
			// Copy the factor count to the final count if we have a bigger total...
			for(Integer factor : factorCount.keySet()) {
				if(finalCount.containsKey(factor)) {

					// Only copy the total if the total exceeds the existing factor count...
					if(factorCount.get(factor) > finalCount.get(factor)) {
						finalCount.put(factor, factorCount.get(factor));
					}
				} else {
					// If the factor is not in the final count then copy the total into the final count.
					finalCount.put(factor, factorCount.get(factor));
				}
			}
			factorCount.clear();
			
			//System.out.printf("Factors of %d: %s\n", divisor, Arrays.toString(factors));
		};
		
		long result = 1;

		// Take the factors out of the finalCount map and multiply them together to get the result...
		for (Integer factor : finalCount.keySet()) {
			//System.out.printf("Factor %d count=%d\n", factor, finalCount.get(factor));
			result *= (long) Math.pow(factor, finalCount.get(factor));
		}
		System.out.printf("Result(%d) = %d\n", maxDivisor, result);
		return result;
	}
	
	@Test
	public void ProductOf20() {
		assertEquals( "Incorrect product, ", 232792560 , run(20));
	}
	
	@Test
	public void ProductOf10() {
		assertEquals( "Incorrect product, ", 2520 , run(10));
	}
	
	@Test
	public void ProductOf15() {
		assertEquals( "Incorrect product, ", 360360 , run(15));
	}
}
