package com.translationdata.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum ProperDivisors {
	INSTANCE;

	public Set<Integer> properDivisorsSet(int number) {
		Set<Integer> factors = new HashSet<>();
		factors.add( Integer.valueOf(1) );

		int limit = (int) (number/2);
		for (int divisor = 2; divisor <= limit; divisor++) {
			boolean isDivisor;
			
			isDivisor = number % divisor == 0;
			if ( isDivisor ) 
			{
				limit = (int) (number / divisor) - 1;
				addTwoDivisorsToSet(number, factors, divisor);
			}
		}
		return factors;
	}

	private void addTwoDivisorsToSet(int number, Set<Integer> factors, int divisor) {
		factors.add( Integer.valueOf( divisor ) );
		if ( isSquareRoot(number, divisor) == false ) 
			factors.add( Integer.valueOf( number / divisor ) );
	}

	private boolean isSquareRoot(int number, int divisor) {
		return divisor == number / divisor;
	}
	
	private Map< Integer, Set<Integer>> divisors = new HashMap<Integer, Set<Integer>>();
	public Set<Integer> properDivisorsMemo(int number) {
		if (!divisors.containsKey(number)) {
			divisors.put( number, properDivisorsSet(number));
		}
//		else
//			if( debug) System.out.printf("Returned memo for %d%n", number);
		return divisors.get(number);
	}
	
}