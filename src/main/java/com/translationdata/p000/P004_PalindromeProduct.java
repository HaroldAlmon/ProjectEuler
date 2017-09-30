package com.translationdata.p000;

/** Strategy: Brute Force. */
/* Note: Unit tests are in the JUnitTests package */
public class P004_PalindromeProduct {
	public int largestPalindromeProduct(final int numberLength) throws Exception {
	if (numberLength < 1) 
			throw new Exception("Number length must be greater than zero");
		int upperLimit = (int) Math.pow(10, numberLength) - 1;
		int largestProduct = 0;
	
		largestProduct = reverseEnumerateNum1(upperLimit, largestProduct);
		return largestProduct;
	}

	private int reverseEnumerateNum1(final int upperLimit, final int largestProduct) {
		int product = largestProduct;
		for (int num1 = upperLimit; num1 > upperLimit * 0.9  ; num1--) {
			product = reverseEnumerateNum2(upperLimit, product, num1);
		}
		return product;
	}

	private int reverseEnumerateNum2(final int upperLimit, final int inputProduct, final int num1) {
		int largestProduct = inputProduct;
		int product;
		for (int num2 = upperLimit; num2 > upperLimit * 0.9; num2--) {
			product = num1 * num2;
			if (isPalindrome(product) )
			{
				if (product > largestProduct) {
					largestProduct = product;
					break;
				}
			}
		}
		return largestProduct;
	}

	private boolean isPalindrome(final int n) {
		String number = Integer.toString(n);
		int left = 0;
		int right = number.length() - 1;
		for (; left < right; left++, right--) {
			if (number.charAt(left) != number.charAt(right)) 
				return false;
		}
		return true;
	}
}
