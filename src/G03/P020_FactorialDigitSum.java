package G03;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import org.junit.Test;

public class P020_FactorialDigitSum {
	public int factorialDigitSum(int upperLimit) {
		String factorialString;
		int sumOfDigits = 0;

		BigInteger factorial = new BigInteger("1");

		factorial = calculateFactorial(upperLimit, factorial);
		factorialString = factorial.toString();
		sumOfDigits = calculateSumOdDigits(factorialString, sumOfDigits);
		return sumOfDigits;
	}
	private int calculateSumOdDigits(String factorialString, int sumOfDigits) {
		for (int position = 0; position < factorialString.length(); position++) {
			sumOfDigits += Character.getNumericValue(factorialString.charAt(position));
		}
		return sumOfDigits;
	}
	private BigInteger calculateFactorial(int upperLimit, BigInteger factorial) {
		for (int i = 2; i <= upperLimit; i++) {
			BigInteger one = new BigInteger("1");
			BigInteger multiplier = new BigInteger("2");
			factorial = factorial.multiply(multiplier);
			multiplier = multiplier.add(one);
		}
		return factorial;
	}
	@Test(timeout = 500)
	public void FactorialDigitSum() {
		int sumOfDigits = factorialDigitSum(100);
		System.out.printf("factorialDigitSum(100) = %d%n", sumOfDigits);
		assertEquals(sumOfDigits, 648 );
	}
}
