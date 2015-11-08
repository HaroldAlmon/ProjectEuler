package G13;

import org.junit.Test;
/** Strategy: Brute Force enumeration */
public class P125_PalindromicSums {
	public int sum(int upperLimit) {
		int sum = 0;
		int candidate;
		for (candidate = 1; candidate < upperLimit; candidate += 1) {
		if ( isPalindrome(candidate) )
			if ( isSumOfSquares(candidate) )
				sum += candidate;
		}
		return sum;
	}
	
	private boolean isSumOfSquares(int candidate) {
		//System.out.printf("candidate = %d%n", candidate);
		for(int startBase = 1; startBase <= Math.floor( Math.sqrt(candidate)); startBase += 1) {
			int squareSum;
			squareSum = 0;
			for ( int base = startBase; base <= Math.floor( Math.sqrt(candidate) ); base += 1 ) {
				squareSum += base * base;
				if (squareSum == candidate && candidate !=  startBase*startBase) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isPalindrome(int number) {
		String candidate = Integer.toString(number);
		for(int i = 0, j = candidate.length() - 1; i < j; i += 1, j -= 1) {
			if (candidate.charAt(i) != candidate.charAt(j)) 
				return false;
		}
		return true;
	}

	@Test
	public void PalindromicSums() {
		System.out.printf( "Sum of Palindromes = %d%n", sum(10_000_000) );
	}
}

