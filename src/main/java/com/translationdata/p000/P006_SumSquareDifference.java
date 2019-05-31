package com.translationdata.p000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.translationdata.JUnitTests.FastTest;

import org.junit.experimental.categories.Category;

/** Strategy: Simple mathematics. */
@Category(FastTest.class)
public class P006_SumSquareDifference {
	private long sumSquareDifference(final int maxNum) {
		final long squareDifference = squareSum(maxNum) - sumSquares(maxNum);

		return squareDifference;
	}

	private long sumSquares(int maxNum) {
		return sumSquaresImpl(maxNum, 0L, 1);
	}

	private long sumSquaresImpl(final int maxNum, final long total, final int count) {
		if (count <= maxNum) {
			return sumSquaresImpl(maxNum, total + count * count, count + 1);
		}
		return total;
	}

	private long squareSum(final int maxNum) {
		return squareSumImpl(maxNum, 0L, 1);
	}

	private long squareSumImpl(final int maxNum, final long total, final int count) {
		if (count <= maxNum) {
			return squareSumImpl(maxNum, total + count, count + 1);
		}
		return total * total;
	}

	@Test(timeout = 500)
	public void SumSquareDifference() {
		long sum = sumSquareDifference(100);
		System.out.printf("sumSquareDifference(%d) = %d%n", 100, sum);
		assertEquals("Incorrect sum", 25164150, sum);
	}

}
