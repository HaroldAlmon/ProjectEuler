package G01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * 
 * @author Harold Almon
 *
 */
public class p004_PalindromeProduct {
	@Test
	public void test1() {
		int result = product(3);
		assertEquals(result, 906609);
		System.out.printf("Result=%d\n", result);
	}

	public static void main( String[] args ) {
		p004_PalindromeProduct main = new p004_PalindromeProduct();
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
		String word = Integer.toString(n);
		int left = 0;
		int right = word.length() - 1;
		for (; left < right; left++, right--) {
			if (word.charAt(left) != word.charAt(right)) 
				return false;
		}
		return true;
	}
}
