package com.translationdata.p020;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;
/** Strategy: Brute Force. String Manipulation. */
public class P026_ReciprocalCycles {
	private final boolean isDebug = false;
	int maximumCycle = 0;

	public int reciprocalCycles(int upperLimit) {
		StringBuilder reverseQuotient = new StringBuilder("");

		int precision = 2000;
		StringBuffer numeratorString = new StringBuffer("1");

		for (int i = 0; i < precision; i++) {
			numeratorString.append( "0" );
		}

		BigInteger numerator = new BigInteger(numeratorString.toString());
		if (isDebug)
			System.out.printf("No. of digits calculated = %d%n",precision);
		
		int cycle = enumerateDenominator(upperLimit, reverseQuotient, precision, numerator);

		return cycle;
	}

	private int enumerateDenominator(int limit, StringBuilder reverseQuotient,
			int precision, BigInteger numerator) {
		int cycle = 0;
		BigInteger quotient;

		for (int denominator = 2; denominator < limit; denominator++) {
			quotient = numerator.divide(new BigInteger(Integer.toString(denominator)) );

			// Reverse the quotient so that it reads like Arabic, right to left.  
			// Repeating numbers are now on the left.
			reverseQuotient.append(quotient.toString()).reverse();
			cycle = findDenominatorWIthMaximumCycleLength(reverseQuotient, precision, cycle, denominator);
			reverseQuotient.setLength(0);
		}

		if(isDebug)
			System.out.printf("Maximum cycle length found = %d%n", maximumCycle);
		return cycle;
	}

	private int findDenominatorWIthMaximumCycleLength(
			StringBuilder reverseQuotient, int precision, int cycle,
			int denominator) {
		for (int length = 1; length < precision / 2; length++) {
			if( reverseQuotient.toString().substring(0, length).equals(reverseQuotient.toString().substring(length, length*2))) {
				if(length > maximumCycle) {
					maximumCycle = length;
					cycle = denominator;
				}
				break;
			}
		}
		return cycle;
	}

	@Test(timeout = 2_000)
	public void ReciprocalCycles() {
		int maximumCycleLength = reciprocalCycles(1_000);
		System.out.printf("reciprocalCycles(1_000) = %d%n", maximumCycleLength);
		assertEquals(983, maximumCycleLength);
	}
}
