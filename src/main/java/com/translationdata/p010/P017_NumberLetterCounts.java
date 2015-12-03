package com.translationdata.p010;
/** Strategy: Simple Mathematics */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class P017_NumberLetterCounts {
	int lengthOfand = "and".length();
	
	static List<Integer> singleDigitLengths = Arrays.asList( new Integer[] {
		"one".length(),
		"two".length(),
		"three".length(),
		"four".length(),
		"five".length(),
		"six".length(),
		"seven".length(),
		"eight".length(),
		"nine".length()
	});

	static List<Integer> mutilpleOfTens = Arrays.asList(new Integer[] {
		"twenty".length(),
		"thirty".length(),
		"forty".length(),
		"fifty".length(),
		"sixty".length(),
		"seventy".length(),
		"eighty".length(),
		"ninety".length()
	});

	int lengthOf1to9 = sum1to9( singleDigitLengths );

	private int sum1to9( List<Integer> digitLengths ) {
		return digitLengths.get(0) +
				digitLengths.get(1) +
				digitLengths.get(2) +
				digitLengths.get(3) +
				digitLengths.get(4) +
				digitLengths.get(5) +
				digitLengths.get(6) +
				digitLengths.get(7) +
				digitLengths.get(8);
	}

	int lengthOf10to19 = 
		"ten".length() +
		"eleven".length() +
		"twelve".length() +
		"thirteen".length() +
		"fourteen".length() +
		"fifteen".length() +
		"sixteen".length() +
		"seventeen".length() +
		"eighteen".length() +
		"nineteen".length();
	
	int lengthOf1to19 = lengthOf1to9 + lengthOf10to19;
	int lengthOf1to99 = 0;
	
	int lengthOfhundred = "hundred".length();
	int lengthOfthousand = "thousand".length();
	
	int lengthOfand1to99 = 0;

	/**
	 * @return int The sum of all the letters of the numbers from 1 to 1000 (one thousand) inclusive, written out in words.
	 */
	public int numberLetterCounts() {
		int result = 0;

		lengthOf1to99 = sum1To99();
		lengthOfand1to99 = sumAnd1To99();

		result = lengthOf1to99;
		result += sumOf100to999( result );
		result += lengthOf1000( result );
		return result;
	}
	private int sumAnd1To99() {
		return lengthOf1to99 + lengthOfand * 99;
	}
	private int sum1To99() {
		return lengthOf1to19 + sum20to99();
	}
	private int lengthOf1000(int result) {
		result += singleDigitLengths.get( 0 ) + lengthOfthousand;
		return result;
	}
	private int sumOf100to999(int result) {
		for( int i : singleDigitLengths)
			result += (i + lengthOfhundred) * 100 + lengthOfand1to99;
		return result;
	}
	private int sum20to99() {
		int L20to99 = 0;
		for( int i : P017_NumberLetterCounts.mutilpleOfTens)
			L20to99 += i * 10 + lengthOf1to9;
		return L20to99;
	}

	@Test
	public void CountLetters() {
		int letterCount = numberLetterCounts();
		System.out.printf("numberLetterCounts() = %d%n", letterCount);
		assertEquals( 43945, letterCount );
	}
}
