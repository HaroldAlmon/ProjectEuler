package com.translationdata.p030;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** Strategy; Brute Force. 
 * There are two fractions to check:
 * 1. The original two digit fraction and
 * 2. The single digit cancelled fraction */

public class P033_DigitalCancellingFractions {
	private final int TOP = 0;
	private final int BOTTOM = 1;
	private final int NO_SOLUTION = 1;

	public int productOfFractions() {
		int[] fraction = null;
		int[] product = new int[] { 1, 1 };
		for( int numeratorLeftDigit = 1; numeratorLeftDigit <= 9; numeratorLeftDigit += 1 ) {
			for( int numeratorRightDigit = 1; numeratorRightDigit <= 9; numeratorRightDigit += 1 ) {
				int numerator;
				
				numerator = numeratorLeftDigit * 10 + numeratorRightDigit;
				fraction = curiousFraction( numerator, numeratorLeftDigit, numeratorRightDigit );
				if ( isSolution( fraction ) ) {
					//System.out.printf("fraction = %d / %d%n", fraction[top], fraction[bottom]);
					product = includeFractionInProduct(product, fraction);
					//System.out.printf("product = %d / %d%n", product[top], product[bottom]);
				}
			}
		}

		while ( isDivisibleByTwo( product ) ) {
			product[TOP] /= 2;
			product[BOTTOM] /= 2;
		}
		
		return product[BOTTOM];
	}
	
	private int[] curiousFraction( int numerator, int cancelledNumerator, int numeratorRightDigit ) {
		int[] fraction = new int[] {1, NO_SOLUTION};

		for( int cancelledDenominator = 1; cancelledDenominator <= 9; cancelledDenominator += 1 ) {
			int denominator;

			denominator = numeratorRightDigit * 10 + cancelledDenominator;
			if (numerator / denominator < 1 ) {
				if ( isCuriousFraction(numerator, denominator, cancelledNumerator, cancelledDenominator) ) {
					System.out.printf( "Match %d / %d  = %d /  %d%n", numerator, denominator, cancelledNumerator, cancelledDenominator );
					fraction[ TOP ] *= cancelledNumerator;
					fraction[ BOTTOM ] *= cancelledDenominator;
				}
			}
		}
		return fraction;
	}

	private int[] includeFractionInProduct(int[] product, int[] fraction) {
		product[TOP] *= fraction[TOP];
		product[BOTTOM] *= fraction[BOTTOM];
		return product;
	}

	private boolean isDivisibleByTwo(int[] product) {
		return product[TOP] % 2 == 0 && product[BOTTOM] % 2 == 0;
	}

	private boolean isSolution( int[] fraction ) {
		return fraction[BOTTOM] != NO_SOLUTION;
	}

	private boolean isCuriousFraction(int numerator, int denominator, int cancelledNumerator, int cancelledDenominator) {
		return (double) numerator / denominator == (double) cancelledNumerator / cancelledDenominator;
	}

	@Test
	public void DigitalCancellingFractions() {
		int denominator = productOfFractions();
		System.out.printf("prodcut = %d%n", denominator);
		assertEquals( denominator, 100);
	}
}
