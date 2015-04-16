package G01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * Strategy: Brute force.
 * Multiply two numbers together and test of the product is
 * a palidrome. Track the largest palinfrome.
 * @author Harold Almon
 */
public class P004_PalindromeProduct {
	@Test(timeout=500)
	public void PalindromeProduct() {
		int result = product(3);
		assertEquals("Incorrect product", result, 906609);
		System.out.printf("Result = %d\n", result);
	}

	public static void main( String[] args ) {
		P004_PalindromeProduct main = new P004_PalindromeProduct();
		int result = main.product(4);
		System.out.printf("Maximum product=%d", result );
	}
	
	private int product(int numLen) {
		int max = (int) Math.pow(10, numLen) - 1;
		int result = 0;
		int product = 0;
		
		for (int num1 = max; num1 > max/10  ; num1--) {
			for (int num2 = max; num2 > max/10; num2--) {
				product = num1 * num2;
				if (isPal(product) )
				{
					if (product > result) {
						result = product;
						break;
					}
				}
			}
		}

		return result;
	}

	private boolean isPal(int n) {
		String number = Integer.toString(n);
		int left = 0;
		int right = number.length() - 1;
		for (; left < right; left++, right--) {
			if (number.charAt(left) != number.charAt(right)) 
				return false;
		}
		return true;
	}
}
