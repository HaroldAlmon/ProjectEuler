package G01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * Strategy: Simple mathematics.
 * @author Harold Almon
 */
public class P006_SumSquareDifference {
	private long sumSquareDifference(int maxNum) {
		long result = 0;
		result = squareSum(maxNum) - sumSquares(maxNum);
		
		System.out.printf("result(%d) = %d%n", maxNum, result);
		
		return result;
	}
	
	private long sumSquares(int maxNum) {
		long result = 0;
		for(int num = 1; num <= maxNum; num++) {
			result += num*num;
		}
		return result;
	}
	
	private long squareSum(int maxNum) {
		long result = 0;
		for(int num= 1; num <= maxNum; num++) {
			result += num;
		}
		return result * result;
	}
	
	@Test
	public void Sum100() {
		assertEquals( "Incorrect sum", 25164150, sumSquareDifference(100) );
	}
	
}

