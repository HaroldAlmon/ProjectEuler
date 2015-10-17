package G04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class P039_IntegerRightTriangles {
	public int maximizedPerimeter(int upperLimit) {
		int tripletCount = 0;
		int maxTripletCount = 0;
		int solution = 0;
		for (int perimeter = 3+4+5; perimeter <= upperLimit; perimeter += 1) {
			tripletCount = pythagoreanTripletCount( perimeter );
			if ( tripletCount > maxTripletCount ) {
				solution = perimeter;
				maxTripletCount = tripletCount;
			}
		}
		return solution;
	}
	
	public int pythagoreanTripletCount(int tripletSum) {
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
		final boolean isDebug = false;
		int r;
		int tripletProduct;
		int tripleCount = 0;

		for (int y = x + 1; y <= tripletSum - 2; y++) {
			r = tripletSum - x - y;
			if ( isTriplet(x, r, y) ) {
				tripleCount += 1;
				tripletProduct = x*y*r;
				if (isDebug) {
					System.out.printf("Perimeter %d, Triplet (x, y, r) = (%d,%d,%d)%n", tripletSum,x,y,r);
				}
			}
		}
		return tripleCount;
	}

	private boolean isTriplet(int x, int r, int y) {
		return x*x + y*y == r*r;
	}

	@Test
	public void IntegerRightTriangles() {
		//int result = pythagoreanTripletCount(120);
		//System.out.printf("pythagoreanTriplet(120) = %d%n", result);
		//assertEquals("Incorrect product", 3, result);
		
		int maxPerimeter = 1_000;
		int result = maximizedPerimeter(maxPerimeter);
		System.out.printf("maximizedPerimeter(%d) = %d%n", maxPerimeter, result);
		//assertEquals("Incorrect product", 3, result);
	}
	
	@Test
	public void IntegerRightTriangle2() {
		
	}

}
