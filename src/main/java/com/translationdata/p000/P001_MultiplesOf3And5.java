package com.translationdata.p000;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import com.translationdata.JUnitTests.FastTest;

import org.junit.experimental.categories.Category;

/** Strategy: Simple Mathematics. Time complexity is O(1) */
@Category(FastTest.class)
public class P001_MultiplesOf3And5 {
	public int multiplesOf3And5(final int upperLimit) {
		return calculateSumBelowLimit(upperLimit, 3)
			+ calculateSumBelowLimit(upperLimit, 5)
			- calculateSumBelowLimit(upperLimit, 15);
	}

	// This is a variation of the sum(1..n) formula.
	//
	// Sum(1...kn) = k * n * (n + 1)
	//                   -----------
	//                        2
	// The formula includes n, the problem does not.
	private int calculateSumBelowLimit(final int upperLimit, final int divisor) {
		final int n = (upperLimit - 1)/divisor;
		return divisor * n * ( n + 1 ) / 2 ;
	}

	@Test(timeout=50)
	public void SumOfMultiplesOf3And5Below1000() {
		final int sumOfMultiples = multiplesOf3And5(1_000);
		System.out.printf(this.getClass().getSimpleName() + ": multiplesOf3And5(1000) = %s%n", sumOfMultiples);
		assertThat( "Incorrect sum of multiples of 3 or 5 below 1,000", sumOfMultiples, is(233168) );
	}
	
	@Test(timeout=100)
	public void SumOfMultiplesOf3And5Below10_000() {
		final int sumOfMultiples = multiplesOf3And5(10_000);
		System.out.printf(this.getClass().getSimpleName() + ": multiplesOf3And5(10_000) = %s%n", sumOfMultiples);
		assertThat( "Incorrect sum of multiples of 3 or 5 below 10,000", sumOfMultiples, is(23331668) );
	}
}
