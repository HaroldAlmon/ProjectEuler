package G01;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
public class P005_SmallestMultipleHashMap {
	public static void main(String[] args) {
		new P005_SmallestMultipleHashMap().smallestMultiple(20);
	}

	long smallestMultiple(int maxDivisor) {
		P003_LargestPrimeFactor maxFactor = new P003_LargestPrimeFactor();
		HashMap<Integer, Integer> factorCounts = new HashMap<>();

		Map<Integer, Integer> maximumFactorCount = new HashMap<>();
		int[] factorsForDivisor;

		for(int divisor=2; divisor <= maxDivisor; divisor += 1) {
			factorsForDivisor = maxFactor.getFactors(divisor);
			countIdenticalFactors(factorCounts, factorsForDivisor);
			checkEachFactorCount(factorCounts, maximumFactorCount);
			factorCounts.clear();
		};
		
		long productOfFactors = 1;

		productOfFactors = mutiplyFactors(maximumFactorCount, productOfFactors);
		System.out.printf("Result(%d) = %d%n", maxDivisor, productOfFactors);
		return productOfFactors;
	}

	private void checkEachFactorCount(
			HashMap<Integer, Integer> factorCounts,
			Map<Integer, Integer> maximumFactorCount) {
		for(Integer factor : factorCounts.keySet()) {
			maximizeFactorCount(factorCounts, maximumFactorCount, factor);
		}
	}

	private void maximizeFactorCount(
			HashMap<Integer, Integer> factorCounts,
			Map<Integer, Integer> maximumFactorCount, 
			Integer factor) {
		if(maximumFactorCount.containsKey(factor)) {
			if(factorCounts.get(factor) > maximumFactorCount.get(factor)) {
				setNewMaximumFactorCount(factorCounts, maximumFactorCount, factor);
			}
		} else {
			setNewMaximumFactorCount(factorCounts, maximumFactorCount, factor);
		}
	}

	private void setNewMaximumFactorCount(
			HashMap<Integer, Integer> factorCounts,
			Map<Integer, Integer> maximumFactorCount, Integer factor) {
		maximumFactorCount.put(factor, factorCounts.get(factor));
	}

	private long mutiplyFactors(Map<Integer, Integer> maximumFactorCount, long productOfFactors) {
		for (Integer factor : maximumFactorCount.keySet()) {
			productOfFactors *= (long) Math.pow(factor, maximumFactorCount.get(factor));
		}
		return productOfFactors;
	}

	private void countIdenticalFactors(	Map<Integer, Integer> factorCounts, int[] factors) {
		for(int factorIdx = 0; factorIdx < factors.length; factorIdx++) {
			if (factorCounts.containsKey( factors[factorIdx] )) {
				incrementFactorCount(factorCounts, factors, factorIdx);
			} else {
				setFactorCoutToOne(factorCounts, factors, factorIdx);
			};
		}
	}

	private void setFactorCoutToOne(Map<Integer, Integer> factorCounts, int[] factors, int factorIdx) {
		factorCounts.put(factors[factorIdx], 1);
	}

	private void incrementFactorCount(Map<Integer, Integer> factorCountForDivisorFactor, int[] factors,	int factIdx) {
		factorCountForDivisorFactor.put(factors[factIdx], factorCountForDivisorFactor.get(factors[factIdx]) + 1);
	}
	
	@Test
	public void ProductOf20() {
		assertEquals( "Incorrect product", 232792560 , smallestMultiple(20));
	}
	
	@Test
	public void ProductOf10() {
		assertEquals( "Incorrect product", 2520 , smallestMultiple(10));
	}
	
	@Test
	public void ProductOf15() {
		assertEquals( "Incorrect product", 360360 , smallestMultiple(15));
	}
}
