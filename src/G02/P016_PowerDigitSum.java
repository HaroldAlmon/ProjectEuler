package G02;
/**
 * @author Harold Almon
 * @return The sum of the digits of the number 2**1000
 */
import static org.junit.Assert.assertEquals;

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
	
	@Test(timeout = 500)
	public void Sum() {
		int sum = sum(1000);
		System.out.printf("Result = %d%n", sum);
		assertEquals( "Incorrect sum", sum, 1366 );
	}
}