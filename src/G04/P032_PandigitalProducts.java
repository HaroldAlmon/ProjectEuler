package G04;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import G03.P024_LexicographicPermutations;

import org.junit.Test;

public class P032_PandigitalProducts {
	public int sumOfProducts() {
		Set<Integer> filter = new HashSet<Integer>();
		int productSum = 0;
		
		P024_LexicographicPermutations permutation = new P024_LexicographicPermutations();
		int noOfDigits = 9;
		int startDigit = 1;
		int[] digits = new int[noOfDigits];
		int [] last = new int[] {9,8,7,6,5,4,3,2,1};
		createDigitsInArray(noOfDigits, digits, startDigit);
		
		while ( true ) {
			int multiplicand ;
			int multiplier ;
			int product ;

			if ( isLastPermutation(digits, last)) {
				break;
			};

			multiplicand = charArrayToInt(digits, 0, 1);
			multiplier = charArrayToInt(digits, 2, 4);
			product = charArrayToInt(digits, 5, 8);
			
			productSum = ifPandigitalAddToSum(filter, productSum, multiplicand,	multiplier, product);
			
			multiplicand = charArrayToInt(digits, 0, 0);
			multiplier = charArrayToInt(digits, 1, 4);
			product = charArrayToInt(digits, 5, 8);
			
			productSum = ifPandigitalAddToSum(filter, productSum, multiplicand,	multiplier, product);
			
			permutation.nextPermutation(digits);
		}
		return productSum;
	}

	private boolean isLastPermutation(int[] digits, int[] last) {
		return Arrays.equals( digits , last);
	}

	private int ifPandigitalAddToSum(Set<Integer> filter, int productSum,
			int multiplicand, int multiplier, int product) {
		if (multiplicand * multiplier == product) {
			if( filter.add(product)) {
				productSum += product;
				//System.out.printf("%d * %d = %d%n", multiplicand, multiplier, product);
			} else {
				//System.out.printf("Duplicate product not added to sum: %d%n", product);
			};;
		}
		return productSum;
	}

	private void createDigitsInArray(int noOfDigits, int[] digits, int startDigit) {
		for (int i = 0; i < noOfDigits; i++) {
			digits[i] = startDigit;
			startDigit += 1;
		}
	}
	
	int charArrayToInt(int []data,int start,int end)
	{
	    int result = 0;
	    for (int i = start; i <= end; i++)
	    {
	        int digit = (int) data[i];
	        result *= 10;
	        result += digit;
	    }
	    return result;
	}

	@Test
	public void SumOfProducts() {
		int sum = sumOfProducts();
		System.out.printf("Pandigital Sum = %d", sumOfProducts());
		assertEquals(sum, 45228);
	}
}
