package G01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * Strategy: Brute force.
 * @author Harold Almon
 */
public class P004_PalindromeProduct {
	@Test(timeout=500)
	public void PalindromeProduct() {
		int result = largestPalindromeProduct(3);
		assertEquals("Incorrect product", result, 906609);
		System.out.printf("Result = %d%n", result);
	}

	private int largestPalindromeProduct(int numLen) {
		int upperLimit = (int) Math.pow(10, numLen) - 1;
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

	private int reverseEnumerateNum2(int upperLimit, int largestProduct,
			int num1) {
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
