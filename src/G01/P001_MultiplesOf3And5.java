package G01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Strategy: Brute force. Simple mathematics.
 * 
 * This solution might be slower or faster than checking every
 * number with division by 3 and 5 but I have not tested the
 * difference.
 * @author Harold Almon
 */
public class P001_MultiplesOf3And5 {
	public int multiplesOf3And5(int upperLimit) {
		int sumOfMultiples = 0;

		sumOfMultiples = addMultiplesof3(upperLimit, sumOfMultiples);
		sumOfMultiples = addMultiplesOf5(upperLimit, sumOfMultiples);
		return sumOfMultiples;
	}
	
	private int addMultiplesof3(int upperLimit, int sumOfMultiples) {
		int multipleOf3 = 3;
		while (multipleOf3 < upperLimit ) {
			sumOfMultiples += multipleOf3;
			multipleOf3 += 3;
		}
		return sumOfMultiples;
	}

	private int addMultiplesOf5(int upperLimit, int sumOfMultiples) {
		int multipleOf5 = 5;		
		while (multipleOf5 < upperLimit ) {
			sumOfMultiples = addToSumOfMultiplesIfNotMultipleOfThree(sumOfMultiples, multipleOf5);
			multipleOf5 += 5;
		}
		return sumOfMultiples;
	}

	private int addToSumOfMultiplesIfNotMultipleOfThree(int sumOfMultiples, int multOf5) {
		if( multOf5 % 3 != 0) {
			sumOfMultiples += multOf5;
		}
		return sumOfMultiples;
	}

	@Test(timeout=100)
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
