package G03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P021_AmicableNumbers {
	Set<Integer> friends = new HashSet<>();
	public int getSum(int n) {
		int sum = 0;
		int friend = 0;
		for (int i = 2; i < n; i++) {
			if (!friends.contains(i)) {
				friend = getFriend(i);
				if (friend != 0 && friend != i) {
					// Add the friend to the set so we do not use it in the for-loop...
					friends.add(friend);
					sum += i + friend;
					System.out.printf("friend=(%d,%d)%n", i, friend);
				}
			}
		}
		return sum;
	}
	private int getFriend(int n) {
		int result = 0;
		int sum = 0;
		int friend;
		friend = getFactorsSum(n);
		sum = getFactorsSum(friend);
		if (n == sum ){
			result = friend;
		}
		return result;
	}
	
	private int getFactorsSum(int n) {
		int result = 0;
		int[] factors = getProperDivisors(n);
		for (int i = 0; i < factors.length; i++) {
			result += factors[i];
		}
		return result;
	}
	private int[] getProperDivisors(int n) {
		int [] factors = new int[5000];
		int nextFreePosition = 1;
		factors[0] = 1;
		
		int limit = (int) (n/2);
		for (int divisor = 2; divisor <= limit; divisor++) {
			if (n % divisor == 0) 
			{
				limit = (int) (n / divisor) - 1;
				factors[nextFreePosition] = divisor;
				factors[nextFreePosition + 1] = n / divisor;
				nextFreePosition += 2;
			}
		}
		return Arrays.copyOf(factors, nextFreePosition);
	}

	@Test
	public void test1() {
		System.out.printf("Result = %s%n", getSum(10000));
	}
}
