package G04;

import org.junit.Test;

public class P033_DigitalCancellingFractions {
	public int sum() {
		for(int leftDigit = 1; leftDigit <= 9; leftDigit += 1){
			for(int rightDigit = 1; rightDigit <= 9; rightDigit += 1) {
				int numerator;
				
				numerator = leftDigit * 10 + rightDigit;
				makeDenomiator( leftDigit, rightDigit, numerator );
			}
		}
		// TODO Reduce product
		// TODO Return product
		
		return 1;
	}

	private void makeDenomiator(int leftDigit, int rightDigit, int numerator) {
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
				if ( (double) numerator / denominator == (double) leftDigit / thirdDigit ) {
					System.out.printf("Match %d / %d  = %d /  %d%n", numerator, denominator, leftDigit, thirdDigit);
				}
			}
			// TODO: Calculate and return product
		}
	}


	private int enumerateRightDigit(int rightDigit, int thirdDigit) {
		return rightDigit * 10 + thirdDigit;
	}

/*	private int enumerateLeftDigit(int leftDigit, int thirdDigit) {
		return thirdDigit * 10 + leftDigit;
	}*/
	
	@Test
	public void DigitalCancellingFractions() {
		sum();
	}
}
