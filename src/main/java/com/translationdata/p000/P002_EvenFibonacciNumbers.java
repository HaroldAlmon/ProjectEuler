package com.translationdata.p000;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import com.translationdata.JUnitTests.FastTest;
import org.junit.experimental.categories.Category;

/** Strategy: Simple mathematics. */
@Category(FastTest.class)
public class P002_EvenFibonacciNumbers {
	int fiboSum(int upperLimit) {
		return fiboSumImpl(1, 2, 2, upperLimit);
	}

	int fiboSumImpl(final int fibo1, final int fibo2, final int total, final int upperLimit) {
		final int nextFibo = fibo1 + fibo2;
		if ( nextFibo < upperLimit) {
			if(nextFibo % 2 == 0)
				return fiboSumImpl(fibo2, nextFibo, total + nextFibo, upperLimit);
			else
				return fiboSumImpl(fibo2, nextFibo, total, upperLimit);
		}
		else
			return total;
	}

	@Test(timeout=500)
	public void SumOfEvenTermsLessThanFourMillion() {
		int result = fiboSum(4_000_000);
		System.out.printf("fiboSum(4_000_000) = %s%n", result);
		assertThat( "Incorrect sum of even Fibo numbers that do not exceed 4 million", result, is(4613732) );
	}
}
