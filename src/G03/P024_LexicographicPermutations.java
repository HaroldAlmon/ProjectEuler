package G03;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class P024_LexicographicPermutations {

	private String lexicographicPermutations(int noOfDigits) {
		int[] digits = new int[noOfDigits];
		for(int i = 0; i < noOfDigits; i++) {
			digits[i] = i;
		}
			// while p > 0
			// 		set p to 2nd last char
			//		while p >= 0
			//		if smaller digit on the right of p
			//			swap p and smallest digit to the right of p
			// 			sort digits to the right of p
			//			print digits
			//			break;
			//		else
			//			p = p - 1;
			//		end while
			//			
			// end if
			// end while
		return "";
	}
	@Test
	public void Permutation() {
		String permutation;
		permutation = lexicographicPermutations(3); 
		assertEquals("Permutation is not correct", "123", permutation);
	}
}
