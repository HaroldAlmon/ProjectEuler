package com.translationdata.p010;
/** Strategy: Simple Mathematics. */
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class P016_PowerDigitSum {
	public int sumOfDigits(final int power) {
		BigInteger sumOfPowers = new BigInteger("2");
		BigInteger two = new BigInteger("2");
		int result = 0;	

		sumOfPowers = calculatePowerOfTwo(power, sumOfPowers, two);

		String digits = sumOfPowers.toString();
		result = sumOfDigits(digits);
		return result;
	}

	private int sumOfDigits(final String s) {
		int result = 0;
		for (int index = 0; index < s.length(); index++)
			result += Character.getNumericValue(s.charAt(index));
		return result;
	}

	private BigInteger calculatePowerOfTwo(final int power, BigInteger sum, final BigInteger two) {
		BigInteger powerSum = sum;
		for(int i = 0; i < power - 1; i++)
			powerSum = powerSum.multiply(two);
		return powerSum;
	}
	
	@Test(timeout = 500)
	public void Sum() {
		int powerDigitSum = sumOfDigits(1000);
		System.out.printf("Result = %d%n", powerDigitSum);
		assertEquals( "Incorrect sum", powerDigitSum, 1366 );
	}
}