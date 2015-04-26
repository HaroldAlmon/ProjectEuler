package G03;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import org.junit.Test;

public class P020_FactorialDigitSum {
	public int factorialDigitSum(int upperLimit) {
		String factorial;
		int sumOfDigits = 0;

		BigInteger product = new BigInteger("1");
		BigInteger multiplier = new BigInteger("2");
		BigInteger one = new BigInteger("1");
		
		for (int i = 2; i <= upperLimit; i++) {
			product = product.multiply(multiplier);
			multiplier = multiplier.add(one);
		}

		factorial = product.toString();
		for (int position = 0; position < factorial.length(); position++) {
			sumOfDigits += Character.getNumericValue(factorial.charAt(position));
		}
		return sumOfDigits;
	}
	@Test(timeout = 500)
	public void FactorialDigitSum() {
		int sumOfDigits = factorialDigitSum(100);
		System.out.printf("factorialDigitSum(100) = %d%n", sumOfDigits);
		assertEquals(sumOfDigits, 648 );
	}
}
