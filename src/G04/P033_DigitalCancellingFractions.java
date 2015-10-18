package G04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class P033_DigitalCancellingFractions {
	private final int top = 0;
	private final int bottom = 1;

	public int productOfFractions() {
		int[] fraction = null;
		int[] product = new int[] {1,1};
		for(int numeratorLeftDigit = 1; numeratorLeftDigit <= 9; numeratorLeftDigit += 1){
			for(int numeratorRightDigit = 1; numeratorRightDigit <= 9; numeratorRightDigit += 1) {
				int numerator;
				
				numerator = numeratorLeftDigit * 10 + numeratorRightDigit;
				fraction = testFraction( numerator, numeratorRightDigit, numeratorLeftDigit );
				if ( isSolution( fraction ) ) {
					//System.out.printf("fraction = %d / %d%n", fraction[top], fraction[bottom]);
					product[top] *= fraction[top];
					product[bottom] *= fraction[bottom];
					//System.out.printf("product = %d / %d%n", product[top], product[bottom]);
				}
			}
		}

		while ( isDivisibleByTwo( product ) ) {
			product[top] /= 2;
			product[bottom] /= 2;
		}
		
		return product[bottom];
	}

	private boolean isDivisibleByTwo(int[] product) {
		return product[top] % 2 == 0 && product[bottom] % 2 == 0;
	}

	private boolean isSolution(int[] fraction) {
		return fraction[bottom] != 1;
	}

	private int[] testFraction(int numerator, int numeratorRightDigit, int cancelledNumerator ) {
		int[] fraction = new int[] {1,1};

		for(int cancelledDenominator = 1; cancelledDenominator <= 9; cancelledDenominator += 1) {
			int denominator;

			denominator = enumerateRightDigit( numeratorRightDigit, cancelledDenominator );
			if (numerator / denominator < 1 ) {
				if ( (double) numerator / denominator == (double) cancelledNumerator / cancelledDenominator ) {
					System.out.printf("Match %d / %d  = %d /  %d%n", numerator, denominator, cancelledNumerator, cancelledDenominator);
					fraction[top] *= cancelledNumerator;
					fraction[bottom] *= cancelledDenominator;
				}
			}
		}
		return fraction;
	}

	private int enumerateRightDigit(int rightDigit, int thirdDigit) {
		return rightDigit * 10 + thirdDigit;
	}

	@Test
	public void DigitalCancellingFractions() {
		int denominator = productOfFractions();
		System.out.printf("prodcut = %d%n", denominator);
		assertEquals( denominator, 100);
	}
}
