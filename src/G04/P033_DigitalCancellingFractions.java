package G04;

import org.junit.Test;

public class P033_DigitalCancellingFractions {
	private final int top = 0;
	private final int bottom = 1;

	public int sum() {
		int[] fraction = null;
		int[] product = new int[] {1,1};
		for(int leftDigit = 1; leftDigit <= 9; leftDigit += 1){
			for(int rightDigit = 1; rightDigit <= 9; rightDigit += 1) {
				int numerator;
				
				numerator = leftDigit * 10 + rightDigit;
				fraction = testFraction( leftDigit, rightDigit, numerator );
				if ( fraction[bottom] != 1 ) {
					//System.out.printf("fraction = %d / %d%n", fraction[top], fraction[bottom]);
					product[top] *= fraction[top];
					product[bottom] *= fraction[bottom];
					//System.out.printf("product = %d / %d%n", product[top], product[bottom]);
				}
			}
		}

		while (product[top] % 2 == 0 && product[bottom] % 2 == 0 ) {
			product[top] /= 2;
			product[bottom] /= 2;
		}
		
		return product[bottom];
	}

	private int[] testFraction(int leftDigit, int rightDigit, int numerator) {
		int[] fraction = new int[] {1,1};

		for(int thirdDigit = 1; thirdDigit <= 9; thirdDigit += 1) {
			int denominator;

			
/*			denominator = enumerateLeftDigit( leftDigit, thirdDigit );
			if (numerator / denominator < 1 ) {
				if ( (double) numerator / denominator == (double) rightDigit / thirdDigit ) {
					System.out.printf("Match %d / %d  = %d /  %d%n", numerator, denominator, rightDigit, leftDigit);
				}
			}*/
			
			denominator = enumerateRightDigit( rightDigit, thirdDigit );
			if (numerator / denominator < 1 ) {
				if ( isDigitalCancellingFraction(leftDigit, numerator, thirdDigit, denominator) ) {
					System.out.printf("Match %d / %d  = %d /  %d%n", numerator, denominator, leftDigit, thirdDigit);
					fraction[top] *= leftDigit;
					fraction[bottom] *= thirdDigit;
				}
			}
		}
		return fraction;
	}

	private boolean isDigitalCancellingFraction(int leftDigit, int numerator, int thirdDigit, int denominator) {
		return (double) numerator / denominator == (double) leftDigit / thirdDigit;
	}


	private int enumerateRightDigit(int rightDigit, int thirdDigit) {
		return rightDigit * 10 + thirdDigit;
	}

/*	private int enumerateLeftDigit(int leftDigit, int thirdDigit) {
		return thirdDigit * 10 + leftDigit;
	}*/
	
	@Test
	public void DigitalCancellingFractions() {
		int denominator = sum();
		System.out.printf("prodcut = %d%n", denominator);
	}
}
