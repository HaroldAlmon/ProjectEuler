package com.translationdata.p030;

import static org.junit.Assert.*;

import org.junit.Test;
/** Strategy: Divide and conquer. */
public class P031_CoinSums {
	int count = 0;
	public int coinSums(int pence) {
		subDivideWith200Pence(pence);
		return count;
	}

	void subDivideWith200Pence(int pence) {
		do {
			if( pence > 0 ) {
				subDivideWith100Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 200;
		} while ( pence >= 0 );
	}

	void subDivideWith100Pence(int pence) {
		do {
			if( pence > 0 ) {
				subDivideWith50Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 100;
		} while ( pence >= 0 );
	}

	void subDivideWith50Pence(int pence) {
		do {
			if( pence > 0 ) {
				subDivideWith20Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 50;
		} while ( pence >= 0 );
	}

	void subDivideWith20Pence(int pence) {
		do {
			if( pence > 0 ) {
				subDivideWith10Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 20;
		} while ( pence >= 0 );
	}

	void subDivideWith10Pence(int pence) {
		do {
			if( pence > 0 ) {
				subDivideWith5Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 10;
		} while ( pence >= 0 );
	}
	
	void subDivideWith5Pence(int pence) {
		do {
			if( pence > 0 ) {
				calculate2PencePartitions( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 5;
		} while ( pence >= 0 );
	}
	
	void calculate2PencePartitions(int pence) {
		count += (pence / 2 + 1);
	}
	
	@Test
	public void CoinSums() {
		final int pence = 200;
		int coinSums = coinSums(pence);
		System.out.printf("Coin Sums for %dp is %s", pence, coinSums);
		assertEquals(coinSums,73682);
	}
}
