package com.translationdata.p030;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class P031_CoinSumsDynamicPrograming {
	/** Strategy: Dynamic Programming.  An improvement on my original solution.  */
	public static void main(String[] args) {
		P031_CoinSumsDynamicPrograming coinSums = new P031_CoinSumsDynamicPrograming();
		int result = coinSums.coinSums();
		System.out.println(result);
	}
	private int[] coins = { 200, 100, 50, 20, 10, 5, 2, 1 };

	private int coinSums() {
		return coinSumsImpl(0, 200, 0);
	}
	
	private int coinSumsImpl(int result, int penceRemaining, int coinPosition) {
		if (coinPosition > coins.length - 1 ) 
			return result;
		if( penceRemaining > 0 ) {
			// Use the next smaller coin to partition the remaining pence...
			result = coinSumsImpl( result, penceRemaining, coinPosition + 1 );
			
			// Use the same coin to decrease the pence remaining...
			return coinSumsImpl( result, penceRemaining - coins[coinPosition], coinPosition );
		} else if ( penceRemaining == 0 ) {
			
			// When the partition reaches zero pence partition by the same coin, the code returns here...
			return result + 1;
		}
		return result;
	}
	
	@Test
	public void CoinSums() {
		int coinSums = coinSums();
		System.out.printf(this.getClass().getSimpleName() + ": Coin sum is %s", coinSums);
		assertEquals(73682, coinSums);
	}
}

