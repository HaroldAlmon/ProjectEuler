package G04;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Harold Almon
 * 1/29/2015
 *
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
		while(counter < 1_000_000) {
			String intStr = Integer.toString(counter);
			String binStr = Integer.toString(counter, 2);
			if (isPalindrome( intStr ) && isPalindrome( binStr ) ) {
				result += counter;
				//System.out.printf("Match for: %s and %s\n", intStr, binStr);
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
	public void CountPalindromesLessThanOneMillion() {
		long result = run();
		System.out.printf("Result = %d\n", result);
		assertEquals("Incorrect sum", 872187, result);
	}

}
