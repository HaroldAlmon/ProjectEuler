package com.translationdata.p030;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class P031_CoinSumsDynamicPrograming {
	/** Strategy:  Divide and conquer.  An improvement on my original solution. 
	 * This works fast because there are no negative numbers and no duplicates. */
	public static void main(String[] args) {
		P031_CoinSumsDynamicPrograming coinSums = new P031_CoinSumsDynamicPrograming();
		final int result = coinSums.run();
		System.out.println(result);
	}
	private int[] coins = { 200, 100, 50, 20, 10, 5, 2, 1 };

	private int run() {
		return coinSumsImpl(0, 200, 0);
	}
	
	// This is set up as tail recursion but does not need tail recursion elimination because the
	// maximum depth is 200 when 200p is divided by 1p.
	private int coinSumsImpl(int result, int penceRemaining, int coinPosition) {
		if (coinPosition > coins.length - 1 ) 
			return result;
		if( penceRemaining > 0 ) {
			// Use the next smaller coin to partition the remaining pence...
			result = coinSumsImpl( result, penceRemaining, coinPosition + 1 );
			
			// Use the same coin to decrease the pence remaining...
			return coinSumsImpl( result, penceRemaining - coins[coinPosition], coinPosition );
		} else if ( penceRemaining == 0 ) {
			
			// When the partition reaches zero pence partitioned by the same coin, the code returns here...
			return result + 1;
		}
		return result;
	}
	
	@Test
	public void CoinSums() {
		final int coinSums = run();
		System.out.printf(this.getClass().getSimpleName() + ": Coin sum is %s", coinSums);
		assertEquals(73682, coinSums);
	}
}

