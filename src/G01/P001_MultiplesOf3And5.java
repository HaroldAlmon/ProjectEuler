package G01;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Strategy: Brute force.
 * 
 * This solution might be slower or faster than checking every
 * number with division by 3 and 5 but I have not tested the
 * difference.
 * @author Harold Almon
 */
public class P001_MultiplesOf3And5 {
	int run(int upperLimit) {
		int result = 0;
		
		int multipleOf3 = 3;
		int multipleOf5 = 5;

		while (multipleOf3 < upperLimit ) {
			result += multipleOf3;
			multipleOf3 += 3;
		}
		
		while (multipleOf5 < upperLimit ) {
			result = addToResultIfNotMultipleOfThree(result, multipleOf5);
			multipleOf5 += 5;
		}
		return result;
	}

	private int addToResultIfNotMultipleOfThree(int result, int multOf5) {
		if( multOf5 % 3 != 0) {
			result += multOf5;
		}
		return result;
	}

	@Test(timeout=100)
	public void CountMultiplesOfThreeAndFive() {
		int result = run(1000);
		System.out.printf("%s\n", result);
		assertEquals( "Incorrect mutiples count", 233168, result );
	}
}
