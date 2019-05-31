package com.translationdata.p020;
/** Strategy: Simple Mathematics */
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class P020_FactorialDigitSum {
	public int factorialDigitSum(int upperLimit) {
		String factorialString;
		int sumOfDigits = 0;

		BigInteger factorial = new BigInteger("1");

		factorial = factorial(upperLimit, factorial);
		factorialString = factorial.toString();
		sumOfDigits = sumOfDigits(factorialString, sumOfDigits);
		return sumOfDigits;
	}

	private int sumOfDigits(String factorialString, int sumOfDigits) {
		for (int position = 0; position < factorialString.length(); position++) {
			sumOfDigits += Character.getNumericValue(factorialString.charAt(position));
		}
		return sumOfDigits;
	}
	private BigInteger factorial(int upperLimit, BigInteger factorial) {
		BigInteger one = new BigInteger("1");
		BigInteger multiplier = new BigInteger("2");
		for (int i = 2; i <= upperLimit; i++) {
			factorial = factorial.multiply(multiplier);
			multiplier = multiplier.add(one);
		}
		return factorial;
	}

	@Test
	public void FactorialDigitSum() {
		int sumOfDigits = factorialDigitSum(100);
		System.out.printf("factorialDigitSum(100) = %d%n", sumOfDigits);
		assertEquals(sumOfDigits, 648 );
	}
}
