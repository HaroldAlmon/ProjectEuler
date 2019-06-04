package com.translationdata.p030;

public class P031_CoinSumsBtuteForce {

	public static void main(String[] args) {
		P031_CoinSumsBtuteForce coinSums = new P031_CoinSumsBtuteForce();
		int result = coinSums.coinSums();
		System.out.println(result);
	}

	private int coinSums() {
		int sum = 0;
		int result = 0;
		for(int twoPounds = 0; twoPounds <= 1; twoPounds++) {
			for(int onePound = 0; onePound <= 2; onePound++) {
				for(int fiftyPence = 0; fiftyPence <= 4; fiftyPence++) {
					for(int twentyPence = 0; twentyPence <= 10; twentyPence++) {
						for(int tenPence = 0; tenPence <= 20; tenPence++) {
				
							if(sum == 200) {
								result++;
							}
							
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
}

