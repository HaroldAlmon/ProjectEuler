package G04;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author halmon
 * 1/29/2015
 *
 *Double-base palindromes


Problem 36


The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)

 */
public class P036_DoubleBasePalindromes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.printf("Total: %d\n", new P036_DoubleBasePalindromes().run());
	}
	
	long run() {
		long result = 0;
		int counter = 1;
		while(counter < 1000000) {
			String intStr = Integer.toString(counter);
			String binStr = Integer.toString(counter, 2);
			if (isPalindrome( intStr ) && isPalindrome( binStr ) ) {
				result += counter;
				System.out.printf("Match for: %s and %s\n", intStr, binStr);
			}
			counter += 1;
		}
		return result;
	}
	
	boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		for(; left < right; left++, right--) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test1() {
		long result = run();
		assertTrue(result == 872187);
	}

}
