package G01;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * Strategy: Brute force.
 * Use a for-loop since we do not know the term
 * of the Fibonacci number we re seeking. 
 * @author Harold
 *
 */
public class P002_EvenFibonacciNumbers {
	public static void main(String[] args) {
		System.out.printf("Result: %d", new P002_EvenFibonacciNumbers().run());

	}
	long run() {
		long result = 2;
		int num1 = 1;
		int num2 = 2;
		int sum = 3;
		while (sum < 4000000) {
			if( sum % 2 == 0) {
				result += sum;				
			}
			num1 = num2;
			num2 = sum;
			sum = num1 + num2;
		}
		
		return result;
	}
	@Test
	public void test1() {
		assertTrue( run() == 4613732 );
	}
}
