package G03;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class P024_LexicographicPermutations {

	private String lexicographicPermutations(int noOfDigits) {
		int[] digits = new int[noOfDigits];
		for (int i = 0; i < noOfDigits; i++) {
			digits[i] = i;
		}
		System.out.printf("%s%n", Arrays.toString(digits));
		int innerIndex = 0;
		int outerIndex = noOfDigits - 2;
		while (outerIndex >= 0) {
			innerIndex = outerIndex;
			while (innerIndex >= 0) {
				int temp = 0;
				int posOfSmallestDigit;
				// if smaller digit on the right of p
				posOfSmallestDigit = smallestPosition(digits, innerIndex);
				if (digits[posOfSmallestDigit] != Integer.MAX_VALUE) {
					// swap p and smallest digit to the right of p
					temp = digits[posOfSmallestDigit];
					digits[posOfSmallestDigit] = digits[innerIndex];
					digits[innerIndex] = temp;
					// sort digits to the right of p
					System.out.printf("String = %s%n", Arrays.toString(digits));
					innerIndex = noOfDigits - 2;
					break;
				}
			}
			outerIndex -= 1;
		}
		return "";
	}
	
	private int smallestPosition(int[] digits, int startPosition) {
		int min = Integer.MAX_VALUE;
		int leftChar = digits[startPosition];
		int position;
		int result = min;

		for (position = startPosition + 1; position < digits.length; position++) {
			if(leftChar < digits[position] && digits[position] < min) {
				min = digits[position];
				result = position;
			}
		}

		return result;
	}
	
@Test
	public void Permutation() {
		String permutation;
		permutation = lexicographicPermutations(3); 
		//assertEquals("Permutation is not correct", "123", permutation);
	}
}
