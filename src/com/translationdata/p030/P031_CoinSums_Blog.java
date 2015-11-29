package com.translationdata.p030;

import org.junit.Test;

/** 
 * @author Harold Almon
 * This is my first attempt to solve Problem 31.
 * The solution did not work and is here for historical purposes.  
 * See the other solution in this folder for a working solution.
 */
public class P031_CoinSums_Blog {
	long count = 0;
	public long coinSums(int pence) {
		count = subDivideIntoPartitions(pence);
		return count;
	}

	long subDivideIntoPartitions(int pence) {
		long count = 0;
		
		if (pence == 0)
			return 1;

		if(pence < 0)
			return 0;
		
		count += pence/2 + 1;
		
		count += subDivideIntoPartitions(pence - 5);
		count += subDivideIntoPartitions(pence - 10);
		count += subDivideIntoPartitions(pence - 20);
		count += subDivideIntoPartitions(pence - 50);
		count += subDivideIntoPartitions(pence - 100);
		count += subDivideIntoPartitions(pence - 200);
		
		return count;
	}

	@Test
	public void CoinSums() {
		final int pence = 200;
		long coinSums = coinSums(pence);
		System.out.printf("Coin Sums for %dp is %s", pence, coinSums);
	}
}
