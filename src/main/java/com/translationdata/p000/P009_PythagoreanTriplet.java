package com.translationdata.p000;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.translationdata.JUnitTests.FastTest;

import org.junit.experimental.categories.Category;
/** Strategy: Brute Force. */
@Category(FastTest.class)
public class P009_PythagoreanTriplet {
	public int pythagoreanTriplet(final int tripletSum) {
		int tripletProduct = enumerateAllXValues(tripletSum);
		return tripletProduct;
	}

	private int enumerateAllXValues(final int tripletSum) {
		int tripletProduct = 0;
		int x;
		for (x = 3; x <= tripletSum - 2; x++) {
			tripletProduct = enumerateAllYValues(tripletSum, x);
			if (tripletProduct !=  0)
				break;
		}
		return tripletProduct;
	}

	private int enumerateAllYValues(final int tripletSum, final int x) {
		final boolean isDebug = false;
		int r;
		int tripletProduct;

		for (int y = x + 1; y <= tripletSum - 2; y++) {
			r = tripletSum - x - y;
			if ( isTriplet(x, r, y) ) {
				tripletProduct = x*y*r;
				if (isDebug)
					System.out.printf("Triplet (x, y, r) = (%d,%d,%d)%n", x,y,r);
				return tripletProduct;
			}
		}
		return 0;
	}

	private boolean isTriplet(final int x, final int r, final int y) {
		return x*x + y*y == r*r;
	}

	@Test(timeout = 500)
	public void PythagoreanTriplet() {
		int result = pythagoreanTriplet(1000);
		System.out.printf(this.getClass().getSimpleName() + ": pythagoreanTriplet(1000) = %d%n", result);
		assertEquals("Incorrect product", 31875000, result);
	}
}
