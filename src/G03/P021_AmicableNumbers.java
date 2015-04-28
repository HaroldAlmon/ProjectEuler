package G03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P021_AmicableNumbers {
	Set<Integer> friends = new HashSet<>();

	public int amicableNumbers(int upperLimmit) {
		int sum = 0;
		int friend = 0;

		for (int number = 2; number < upperLimmit; number++) {
			if (!friends.contains(number)) {
				friend = getFriend(number);
				if (friend != 0 && friend != number) {
					sum = addNumberAndFriendToSum(sum, friend, number);
				}
			}
		}
		return sum;
	}
	private int addNumberAndFriendToSum(int sumOfAmicableNumbers, int friend, int number) {
		final boolean FALSE = false;
		friends.add(friend);
		sumOfAmicableNumbers += number + friend;
		if (FALSE) 
			System.out.printf("friend=(%d,%d)%n", number, friend);
		return sumOfAmicableNumbers;
	}
	private int getFriend(int number) {
		int friend = 0;
		int sumOfFriendFactors = 0;
		int potentialFriend;

		potentialFriend = sumOFactors(number);
		sumOfFriendFactors = sumOFactors(potentialFriend);
		if (number == sumOfFriendFactors ){
			friend = potentialFriend;
		}
		return friend;
	}

	private int sumOFactors(int number) {
		int sum = 0;
		int[] factors = getProperDivisors(number);
		for (int i = 0; i < factors.length; i++) {
			sum += factors[i];
		}
		return sum;
	}
	private int[] getProperDivisors(int number) {
		int [] factors = new int[5000];
		int nextFreePosition = 1;
		factors[0] = 1;
		
		int limit = (int) (number/2);
		for (int divisor = 2; divisor <= limit; divisor++) {
			if (number % divisor == 0) 
			{
				limit = (int) (number / divisor) - 1;
				addTwoDivisorsToArray(number, factors, nextFreePosition, divisor);
				nextFreePosition += 2;
			}
		}
		return Arrays.copyOf(factors, nextFreePosition);
	}
	private void addTwoDivisorsToArray(int number, int[] factors, int nextFreePosition, int divisor) {
		factors[nextFreePosition] = divisor;
		factors[nextFreePosition + 1] = number / divisor;
	}
	
	@Test(timeout = 500)
	public void amicableNumbers() {
		System.out.printf("AmicableNumbers(10_000) = %s%n", amicableNumbers(10_000));
	}
}
