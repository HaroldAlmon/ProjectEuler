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
		int sum = 0;
		int result = 0;
		for(int twoPounds = 0; twoPounds <= 1; twoPounds++) {
			for(int onePound = 0; onePound <= 2; onePound++) {
				for(int fiftyPence = 0; fiftyPence <= 4; fiftyPence++) {
					for(int twentyPence = 0; twentyPence <= 10; twentyPence++) {
						for(int tenPence = 0; tenPence <= 20; tenPence++) {
							for(int fivePence = 0; fivePence <= 40; fivePence++) {
								for(int twoPence = 0; twoPence <= 100; twoPence++) {
									for(int onePence = 0; onePence <= 200; onePence++) {
										if(sum == 200) {
											result++;
										}
										sum += 1;
									}
									sum -= 200 + 1; // Subtract the value of all the onePence plus one more coin.
									sum += 2; // Add two pence.
								}
								sum -= 200 + 2;
								sum += 5;
							}
							sum -= 200 + 5;
							sum += 10;
						}
						sum -= 200 + 10;
						sum += 20;
					}
					sum -= 200 + 20;
					sum += 50;
				}
				sum -= 200 + 50;
				sum += 100;
			}
			sum -= 200 + 100;
			sum += 200;
		}
		sum -= 200 + 200;
		return result;
	}

	@Test
	public void CoinSums() {
		int coinSums = run();
		System.out.printf(this.getClass().getSimpleName() + ": Coin sum is %s", coinSums);
		assertEquals(coinSums,73682);
	}
}

