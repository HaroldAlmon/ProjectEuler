package com.translationdata.p030;

import static org.junit.Assert.*;

import org.junit.Test;

/** Strategy: Brute Force */
public class P036_DoubleBasePalindromes {
	public long doubleBasePalindromes(int upperLimit) {

		long palindromesSum = 0;
		int palindromeCandidate = 1;
		while(palindromeCandidate < upperLimit) {
			String intString = Integer.toString(palindromeCandidate);
			String binaryString = Integer.toString(palindromeCandidate, 2);
			palindromesSum = addToSumIfPalindrome(palindromesSum, palindromeCandidate, intString, binaryString);
			palindromeCandidate += 1;
		}
		return palindromesSum;
	}

	private long addToSumIfPalindrome(long sumOfPalindromes, int palindromeCandidate, String intString,
			String binaryString) {
		final boolean isDebug = false;
		if (isPalindrome( intString ) && isPalindrome( binaryString ) ) {
			sumOfPalindromes += palindromeCandidate;
			if(isDebug) 
				System.out.printf("Match for: %s and %s%n", intString, binaryString);
		}
		return sumOfPalindromes;
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
