package G01;

/**
 * Strategy: Simple Mathematics.
 * @author Harold Almon
 */
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class P005_SmallestMultipleArray {
	public long smallestMultiple(int maxDivisor) {
		P003_LargestPrimeFactor p003_LargestPrimeFactor = new P003_LargestPrimeFactor();
		
		// If 2*3*3 are factors then factorCount[2] = 1, factorCount[3] = 3;
		int[] factorCount = new int[20];
		int[] finalFactorCount = new int[20];
		int[] factors;
		long productOfFactors;
		
		for(int divisor=2; divisor<=maxDivisor; divisor += 1) {
			factors = p003_LargestPrimeFactor.getFactors(divisor);
			factorCount = countIdenticalFactors(factorCount, factors);
			maximizeFactors(maxDivisor, factorCount, finalFactorCount);
			zeroFactorCountArray(factorCount);
		};

		productOfFactors = multiplyFactors(maxDivisor, finalFactorCount );
		System.out.println("Result = " + productOfFactors);
		return productOfFactors;
	}

	private void zeroFactorCountArray(int[] factorCount) {
		Arrays.fill(factorCount, 0);
	}

	private void maximizeFactors(int maxDivisor, int[] factorCount, int[] finalFactorCount) {
		for(int factIdx = 0; factIdx < maxDivisor; factIdx++) {
			if(factorCount[factIdx] > finalFactorCount[factIdx]) {
				finalFactorCount[factIdx] = factorCount[factIdx];
			}
		}
	}

	private long multiplyFactors(int maxDivisor, int[] finalFactorCount ) {
		long productOfFactors = 1;
		
		for(int factIdx = 0; factIdx < maxDivisor; factIdx++) {
			if(finalFactorCount[factIdx] != 0 ) {
				productOfFactors *= (long) Math.pow(factIdx, finalFactorCount[factIdx]);
			}
		}
		return productOfFactors;
	}

	private int[] countIdenticalFactors(int[] factorCount, int[] factors) {
		for(int factIdx = 0; factIdx < factors.length; factIdx++) {
			factorCount[ factors[factIdx] ] += 1;
		}
		return factorCount;
	}
	
	@Test
	public void NumbersTo20() {
		assertEquals( "Incorrect product", 232792560, smallestMultiple(20) );
	}
}
