package G03;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;
/**
 * Strategy: 
 * Multiply the numerator by 2000 to get the division 
 * results on the left of the decimal point.
 * Use BigIntegers to hold the results of a division that has 2000
 * digits of precision.
 * Reverse the string result of the division so that the cycles are
 * on the left. Now the result reads like Arabic, right to left.
 * Look for cycles starting on the left for all numbers from 2 to 999.
 * This is wicked fast!
 * @author Harold Almon
 *
 */
public class P026_ReciprocalCycles {
	private int cycle;
	public int getNumber(int limit) {
		BigInteger quotient;
		StringBuilder revQuotient = new StringBuilder("");
		@SuppressWarnings("unused")
		int result=0;
		int maxCycle = 0;
		int precision = 2000;
		StringBuffer numeratorString = new StringBuffer("1");
		for (int i = 0; i < precision; i++) {
			numeratorString.append( "0" );
		}
		BigInteger numerator = new BigInteger(numeratorString.toString());
		System.out.printf("No. of digits calculated = %d\n",precision);
		
		for (int denominator = 2; denominator < limit; denominator++) {
			quotient = numerator.divide(new BigInteger(Integer.toString(denominator)) );
			revQuotient.append(quotient.toString()).reverse();
			for (int lenght = 1; lenght < precision / 2; lenght++) {
				if( revQuotient.toString().substring(0, lenght).equals(revQuotient.toString().substring(lenght, lenght*2))) {
					if(lenght > maxCycle) {
						maxCycle = lenght;
						cycle = denominator;
					}
					break;
				}
			}
			revQuotient.setLength(0);
		}
		System.out.printf("Max cycle length found = %d\n",maxCycle);
		return cycle;
	}
	@Test
	public void test1() {
		int result = getNumber(1000);
		System.out.printf("Result = %d\n",result);
		assertEquals(983, result);
	}
}
