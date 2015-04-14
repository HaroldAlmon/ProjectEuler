package G02;

import static org.junit.Assert.assertTrue;
import java.math.BigInteger;
import org.junit.Test;
public class P015_LatticePaths {
	/**
	 * This problem can be reduced to a combination.
	 * If you think of the solution as a sequence
	 * of 2n slots and the directions as two choices
	 * *(r and d) then you can place the r's in 
	 *  2n slots and the d's in the remaining slots.
	 *  After the r's are placed in the slots, there
	 *  is only one way to place the d's in the remaining
	 *  slots.  So, just count the number of ways to
	 *  place the r's in 2n slots.
	 * @param lattticeSize - The width and height of the lattice
	 * @return The number of paths through the lattice.
	 */
	public String getPaths(int lattticeSize) {
		String result;
		BigInteger nx2Factorial = factorial(2*lattticeSize);
		BigInteger nFactorial = factorial(lattticeSize);

		// Here is the combination calculation where N=2n and R=n.
		//              (2n)!        (2n)!
		//  C(N,R) = -----------  = ------- 
		//           (2n-n)! * n!   n! * n!
		result = nx2Factorial.divide(nFactorial).divide(nFactorial).toString();
		System.out.printf("%s\n", result);
		return result;
	}
	
	private BigInteger factorial(int n) {
		BigInteger result = new BigInteger("1");
		for (int i = 1; i <= n; i++)
			result = result.multiply(BigInteger.valueOf(i));
		return result;
	}

	@Test
	public void test1() {
		assertTrue( getPaths(20).equals("137846528820") );
		assertTrue( getPaths(2).equals("6") );
	}
}
