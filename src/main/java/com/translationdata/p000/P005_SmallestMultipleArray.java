package com.translationdata.p000;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
/** Strategy: Simple Mathematics. */
public class P005_SmallestMultipleArray {
	public long smallestMultiple(final int maxDivisor) {
		P003_LargestPrimeFactor p003_LargestPrimeFactor = new P003_LargestPrimeFactor();
		
		// If 2*3*3 are factors then factorCount[2] = 1, factorCount[3] = 2;
		int[] factorCount = new int[20];
		int[] finalFactorCount = new int[20];
		int[] factors;
		long factorsProduct;

		for(int divisor=2; divisor<=maxDivisor; divisor += 1) {
			factors = p003_LargestPrimeFactor.factors(divisor);
			factorCount = countIdenticalFactors(factorCount, factors);
			maximizeFactors(maxDivisor, factorCount, finalFactorCount);
			zeroFactorCountArray(factorCount);
		};

		factorsProduct = multiplyFactors(maxDivisor, finalFactorCount );
		System.out.printf("smallestMultiple(%d) = %d%n", maxDivisor, factorsProduct);
		return factorsProduct;
	}

	private void zeroFactorCountArray(final int[] factorCount) {
		Arrays.fill(factorCount, 0);
	}

	private void maximizeFactors(final int maxDivisor, final int[] factorCount, final int[] finalFactorCount) {
		for(int factIdx = 0; factIdx < maxDivisor; factIdx++) {
			if(factorCount[factIdx] > finalFactorCount[factIdx]) {
				finalFactorCount[factIdx] = factorCount[factIdx];
			}
		}
	}

	private long multiplyFactors(final int maxDivisor, final int[] finalFactorCount ) {
		long productOfFactors = 1;
		
		for(int factIdx = 0; factIdx < maxDivisor; factIdx++) {
			if(finalFactorCount[factIdx] != 0 ) {
				productOfFactors *= (long) Math.pow(factIdx, finalFactorCount[factIdx]);
			}
		}
		return productOfFactors;
	}

	private int[] countIdenticalFactors(final int[] factorCount, final int[] factors) {
		for(int factIdx = 0; factIdx < factors.length; factIdx++) {
			factorCount[ factors[factIdx] ] += 1;
		}
		return factorCount;
	}
	
	@Test(timeout = 500)
	public void NumberDivisibleBy1To20() {
		assertEquals( "Incorrect product", 232792560, smallestMultiple(20) );
	}
}
