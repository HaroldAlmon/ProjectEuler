package com.translationdata.p030;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** Strategy: Brute force */

public class P039_IntegerRightTriangles {
	final boolean isDebug = false;

	public int maximizedPerimeter( int upperLimit ) {
		int tripletCount = 0;
		int solution = 0;
		int maxTripletCount = 0;
		for ( int perimeter = 3+4+5; perimeter <= upperLimit; perimeter += 1 ) {
			tripletCount = pythagoreanTripletCount( perimeter );
			if ( tripletCount > maxTripletCount ) {
				solution = perimeter;
				maxTripletCount = tripletCount;
				if ( isDebug )
					System.out.printf( "Found new max perimiter: %d, count: %d%n", perimeter, tripletCount );
			}
		}
		return solution;
	}
	
	public int pythagoreanTripletCount( int perimeter ) {
		int tripletProduct = enumerateAllXValues( perimeter );
		return tripletProduct;
	}

	private int enumerateAllXValues( int perimeter ) {
		int tripletCount = 0;
		int x;
		for (x = 3; x <= perimeter - 2; x++) {
			tripletCount += enumerateAllYValues( perimeter, x );
		}
		return tripletCount;
	}

	private int enumerateAllYValues( int perimeter, int x ) {
		int r;
		int tripletProduct;
		int tripleCount = 0;

		for ( int y = x + 1; y <= perimeter - 2; y++ ) {
			r = perimeter - x - y;
			if ( isTriplet( x, r, y ) ) {
				tripleCount += 1;
				tripletProduct = x*y*r;
				if ( isDebug ) {
					System.out.printf( "Perimeter %d, Triplet (x, y, r) = (%d,%d,%d)%n", perimeter,x,y,r );
				}
			}
		}
		return tripleCount;
	}

	private boolean isTriplet( int x, int r, int y ) {
		return x*x + y*y == r*r;
	}

	@Test
	public void IntegerRightTriangles() {
		int maxPerimeter = 1_000;
		int result = maximizedPerimeter( maxPerimeter );
		System.out.printf( "maximizedPerimeter(%d) = %d%n", maxPerimeter, result );
		assertEquals( result, 840 );
	}
}
