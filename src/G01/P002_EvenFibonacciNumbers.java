package G01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/** Strategy: Simple mathematics. */
public class P002_EvenFibonacciNumbers {
	int sumOfEvenFibonacciNumbersBelow(int upperLimit) {
		int sumOfEvenFibonacciNumbers = 2;
		int fibo1 = 1;
		int fibo2 = 2;
		int nextFibo = 3;
		/* Use a loop since we do not know the term
		 * of the Fibonacci number we are seeking. */
		while (nextFibo < upperLimit) {
			if( isEven(nextFibo) ) {
				sumOfEvenFibonacciNumbers += nextFibo;				
			}
			fibo1 = fibo2;
			fibo2 = nextFibo;
			nextFibo = fibo1 + fibo2;
		}
		return sumOfEvenFibonacciNumbers;
	}
	
	private boolean isEven(int n) {
		return n % 2 == 0;
	}

	@Test(timeout=500)
	public void SumOfEvenTermsLessThanFourMillion() {
		int result = sumOfEvenFibonacciNumbersBelow(4_000_000);
		System.out.printf("sumOfEvenFibonacciNumbersBelow(4_000_000)=%s%n", result);
		assertEquals( "Incorrect sum of even Fibonacci numbers that do not exceed 4 million", 4613732, result );
	}
}
