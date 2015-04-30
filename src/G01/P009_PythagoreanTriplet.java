package G01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * Strategy: Brute Force.
 * Assume x + y + r = sum;
 * @author Harold Almon
 */
public class P009_PythagoreanTriplet {
	public int pythagoreanTriplet(int tripletSum) {
		int tripletProduct = enumerateAllXValues(tripletSum);
		return tripletProduct;
	}

	private int enumerateAllXValues(int tripletSum) {
		int tripletProduct = 0;
		int x;
		for (x = 3; x <= tripletSum - 2; x++) {
			tripletProduct = enumerateAllYValues(tripletSum, x);
			if (tripletProduct !=  0)
				break;
		}
		return tripletProduct;
		
	}
	private int enumerateAllYValues(int tripletSum, int x) {
		final boolean FALSE = false;
		int r;
		int tripletProduct;

		for (int y = x + 1; y <= tripletSum - 2; y++) {
			r = tripletSum - x - y;
			if ( isTriplet(x, r, y) ) {
				tripletProduct = x*y*r;
				if (FALSE)
					System.out.printf("Triplet (x, y, r) = (%d,%d,%d)%n", x,y,r);
				return tripletProduct;
			}
		}
		return 0;
	}

	private boolean isTriplet(int x, int r, int y) {
		return x*x + y*y == r*r;
	}

	@Test(timeout = 500)
	public void PythagoreanTriplet() {
		int result = pythagoreanTriplet(1000);
		System.out.printf("pythagoreanTriplet(1000) = %d%n", result);
		assertEquals("Incorrect product", 31875000, result);
	}
}
