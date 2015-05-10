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
		int p = 0;
		int k = noOfDigits - 2;
		while (k >= 0) {
			p = k;
			while (p >= 0) {
				int temp = 0;
				int smallestPosition;
				// if smaller digit on the right of p
				smallestPosition = smallestPosition(digits, p);
				if (digits[smallestPosition] != Integer.MAX_VALUE) {
					// swap p and smallest digit to the right of p
					temp = digits[p + 1];
					digits[p + 1] = digits[p];
					digits[p] = temp;
					// sort digits to the right of p
					// print all digits
					System.out.printf("String = %s%n", Arrays.toString(digits));
					p = noOfDigits - 2;
					break;
				}
			}
			k -= 1;
		}
		return "";
	}
	
	private int smallestPosition(int[] digits, int p) {
		int min = Integer.MAX_VALUE;
		int leftChar = digits[p];
		for (int i = p+1; i < digits.length; i++) {
			if(leftChar < digits[i] && digits[i] < min) {
				min = digits[i];
			}
		}
		return min;
	}
	
@Test
	public void Permutation() {
		String permutation;
		permutation = lexicographicPermutations(3); 
		assertEquals("Permutation is not correct", "123", permutation);
	}
}
