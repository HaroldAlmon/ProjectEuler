package com.translationdata.p030;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P034_DigitFactorials {
	public int digitFactorials() {
		int totalFactorialSum = 0;
		List<Integer> factorial = new ArrayList<>( 100 );
		memoizeFactorials(factorial);
		
		for( int candidate = 10; candidate < 1_000_000; candidate +=1 ) {
			int factorialSum = 0;
			String digits = String.valueOf( candidate );
			
			factorialSum = factorialSum( factorial, factorialSum, digits );
			
			if( candidate == factorialSum ) {
				System.out.printf( "factorialSum( %d ) = %d%n", candidate, factorialSum );
				totalFactorialSum += candidate;
			}
		}
		return totalFactorialSum;
	}

	private int factorialSum(List<Integer> factorial, int factorialSum,	String digits) {
		for( int position = 0; position < digits.length(); position += 1 ) {
			factorialSum += factorial.get( (int) digits.charAt(position) - 0x30 );
		}
		return factorialSum;
	}

	private void memoizeFactorials(List<Integer> factorial) {
		for( int i = 0; i <= 9; i += 1 ) {
			factorial.add( Integer.valueOf( factorial( i ) ) );
		}
	}
	
	private int factorial( int n ) {
		if( n == 1 || n == 0 ) {
			return 1;
		}
		return n * factorial( n - 1 );
	}
	
	@Test
	public void runTest() {
		int sum = digitFactorials();
		System.out.printf( "%nDigital Factorial Sum = %d%n", sum );
		assertEquals( sum, 40730 );
	}
}
