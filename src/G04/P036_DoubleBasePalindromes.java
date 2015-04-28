package G04;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Strategy: Brute Force
 * @author Harold Almon
 * 1/29/2015
 *
 */
public class P036_DoubleBasePalindromes {

	/**
	 * @author Harold Almon
	 * @param None
	 */
	long doubleBasePalindromes(int upperLimit) {
		final boolean FALSE = false;
		long result = 0;
		int palindromeCandidate = 1;
		while(palindromeCandidate < upperLimit) {
			String intString = Integer.toString(palindromeCandidate);
			String binaryString = Integer.toString(palindromeCandidate, 2);
			if (isPalindrome( intString ) && isPalindrome( binaryString ) ) {
				result += palindromeCandidate;
				if(FALSE) 
					System.out.printf("Match for: %s and %s%n", intString, binaryString);
			}
			palindromeCandidate += 1;
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

	@Test(timeout = 2_000)
	public void CountPalindromesLessThanOneMillion() {
		long sum = doubleBasePalindromes(1_000_000);
		System.out.printf("doubleBasePalindromes(1_000_000) = %d%n", sum);
		assertEquals("Incorrect sum", 872187, sum);
	}

}
