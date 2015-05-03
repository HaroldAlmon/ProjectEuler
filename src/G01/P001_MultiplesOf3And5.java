package G01;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

/** Strategy: Brute force. Simple mathematics. */
public class P001_MultiplesOf3And5 {
	public int multiplesOf3And5(int upperLimit) {
		int sumOfMultiples = 0;		
		
		sumOfMultiples += calculateSumBelowLimit(upperLimit, 3);
		sumOfMultiples += calculateSumBelowLimit(upperLimit, 5);
		sumOfMultiples -= calculateSumBelowLimit(upperLimit, 15);
		return sumOfMultiples;
	}
	
	private int calculateSumBelowLimit(int upperLimit, int divisor) {
		int result = 0;
		int adjustedLimit = (upperLimit-1)/divisor;

		// This is a variation of the sum(1..n) formula.
		result = adjustedLimit * (adjustedLimit + 1) / 2 * divisor ;
		return result;
	}

	@Test
	public void SumOfMultiplesOf3And5Below1000() {
		int sumOfMultiples = multiplesOf3And5(1000);
		System.out.printf("multiplesOf3And5(1000) = %s%n", sumOfMultiples);
		assertEquals( "Incorrect sum of multiples of 3 or 5 below 1000", 233168, sumOfMultiples );
	}
	
	@Test(timeout=100)
	public void SumOfMultiplesOf3And5Below10_000() {
		int sumOfMultiples = multiplesOf3And5(10_000);
		System.out.printf("multiplesOf3And5(10_000) = %s%n", sumOfMultiples);
		assertEquals( "Incorrect sum of multiples of 3 or 5 below 10_000", 23331668, sumOfMultiples );
	}
}
