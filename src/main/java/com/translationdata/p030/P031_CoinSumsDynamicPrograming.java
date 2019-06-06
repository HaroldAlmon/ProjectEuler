package com.translationdata.p030;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class P031_CoinSumsDynamicPrograming {
	/** Strategy: Brute Force. */
	public static void main(String[] args) {
		P031_CoinSumsDynamicPrograming coinSums = new P031_CoinSumsDynamicPrograming();
		int result = coinSums.coinSums();
		System.out.println(result);
	}
	private int[] coins = { 200, 100, 50 };

	private int coinSums() {
		int result = 0;

		result = coinSumsImpl(result, 200, 0);
		return result;
	}
	
	private int coinSumsImpl(int result, int pence, int arrayPosition) {
		if (arrayPosition > coins.length - 1 || pence < 1 ) return result;
		int coinPence = coins[arrayPosition];
		if ( coinPence == 50 ) // Basis
			 result += 1;
			else {
				if( pence > 0 ) {
					// Use next smaller coin...
					result = coinSumsImpl( result, pence, arrayPosition + 1);
				} else if ( pence == 0 ) {
					result += 1;
				}
				pence -= coinPence;
				result = coinSumsImpl( result, pence, arrayPosition);
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

