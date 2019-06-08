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
		int result = 0;

		result = coinSumsImpl(result, 200, 0);
		return result;
	}
	
	private int coinSumsImpl(int result, int penceRemaining, int coinPosition) {
		if (coinPosition > coins.length - 1 ) return result;
		do {
			if( penceRemaining > 0 ) {
				result = coinSumsImpl( result, penceRemaining, coinPosition + 1 );
			} else if ( penceRemaining == 0 ) {
				result += 1;
			}
			penceRemaining -= coins[coinPosition];
		} while ( penceRemaining >= 0 );
		return result;
	}

	@Test
	public void CoinSums() {
		int coinSums = coinSums();
		System.out.printf(this.getClass().getSimpleName() + ": Coin sum is %s", coinSums);
		assertEquals(73682, coinSums);
	}
}

