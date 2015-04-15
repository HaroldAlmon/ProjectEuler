package G03;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;

public class P020_FactorialDigitSum {
	public int getTotal(int n) {
		BigInteger product = new BigInteger("1");
		BigInteger multiplier = new BigInteger("2");
		BigInteger one = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			product = product.multiply(multiplier);
			multiplier = multiplier.add(one);
		}
		//System.out.printf("total = %s\n", product);
		int sum = 0;
		String factorial = product.toString();
		for (int i = 0; i < factorial.length(); i++) {
			sum += Character.getNumericValue(factorial.charAt(i));
		}
		return sum;
	}
	@Test
	public void test1() {
		int result = getTotal(100);
		System.out.printf("sum = %d\n", result);
		assertTrue(648 == result);
		;
	}
}
