package com.translationdata.p030;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P038_PandigitalMultiples {
	public int pandigitalMaximum() {
		int maximum = 0;
		//maximum = checkRange(maximum, 9, 9); // NOT NEEDED
		//maximum = checkRange(maximum, 91, 98); NOT POSSIBLE
		//maximum = checkRange(maximum, 912, 987); NOT POSSIBLE
		maximum = enumerateBase(maximum, 9134, 9876);
		//maximum = checkRange(maximum, 1, 9_999);
		return maximum;
	}
	
	private int enumerateBase(int maximum, int lower, int upper) {
		for (int base = lower; base <= upper; base += 1) {
			String candidate = "";
			maximum = enumerateMutiplier(candidate, base, maximum);
		}
		return maximum;
	}

	private int enumerateMutiplier(String candidate, int base, int maximum) {
		for (int multiplier = 1; multiplier <= 9 && candidate.length() <= 9; multiplier += 1) {
			candidate += Integer.toString(base * multiplier);
			if (candidate.length() == 9) {
				if ( isPandigital(candidate) ) {
					//System.out.printf("base = %d, found %s%n", base, candidate);
					maximum = Math.max(maximum, Integer.parseInt(candidate));
				}
				break;
			}
		}
		return maximum;
	}
	 
	private boolean isPandigital(String digits) {
		if ( digits.contains("0") )
			return false;

		Set<Character> dupeFilter = new HashSet<>();
		for (int i = 0; i < digits.length(); i += 1) {
			if ( dupeFilter.add(digits.charAt(i)) == false ) {
				return false;
			}
		}
	   	return true;
	 }
	
	@Test
	public void PandigitalMultiples() {
		int pandigitalMaximum = 0;
		pandigitalMaximum = pandigitalMaximum();
		System.out.printf("Maximum pandigital number is %d%n", pandigitalMaximum);
		assertEquals(pandigitalMaximum, 932718654);
	}
}
