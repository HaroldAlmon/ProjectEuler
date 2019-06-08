package com.translationdata.p030;

import static org.junit.Assert.*;

import org.junit.Test;
/** Strategy: Divide and conquer. Dynamic programming. See my other generic solution but this one runs must faster. */
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
				subDivideWith2Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 5;
		} while ( pence >= 0 );
	}
	
	void subDivideWith2Pence(int pence) {
		do {
			if( pence > 0 ) {
				subDivideWith1Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 2;
		} while ( pence >= 0 );
	}
	
	// With just two pence and once pence left this way is faster...
	/* // when just two and one pence are left, there is only one way to subdivide with two pence.
	 * // Just keep adding two pence. 1x2 + 1's, 2x2 + 1's, 3x2 + 1's.    
	 * void subDivideWith2Pence(int pence) { 
	 * 	count += pence / 2;
	 * 	subDivideWith1Pence(pence); // All one pence always 1 way.
	 * }
	 */
	
	// When subdividing with one pence, it does not matter how much is left, there is only one way to divide, use all pence. 
	void subDivideWith1Pence(int pence) {
		count += 1;
	}
	
	@Test
	public void CoinSums() {
		final int pence = 200;
		int coinSums = coinSums(pence);
		System.out.printf("Coin Sums for %dp is %s", pence, coinSums);
		assertEquals(coinSums,73682);
	}
}
