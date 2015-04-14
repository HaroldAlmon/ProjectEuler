package G02;

import java.math.BigInteger;

import org.junit.Test;

public class P016_PowerDigitSum {
	public int sum(int power) {
		BigInteger sum = new BigInteger("2");
		BigInteger two = new BigInteger("2");
		int result = 0;	
		for(int i = 0; i < power - 1; i++)
			sum = sum.multiply(two);
		String s = sum.toString();
		for (int index = 0; index < s.length(); index++)
			result += Character.getNumericValue(s.charAt(index));
		return result;
	}
	
	@Test
	public void test1() {
		System.out.printf("%d", sum(1000));
	}
}