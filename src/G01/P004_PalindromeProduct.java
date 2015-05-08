package G01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
/** Strategy: Brute Force. */
public class P004_PalindromeProduct {
	@Test(timeout=500)
	public void LargestPalindromeProductOfTwo3DigitNumbers() throws Exception {
		int palindromeProduct = largestPalindromeProduct(3);
		System.out.printf("largestPalindromeProduct(3) = %d%n", palindromeProduct);
		assertEquals("Incorrect palindrome product of two 3-digit numbers", 906609, palindromeProduct);
	}
	
	@Test(timeout=16_000)
	public void LargestPalindromeProd4DigitNums() throws Exception {
		int result = largestPalindromeProduct(4);
		System.out.printf("largestPalindromeProduct(4) = %d%n", result);
		assertEquals("Incorrect palindrome product of two 4-digit numbers", 99000099, result);
	}
	
	
	@Test(timeout=100, expected=Exception.class)
	public void LengthLessThan1ThrowsException() throws Exception {
		int result = largestPalindromeProduct(-1);
		System.out.printf("largestPalindromeProduct = %d%n", result);
		fail("Should not reach this position because the bad input should have caused an exception.");
		assertEquals("Should not reach this position because the bad input should have caused an exception.", 0, result);
	}

	public int largestPalindromeProduct(int numberLength) throws Exception {
	if (numberLength < 1) 
			throw new Exception("Number length must be greater than zero");
		int upperLimit = (int) Math.pow(10, numberLength) - 1;
		int largestProduct = 0;
	
		largestProduct = reverseEnumerateNum1(upperLimit, largestProduct);
		return largestProduct;
	}

	private int reverseEnumerateNum1(int upperLimit, int largestProduct) {
		for (int num1 = upperLimit; num1 > upperLimit/10  ; num1--) {
			largestProduct = reverseEnumerateNum2(upperLimit, largestProduct, num1);
		}
		return largestProduct;
	}

	private int reverseEnumerateNum2(int upperLimit, int largestProduct, int num1) {
		int product;
		for (int num2 = upperLimit; num2 > upperLimit/10; num2--) {
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

	private boolean isPalindrome(int n) {
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
