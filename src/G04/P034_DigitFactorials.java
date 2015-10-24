package G04;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P034_DigitFactorials {
	public int sum() {
		int sum = 0;
		List<Integer> factorial = new ArrayList<>(100);
		for(int i = 0; i <= 9; i += 1) {
			factorial.add(Integer.valueOf(factorial(i)));
		}
		
		System.out.printf("x = %d%n", factorial(4));
		
		for(int number = 10; number < 1000000; number +=1) {
			int factorialSum = 0;
			String s = String.valueOf(number);
			for(int i = 0; i < s.length(); i += 1) {
				factorialSum += factorial.get( (int) s.charAt(i) - 0x30 );
			}
			if(number == factorialSum) {
				System.out.printf("Match!!! sum %d! = %d%n", number, factorialSum);
				sum += number;
			}
		}
		return sum;
	}
	
	private int factorial(int n) {
		if(n == 1 || n == 0) {
			return 1;
		}
		return n * factorial( n - 1);
	}
	
	@Test
	public void runTest() {
		int sum = sum();
		System.out.printf("sum = %d%n", sum);
		assertEquals(sum, 40730);
	}
}
