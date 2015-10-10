package G04;

import static org.junit.Assert.*;

import org.junit.Test;

public class P031_CoinSums {
	int count = 0;
	public int coinSums(int pence) {
		count200p(pence);
		return count;
	}
	
	void count200p(int pence) {
		do {
			if( pence > 0 ) {
				count100p( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 200;
		} while ( pence >= 0 );
	}
	
	void count100p(int pence) {
		do {
			if( pence > 0 ) {
				count50p( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 100;
		} while ( pence >= 0 );
	}
	
	void count50p(int pence) {
		do {
			if( pence > 0 ) {
				count20p( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 50;
		} while ( pence >= 0 );
	}
	
	void count20p(int pence) {
		do {
			if( pence > 0 ) {
				count10p( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 20;
		} while ( pence >= 0 );
	}
	
	void count10p(int pence) {
		do {
			if( pence > 0 ) {
				count5p( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 10;
		} while ( pence >= 0 );
	}
	
	void count5p(int pence) {
		do {
			if( pence > 0 ) {
				count2p( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 5;
		} while ( pence >= 0 );
	}
	
	void count2p(int pence) {
		count += (pence / 2 + 1);
	}
	
	@Test
	public void CoinSums() {
		int coinSums = coinSums(200);
		System.out.printf("Coin Sums for 200p is %s", coinSums);
		assertEquals(coinSums,73682);
	}
}
