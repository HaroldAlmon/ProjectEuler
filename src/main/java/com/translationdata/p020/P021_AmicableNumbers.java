package com.translationdata.p020;
/** Strategy: Brute Force */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import JUnitTests.FastTest;

@Category(FastTest.class)
public class P021_AmicableNumbers {
	Set<Integer> friends = new HashSet<>();
	
	@Test
	public void AmicableNumbers() {
		int friendsSum = amicableNumbers(10_000);
		System.out.printf("AmicableNumbers(10_000) = %s%n", friendsSum);
		assertEquals(31626, friendsSum);
	}

	public int amicableNumbers(int upperLimmit) {
		int sum = 0;
		int friend = 0;

		for (int number = 2; number < upperLimmit; number++) {
			if (friends.contains(number) == false) {
				friend = friendOfNumber(number);
				if (friend != 0 && friend != number) {
					sum = amicableNumbersSum(sum, friend, number);
				}
			}
		}
		return sum;
	}

	private int amicableNumbersSum(int amicableNumbersSum, int friend, int number) {
		final boolean isDebug = false;
		friends.add(friend);
		amicableNumbersSum += number + friend;
		if (isDebug) 
			System.out.printf("friend=(%d,%d)%n", number, friend);
		return amicableNumbersSum;
	}

	private int friendOfNumber(int number) {
		int friend = 0;
		int friendFactorsSum = 0;
		int potentialFriend;

		potentialFriend = factorsSum(number);
		friendFactorsSum = factorsSum(potentialFriend);
		if (number == friendFactorsSum ){
			friend = potentialFriend;
		}
		return friend;
	}

	private int factorsSum(int number) {
		int sum = 0;
		int[] factors = new ProperDivisors().properDivisors(number);
		for (int i = 0; i < factors.length; i++) {
			sum += factors[i];
		}
		return sum;
	}

	public static class ProperDivisors {
		public int[] properDivisors(int number) {
			int[] factors = new int[ number/2 + 1 ];
			int nextFreePosition = 1;
			factors[0] = 1;

			int limit = (int) (number/2);
			for (int divisor = 2; divisor <= limit; divisor++) {
				boolean isDivisor;
				
				isDivisor = number % divisor == 0;
				if ( isDivisor ) 
				{
					limit = (int) (number / divisor) - 1;
					addTwoDivisorsToArray(number, factors, nextFreePosition, divisor);
					nextFreePosition += divisor != number / divisor ? 2 : 1;
				}
			}
			return Arrays.copyOf(factors, nextFreePosition);
		}

		private void addTwoDivisorsToArray(int number, int[] factors, int nextFreePosition, int divisor) {
			factors[nextFreePosition] = divisor;
			if ( divisor != number / divisor ) 
				factors[nextFreePosition + 1] = number / divisor;
		}
	}
}


