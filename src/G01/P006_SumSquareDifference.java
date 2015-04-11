package G01;

import static G01.Formatter.errorText;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * Strategy: Simple mathematics.
 * @author Harold Almon
 */
public class P006_SumSquareDifference {
	public static void main(String[] args) {
		P006_SumSquareDifference main = new P006_SumSquareDifference();
		main.run(100);
	}
	
	private long run(int maxNum) {
		long result = 0;
		result = squareSum(maxNum) - sumSquares(maxNum);
		
		System.out.printf("result(%d) = %d", maxNum, result);
		
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
	public void test1() {
		assertEquals( errorText("Incorrect sum"), 25164150, run(100) );
	}
	
}

