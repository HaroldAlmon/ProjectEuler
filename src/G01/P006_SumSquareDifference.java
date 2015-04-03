package G01;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class P006_SumSquareDifference {
	public static void main(String[] args) {
		P006_SumSquareDifference main = new P006_SumSquareDifference();
		main.run(100);
	}
	
	private long run(int maxNum) {
		long result = 0;
		result = squareSum(maxNum) - sumSquares(maxNum);
		
		System.out.printf("result = %d", result);
		
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
		assertTrue( run(100) == 25164150 );
	}
	
}

