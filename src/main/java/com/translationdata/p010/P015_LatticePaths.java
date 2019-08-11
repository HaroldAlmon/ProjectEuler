package com.translationdata.p010;
/** Strategy: Mathematics */
import static org.junit.Assert.assertEquals;
/**
 * Strategy: Discrete Mathematics.
 * Explanation: 
 * In the problem a 2x2 matrix has 2 right moves
 * and 2 down moves. So there are 4 moves that
 * need to be made to get to the end.
 * 
 * The first solution on the web page shows the
 * following sequence (R, R, D, D). See how the 2
 * R's can go into 4 positions?
 *
 * So the problem is 4 choose 2 which
 * is a combination.
 * 
 */
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.translationdata.JUnitTests.FastTest;

//import jdk.nashorn.internal.ir.annotations.Ignore;
@Category(FastTest.class)
public class P015_LatticePaths {
	public String latticePaths(int latticeSize) {
		String result;

		BigInteger nx2Factorial = factorial(2*latticeSize);
		BigInteger nFactorial = factorial(latticeSize);

		// Here is the combination calculation C(n,r) where n=2n and r=n and n=latticeSize.
		//              (2n)!        (2n)!
		//  C(n,r) = -----------  = ------- 
		//           (2n-n)! * n!   n! * n!
		result = nx2Factorial.divide(nFactorial).divide(nFactorial).toString();
		//System.out.printf("Result = %s%n", result);
		return result;
	}
	
	private BigInteger factorial(final int n) {
		BigInteger result = new BigInteger("1");
		for (int i = 1; i <= n; i++)
			result = result.multiply(BigInteger.valueOf(i));
		return result;
	}

	@Test(timeout = 500)
	public void CountLattice20x20() {
		long pathCount = Long.parseLong( latticePaths(20) );
		System.out.printf(this.getClass().getSimpleName() +  ": latticePaths(20) = %s%n", pathCount);
		assertEquals( Long.parseLong("137846528820"), pathCount );

	}
	
	@Test(timeout = 500)
	//@Ignore
	public void CountLattice6x6() {
		assertTrue( latticePaths(2).equals("6") );
	}
}
