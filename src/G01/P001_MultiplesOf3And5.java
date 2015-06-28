package G01;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

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

	// This is a variation of the sum(1..n) formula.
	//
	// Sum(1...kn) = k * n * (n + 1)
	//                   -----------
	//                        2
	// The formula includes n, the problem does not.
	private int calculateSumBelowLimit(int upperLimit, int divisor) {
		int n = (upperLimit - 1)/divisor;
		return divisor * n * ( n + 1 ) / 2 ;
	}

	@Test(timeout=50)
	public void SumOfMultiplesOf3And5Below1000() {
		int sumOfMultiples = multiplesOf3And5(1_000);
		System.out.printf("multiplesOf3And5(1000) = %s%n", sumOfMultiples);
		assertThat( "Incorrect sum of multiples of 3 or 5 below 1,000", sumOfMultiples, is(233168) );
	}
	
	@Test(timeout=100)
	public void SumOfMultiplesOf3And5Below10_000() {
		int sumOfMultiples = multiplesOf3And5(10_000);
		System.out.printf("multiplesOf3And5(10_000) = %s%n", sumOfMultiples);
		assertThat( "Incorrect sum of multiples of 3 or 5 below 10,000", sumOfMultiples, is(23331668) );
	}
}
