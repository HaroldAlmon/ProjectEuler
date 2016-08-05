package com.translationdata.p000;
/** Strategy: Brute Force. */
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.translationdata.JUnitTests.FastTest;

import static org.junit.Assert.assertEquals;
@Category( FastTest.class )
public class P005_SmallestMultipleHashMap {
	long smallestMultiple( final int maxDivisor ) {
		P003_LargestPrimeFactor maxFactor = new P003_LargestPrimeFactor();
		HashMap<Integer, Integer> factorCounts = new HashMap<>();

		Map<Integer, Integer> maximumFactorCount = new HashMap<>();
		int[] factorsForDivisor;

		for( int divisor=2; divisor <= maxDivisor; divisor += 1 ) {
			factorsForDivisor = maxFactor.factors( divisor );
			countIdenticalFactors( factorCounts, factorsForDivisor );
			checkEachFactorCount( factorCounts, maximumFactorCount );
			factorCounts.clear();
		};
		
		long factorsProduct = 1;

		factorsProduct = mutiplyFactors( maximumFactorCount, factorsProduct );
		System.out.printf( "smallestMultiple( %d ) = %d%n", maxDivisor, factorsProduct );
		return factorsProduct;
	}

	private void checkEachFactorCount( 
			HashMap<Integer, Integer> factorCounts,
			Map<Integer, Integer> maximumFactorCount ) {
		for( Integer factor : factorCounts.keySet() ) {
			maximizeFactorCount( factorCounts, maximumFactorCount, factor );
		}
	}

	private void maximizeFactorCount( 
			final HashMap<Integer, Integer> factorCounts,
			final Map<Integer, Integer> maximumFactorCount, 
			final Integer factor ) {
		if( maximumFactorCount.containsKey( factor ) ) {
			if( factorCounts.get( factor ) > maximumFactorCount.get( factor ) ) {
				setNewMaximumFactorCount( factorCounts, maximumFactorCount, factor );
			}
		} else {
			setNewMaximumFactorCount( factorCounts, maximumFactorCount, factor );
		}
	}

	private void setNewMaximumFactorCount( 
			final HashMap<Integer, Integer> factorCounts,
			final Map<Integer, Integer> maximumFactorCount, Integer factor ) {
		maximumFactorCount.put( factor, factorCounts.get( factor ) );
	}

	private long mutiplyFactors( final Map<Integer, Integer> maximumFactorCount, final long factors ) {
		long productOfFactors = factors;
		for ( Integer factor : maximumFactorCount.keySet(  ) ) {
			productOfFactors *= ( long ) Math.pow( factor, maximumFactorCount.get( factor ) );
		}
		return productOfFactors;
	}

	private void countIdenticalFactors( final Map<Integer, Integer> factorCounts, final int[] factors ) {
		for( int factorIdx = 0; factorIdx < factors.length; factorIdx++ ) {
			if ( factorCounts.containsKey( factors[factorIdx] ) ) {
				incrementFactorCount( factorCounts, factors, factorIdx );
			} else {
				setFactorCoutToOne( factorCounts, factors, factorIdx );
			};
		}
	}

	private void setFactorCoutToOne( final Map<Integer, Integer> factorCounts, final int[] factors, final int factorIdx ) {
		factorCounts.put( factors[factorIdx], 1 );
	}

	private void incrementFactorCount( final Map<Integer, Integer> DivisorFactorCount, final int[] factors,	final int factIdx ) {
		DivisorFactorCount.put( factors[factIdx], DivisorFactorCount.get( factors[factIdx] ) + 1 );
	}
	
	@Test( timeout = 500 )
	public void NumberDivisibleBy1To20() {
		assertEquals(  "Incorrect product", 232792560 , smallestMultiple( 20 ) );
	}
	
	@Test( timeout = 500 )
	public void NumberDivisibleBy1To10() {
		assertEquals(  "Incorrect product", 2520 , smallestMultiple( 10 ) );
	}
	
	@Test( timeout = 500 )
	public void NumberDivisibleBy1To15() {
		assertEquals(  "Incorrect product", 360360 , smallestMultiple( 15 ) );
	}
}
