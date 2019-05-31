package com.translationdata.p010;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** Strategy: Simple Mathematics. */
public class P012_TriangularNumber {
	long triangularNumber(final int divisorLimit) {
		final boolean isDebug = false;
		int naturalNumber = 2;
		int triangleNumber = 3;
		int numberOfDivisors = 0;
		
		while (true) {
			numberOfDivisors = divisorCount(triangleNumber);
			if (numberOfDivisors > divisorLimit) 
				break;
			naturalNumber = nextNaturalNumber(naturalNumber);
			triangleNumber = nextTriangleNumber(triangleNumber, naturalNumber);
		}
		
		if(isDebug) 
			System.out.printf("no. of divisors = %d, Triangle seq no. = %d%n", numberOfDivisors , naturalNumber);
		
		return triangleNumber;
	}
	
	private int nextNaturalNumber(final int naturalNumber) {
		return naturalNumber + 1;
	}
	
	private int nextTriangleNumber(final int triangleNumber, final int naturalNumber) {
		return triangleNumber + naturalNumber;
	}
	
	int divisorCount(final int triangleNumber) {
		int divisorTotal = 0;
		int maxDivisor = (int) (triangleNumber/2);
		for (int n = 2; n <= maxDivisor; n++) {
			if (isDivisorOfTriangleNumber(triangleNumber, n)) 
			{
				divisorTotal += 2;
				maxDivisor = newDivisorLimit(triangleNumber, n);
			}
		}
		return divisorTotal + 2;
	}
	
	private int newDivisorLimit(final int n, final int i) {
		return (n / i) - 1;
	}
	
	private boolean isDivisorOfTriangleNumber(final long triangleNumber, final int i) {
		return triangleNumber % i == 0;
	}

	@Test(timeout = 3_000)
	public void TriangularNumber() {
		long triangleNumber = triangularNumber(500);
		System.out.printf("triangularNumber(500) = %d%n", triangleNumber);
		assertEquals( 76576500, triangleNumber );
	}
}
