package G01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/** Strategy: Simple mathematics. */
public class P002_EvenFibonacciNumbers {
	int EvenFiboNumbersSum(int upperLimit) {
		int EvenFiboNumbersSum = 2;
		int fibo1 = 1;
		int fibo2 = 2;
		int nextFibo = 3;
		/* Use a loop since we do not know the term
		 * of the Fibonacci number we are seeking. */
		while (nextFibo < upperLimit) {
			if( isEven(nextFibo) ) {
				EvenFiboNumbersSum += nextFibo;				
			}
			fibo1 = fibo2;
			fibo2 = nextFibo;
			nextFibo = fibo1 + fibo2;
		}
		return EvenFiboNumbersSum;
	}
	
	private boolean isEven(int n) {
		return n % 2 == 0;
	}

	@Test(timeout=500)
	public void SumOfEvenTermsLessThanFourMillion() {
		int result = EvenFiboNumbersSum(4_000_000);
		System.out.printf("EvenFiboNumbersSum(4_000_000)=%s%n", result);
		assertEquals( "Incorrect sum of even Fibo numbers that do not exceed 4 million", 4613732, result );
	}
}
