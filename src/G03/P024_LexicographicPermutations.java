package G03;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class P024_LexicographicPermutations {

	private String lexicographicPermutations(int noOfDigits) {
		int[] digits = new int[noOfDigits];
		for (int i = 0; i < noOfDigits; i++) {
			digits[i] = i;
		}
		System.out.printf("%s%n", Arrays.toString(digits));
		int k = noOfDigits - 2;
		int p = noOfDigits - 2;
		while (k > 0) {
			while (p >= 0) {
				int temp = 0;
				// if smaller digit on the right of p
				smallestPosition = smallestPosition(digits, p);
				if (digits[p] < ) {
					// swap p and smallest digit to the right of p
					temp = digits[p + 1];
					digits[p + 1] = digits[p];
					digits[p] = temp;
					// sort digits to the right of p
					// print all digits
					System.out.printf("String = %s%n", Arrays.toString(digits));
					p = noOfDigits - 2;
					break;
				} else {
					p = p - 1;
				}
			}
			k -= 1;
		}
		return "";
	}
	
	private int smallestPosition(int[] digits, int p) {
		int min = Integer.MAX_VALUE;
		for (int i = p+2; i < digits.length; i++) {
			if(digits[i+1] < min) {
				min = digits[i+1];
			}
		}
		return min;
	}
	
	private int smallestDigit(int[] digits, int startPosition) {
		return 0;
	}
	// 012
	@Test
	public void Permutation() {
		String permutation;
		permutation = lexicographicPermutations(3); 
		assertEquals("Permutation is not correct", "123", permutation);
	}
}
