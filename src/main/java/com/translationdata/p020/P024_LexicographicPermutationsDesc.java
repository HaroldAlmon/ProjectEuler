package com.translationdata.p020;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
public class P024_LexicographicPermutationsDesc {
	int[] digits;

	public boolean nextPermutation(int[] digits) {
		int floorPosition;
		int pivot = findPivot( digits );
		if ( pivot < 0 ) 
			return false;
		floorPosition = floorPosition(digits, pivot);
		swapDigits(digits, pivot, floorPosition);
		reverseDigitsOnRight(digits, pivot + 1);
		return true;
	}
	
	private int findPivot( int[] digits ) {
		for (int i = digits.length - 2; i >= 0 ; i--) {
			if (digits[ i ] > digits[ i + 1 ]) 
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

	private int floorPosition(int[] digits, int startPosition) {
		int max = Integer.MIN_VALUE;
		int leftChar = digits[startPosition];
		int position;
		int result = max;

		for (position = startPosition + 1; position < digits.length; position++) {
			if(leftChar > digits[position] && digits[position] > max) {
				max = digits[position];
				result = position;
			}
		}

		return result;
	}
	
	@Test
	// TODO: Fix
	public void Permutation() {
		int[] digits = { 3, 2, 1 };
		nextPermutation( digits );
		String permutation = Arrays.toString(digits);
		System.out.printf("Previous permutation %s", permutation);
		assertEquals(permutation, "[3, 1, 2]");
	}
}
