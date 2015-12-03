package com.translationdata.p120;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
/** Strategy: Brute Force Enumeration, Dupe Filter */
public class P125_PalindromicSums {
	Set<Long> dupeFilter = new HashSet<>();
	boolean debug = false;
	public long pailindromeSum( int upperLimit ) {
		long palindromeSum = 0;
		int upperLimitRoot = (int) Math.floor( Math.sqrt( upperLimit ) );
		palindromeSum = enumerateStartBase(upperLimit, upperLimitRoot, palindromeSum);
		return palindromeSum;
	}

	private long enumerateStartBase(int upperLimit, int upperLimitRoot, long palindromeSum) {
		int startBase;
		for( startBase = 1; startBase <= upperLimitRoot; startBase += 1 ) {
			palindromeSum = enumerateCandidates(upperLimit, upperLimitRoot, startBase, palindromeSum);
		}
		return palindromeSum;
	}

	private long enumerateCandidates(int upperLimit, int upperLimitRoot, int startBase, long palindromeSum) {
		long candidate;
		candidate = 0;
		for ( int base = startBase; base <= upperLimitRoot; base += 1 ) {
			candidate += base * base;
			if ( isSquareOfSums(upperLimit, startBase, candidate) ) {
				if ( isDupe( candidate ) == false ) {
					if (debug) 
						System.out.printf("%d, startBase = %d, final base = %d%n", candidate, startBase, base);
					palindromeSum += candidate;
					dupeFilter.add(candidate);
				}
				else {
					if (debug) 
						System.out.printf("%d is a dupe, startBase = %d, final base = %d%n", candidate, startBase, base);
				}
			}
		}
		return palindromeSum;
	}

	private boolean isSquareOfSums(int upperLimit, int startBase, long candidate) {
		return isPalindrome( candidate ) && ( candidate !=  startBase*startBase ) && ( candidate < upperLimit );
	}
	
	private boolean isDupe(long number) {
		return dupeFilter.contains(number);
	}
	
	private boolean isPalindrome( long number ) {
		String candidate = Long.toString( number );
		for( int start = 0, end = candidate.length() - 1; start < end; start += 1, end -= 1 ) {
			if ( candidate.charAt(start) != candidate.charAt( end ) ) 
				return false;
		}
		return true;
	}

	@Test(timeout = 20_000)
	public void PalindromicSums() {
		long sumOfPalindromes = pailindromeSum( (int) Math.pow(10, 8) );
		System.out.printf( "Sum of Palindromes = %d%n", sumOfPalindromes );
		assertEquals(sumOfPalindromes, 2906969179L);
	} 	  	
}