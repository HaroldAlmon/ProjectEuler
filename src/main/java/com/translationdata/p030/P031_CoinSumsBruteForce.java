package com.translationdata.p030;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class P031_CoinSumsBruteForce {
	/** Strategy: Brute Force. Enumerate every possible sum and check for 200.  Very slow but it works. */
	public static void main(String[] args) {
		P031_CoinSumsBruteForce coinSums = new P031_CoinSumsBruteForce();
		int result = coinSums.run();
		System.out.printf(coinSums.getClass().getSimpleName() + ": Coin sum is %s", result);
	}

	/* Enumerate all the possible combinations of coins. If the total is 200 add 1 to the result */
	private int run() {
		int result = 0;
		for(int twoPounds = 0; twoPounds <= 1; twoPounds++) {
			for(int onePound = 0; onePound <= 2; onePound++) {
				for(int fiftyPence = 0; fiftyPence <= 4; fiftyPence++) {
					for(int twentyPence = 0; twentyPence <= 10; twentyPence++) {
						for(int tenPence = 0; tenPence <= 20; tenPence++) {
							for(int fivePence = 0; fivePence <= 40; fivePence++) {
								for(int twoPence = 0; twoPence <= 100; twoPence++) {
									for(int onePence = 0; onePence <= 200; onePence++) {
										if( onePence + twoPence * 2 + fivePence * 5 + tenPence * 10 + twentyPence * 20 + fiftyPence * 50 + onePound * 100 + twoPounds * 200 == 200) {
											result++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}

	@Test
	public void CoinSums() {
		int coinSums = run();
		System.out.printf(this.getClass().getSimpleName() + ": Coin sum is %s", coinSums);
		assertEquals(coinSums,73682);
	}
}

