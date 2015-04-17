package G01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * Strategy: Brute force. Simple mathematics.
 * Use a loop since we do not know the term
 * of the Fibonacci number we are seeking. 
 * @author Harold Almon
 *
 */
public class P002_EvenFibonacciNumbers {
	long sumOfEvenFibonacciNumbers(int upperLimit) {
		long sumOfEvenFibonacciNumbers = 2;
		int fibo1 = 1;
		int fibo2 = 2;
		int nextFibo = 3;
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
	public void LessThanFourMillion() {
		assertEquals( "Incorrect sum", 4613732, sumOfEvenFibonacciNumbers(4_000_000) );
	}
}
