package G03;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class P024_LexicographicPermutations {
	int[] digits;

	public String lexicographicPermutations(int noOfDigits, int targetPermNo, int startDigit) {
		boolean debug = false;
		digits = new int[noOfDigits];
		createDigitsInArray(noOfDigits, digits, startDigit);

		String permutation = digitsToPermutation( digits );
		if (debug)
			System.out.printf("Permutation = %s%n", permutation);
		
		int permCounter = 1;
		while (true) {
			//permutation = digitsToPermutation( digits );//DEBUG
			if (nextPermutation(digits) == false)
				break;

			permCounter += 1;
			
			if (debug) {
				permutation = digitsToPermutation(digits);
				System.out.printf("Permutation = %s%n", permutation);
			}
			
			if (permCounter == targetPermNo) {
				permutation = digitsToPermutation(digits);
				System.out.printf("Answer = %s%n", permutation);
				break;
			}
		}

		return permutation;
	}
	
	public boolean nextPermutation(int[] digits) {
		int ceilingPosition;
		int pivot = findPivot( digits );
		if ( pivot < 0 ) 
			return false;
		ceilingPosition = digitCeilingPosition(digits, pivot);
		swapDigits(digits, pivot, ceilingPosition);
		reverseDigitsOnRight(digits, pivot + 1);
		return true;
	}
	
	private int findPivot( int[] digits ) {
		for (int i = digits.length - 2; i >= 0 ; i--) {
			if (digits[ i ] < digits[ i + 1 ]) 
				return i;
		}
		return -1;
	}

	private void swapDigits(int[] digits, int leftIndex, int rightIndex) {
		int temp;
		temp = digits[rightIndex];
		digits[rightIndex] = digits[leftIndex];
		digits[leftIndex] = temp;
	}

	private void createDigitsInArray(int noOfDigits, int[] digits, int startDigit) {
		for (int i = 0; i < noOfDigits; i++) {
			digits[i] = startDigit;
			startDigit += 1;
		}
	}

	private String digitsToPermutation(int[] digits) {
		String permutation;
		permutation = Arrays.toString(digits);
		permutation = permutation.replaceAll(", ", "");
		permutation = permutation.substring(1, permutation.length() - 1);
		return permutation;
	}
	
	private void reverseDigitsOnRight(int[] digits, int leftPos) {
		int rightPos = digits.length - 1;
		for (; leftPos < rightPos; leftPos++, rightPos--) {
			swapDigits(digits, leftPos, rightPos);
		}
	}

	private int digitCeilingPosition(int[] digits, int startPosition) {
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
		permutation = lexicographicPermutations(10, 1_000_000, 0); 
		assertEquals("Permutation is not correct", "2783915460", permutation);
	}
}
