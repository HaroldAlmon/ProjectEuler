package G03;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class P024_LexicographicPermutations {

	private String lexicographicPermutations(int noOfDigits) {
		final int secondLastChar = noOfDigits - 2;
		int[] digits = new int[noOfDigits];

		for (int i = 0; i < noOfDigits; i++) {
			digits[i] = i;
		}

		System.out.printf("%s%n", Arrays.toString(digits));
		int innerIndex = 0;
		int outerIndex = secondLastChar;

		while (outerIndex >= 0) {
			innerIndex = secondLastChar;
			while (innerIndex >= outerIndex) {
				int temp = 0;
				int posOfSmallestDigit;

				// if smaller digit on the right of p
				posOfSmallestDigit = smallestPosition(digits, innerIndex);

				if ( posOfSmallestDigit != Integer.MAX_VALUE) {
					// swap p and smallest digit to the right of p
					temp = digits[posOfSmallestDigit];
					digits[posOfSmallestDigit] = digits[innerIndex];
					digits[innerIndex] = temp;

					// sort digits to the right of p
					sortSubArray(digits, innerIndex+1);
					System.out.printf("String = %s%n", Arrays.toString(digits));
				}
				else
					innerIndex--;
			}
			outerIndex -= 1;
		}
		return "";
	}
	
	private void sortSubArray(int[] digits, int i) {
		int arrayLength = digits.length - i;
		int[] subArray = new int[arrayLength];
		System.arraycopy(digits, i, subArray, 0, arrayLength);
		Arrays.sort(subArray);
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
