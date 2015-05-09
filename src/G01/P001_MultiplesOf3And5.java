package G01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import common.FastTest;

/** Strategy: Mathematics. Time complexity is O(1) */
@Category(FastTest.class)
public class P001_MultiplesOf3And5 {
	public int multiplesOf3And5(int upperLimit) {
		int MultiplesSum = 0;		
		
		MultiplesSum += calculateSumBelowLimit(upperLimit, 3);
		MultiplesSum += calculateSumBelowLimit(upperLimit, 5);
		MultiplesSum -= calculateSumBelowLimit(upperLimit, 15);
		return MultiplesSum;
	}
	
	private int calculateSumBelowLimit(int upperLimit, int divisor) {
		int result = 0;
		// This is a variation of the sum(1..n) formula.
		//
		// Sum(1...kn) = k * n * (n + 1)
		//                   -----------
		//                        2
		// Also the formula includes n, the problem does not.
		int n = (upperLimit-1)/divisor;
		result = divisor * n * (n + 1) / 2  ;
		return result;
	}

	@Test
	public void SumOfMultiplesOf3And5Below1000() {
		int sumOfMultiples = multiplesOf3And5(1_000);
		System.out.printf("multiplesOf3And5(1000) = %s%n", sumOfMultiples);
		assertEquals( "Incorrect sum of multiples of 3 or 5 below 1,000", 233168, sumOfMultiples );
	}
	
	@Test(timeout=100)
	public void SumOfMultiplesOf3And5Below10_000() {
		int sumOfMultiples = multiplesOf3And5(10_000);
		System.out.printf("multiplesOf3And5(10_000) = %s%n", sumOfMultiples);
		assertEquals( "Incorrect sum of multiples of 3 or 5 below 10,000", 23331668, sumOfMultiples );
	}
}
