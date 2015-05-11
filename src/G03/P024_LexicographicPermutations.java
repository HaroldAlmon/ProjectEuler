package G03;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class P024_LexicographicPermutations {
	private String lexicographicPermutations(int noOfDigits) {
		String permutation = "";
		int permutationCounter = 1;
		final int secondLastChar = noOfDigits - 2;
		int[] digits = new int[noOfDigits];
		int digitIndex = 0;

		createDigitsInArray(noOfDigits, digits);

		digitIndex = secondLastChar;
		while (digitIndex >= 0) {
			int temp = 0;
			int posOfSmallestDigit;

			posOfSmallestDigit = smallestPosition(digits, digitIndex);

			if (posOfSmallestDigit != Integer.MAX_VALUE) {
				temp = digits[posOfSmallestDigit];
				digits[posOfSmallestDigit] = digits[digitIndex];
				digits[digitIndex] = temp;

				sortDigitsOnRight(digits, digitIndex + 1);
				digitIndex = secondLastChar;
				permutationCounter += 1;
				if (permutationCounter == 1_000_000) {
					permutation = digitsToPermutation(digits);
					System.out.printf("Permutation = %s%n", permutation);
					break;
				}
			} else
				digitIndex -= 1;
		}

		return permutation;
	}

	private void createDigitsInArray(int noOfDigits, int[] digits) {
		for (int i = 0; i < noOfDigits; i++) {
			digits[i] = i;
		}
	}

	private String digitsToPermutation(int[] digits) {
		String permutation;
		permutation = Arrays.toString(digits);
		permutation = permutation.replaceAll(", ", "");
		permutation = permutation.substring(1, permutation.length() - 1);
		return permutation;
	}
	
	private void sortDigitsOnRight(int[] digits, int i) {
		int arrayLength = digits.length - i;
		int[] subArray = new int[arrayLength];
		System.arraycopy(digits, i, subArray, 0, arrayLength);
		Arrays.sort(subArray);
		System.arraycopy(subArray, 0, digits, i, arrayLength);
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
		permutation = lexicographicPermutations(10); 
		assertEquals("Permutation is not correct", "2783915460", permutation);
	}
}
