package com.translationdata.p090;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P092_SquareDigitChains {
	public int squareDigitChanges(int number) {
		int result = 0;
		
		for (int i = 1; i < number; i++) {
			if (is89loop(i))
				result += 1;
		}
		return result;
	}
	
	private boolean is89loop (int number ) {
		int total = 0;
		int digit = 0;
		
		String s = Integer.toString((number));
		
		total = number;
		while (total != 1 ) {
			s = Integer.toString((total));
			total = 0;
			for (int i = 0; i < s.length(); i++) {
				//digit = Integer.parseInt(s.substring(i, i + 1)); // Slow, extracts a String
				//digit = Character.getNumericValue(s.charAt(i)); // Faster, extracts a character and uses wrapper class function
				digit = (int) s.charAt(i) & 0x0000_000F; // Fastest, extracts a character and uses bitwise AND
				total += digit * digit;
			}
			if (is89cycle(total))
			{
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("serial")
	private static Set<Integer> loopNums = new HashSet<Integer>() {
		{
			add(89);
			add(145);
			add(42);
			add(20);
			add(4);
			add(16);
			add(37);
			add(58);
		}
	};
	
	private boolean is89cycle(int number) {
		return loopNums.contains(number);
	}
	
	@Test(timeout = 10_000)
	public void SquareDigitChanges() {
		int result = squareDigitChanges( 10_000_000 );
		System.out.printf("squareDigitChanges( 10_000_000 ) = %d%n", result);
		assertEquals( result, 8581146 );
	}
}
