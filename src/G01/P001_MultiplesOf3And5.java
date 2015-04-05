package G01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Strategy: Brute force.
 * Instead of doing a modulus check on every
 * number, sum all the numbers by adding 3 and then
 * adding 5.
 * This solution might be faster than checking every
 * number with division by 3 and 5 but I have not tested the
 * difference.
 * @author halmon
 */
public class P001_MultiplesOf3And5 {
	public static void main(String[] args) {
		System.out.printf("result = %d\n", new P001_MultiplesOf3And5().run(10));
	}
	long run(int upperLimit) {
		long result = 0;
		
		int multOf3 = 3;
		int multOf5 = 5;

		while (multOf3 < upperLimit ) {
			result += multOf3;
			multOf3 += 3;
		}
		
		// Exclude numbers that are a multiple of 3 because they are already in the total... 
		while (multOf5 < upperLimit ) {
			if( multOf5 % 3 != 0) {
				result += multOf5;
			}
			multOf5 += 5;
		}	
		
		return result;
	}

	@Test(timeout=100)
	public void CountMultiplesOfThreeAndFive() {
		assertEquals( "Incorrect mutiples count, ", 233168, run(1000) );
	}
}
