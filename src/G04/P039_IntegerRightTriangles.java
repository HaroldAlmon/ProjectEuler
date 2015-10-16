package G04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class P039_IntegerRightTriangles {
	public int pythagoreanTriplet(int tripletSum) {
		int tripletProduct = enumerateAllXValues(tripletSum);
		return tripletProduct;
	}

	private int enumerateAllXValues(int tripletSum) {
		int tripletProduct = 0;
		int x;
		for (x = 3; x <= tripletSum - 2; x++) {
			tripletProduct += enumerateAllYValues(tripletSum, x);
		}
		return tripletProduct;
		
	}

	private int enumerateAllYValues(int tripletSum, int x) {
		final boolean isDebug = true;
		int r;
		int tripletProduct;
		int tripleCount = 0;

		for (int y = x + 1; y <= tripletSum - 2; y++) {
			r = tripletSum - x - y;
			if ( isTriplet(x, r, y) ) {
				tripleCount += 1;
				tripletProduct = x*y*r;
				if (isDebug) {
					System.out.printf("Triplet (x, y, r) = (%d,%d,%d)%n", x,y,r);
				}
				//return tripletProduct;

			}
		}
		return tripleCount;
	}

	private boolean isTriplet(int x, int r, int y) {
		return x*x + y*y == r*r;
	}

	@Test
	public void PythagoreanTriplet() {
		int result = pythagoreanTriplet(120);
		System.out.printf("pythagoreanTriplet(120) = %d%n", result);
		assertEquals("Incorrect product", 3, result);
	}
	
	@Test
	public void IntegerRightTriangles() {
		
	}

}
