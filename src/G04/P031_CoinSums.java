package G04;

import static org.junit.Assert.*;

import org.junit.Test;

public class P031_CoinSums {
	int count = 0;
	public int coinSums(int pence) {
		sunDivideInto200Pence(pence);
		return count;
	}
	
	void sunDivideInto200Pence(int pence) {
		do {
			if( pence > 0 ) {
				subDivideInto100Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 200;
		} while ( pence >= 0 );
	}
	
	void subDivideInto100Pence(int pence) {
		do {
			if( pence > 0 ) {
				subDivideInto50Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 100;
		} while ( pence >= 0 );
	}
	
	void subDivideInto50Pence(int pence) {
		do {
			if( pence > 0 ) {
				subDivideInto20Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 50;
		} while ( pence >= 0 );
	}
	
	void subDivideInto20Pence(int pence) {
		do {
			if( pence > 0 ) {
				subDivideInto10Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 20;
		} while ( pence >= 0 );
	}
	
	void subDivideInto10Pence(int pence) {
		do {
			if( pence > 0 ) {
				subDivideInto5Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 10;
		} while ( pence >= 0 );
	}
	
	void subDivideInto5Pence(int pence) {
		do {
			if( pence > 0 ) {
				subdivideInto2Pence( pence );
			} else if ( pence == 0 ) {
				count += 1;
			}
			pence -= 5;
		} while ( pence >= 0 );
	}
	
	void subdivideInto2Pence(int pence) {
		count += (pence / 2 + 1);
	}
	
	@Test( timeout = 1_000)
	public void CoinSums() {
		int coinSums = coinSums(200);
		System.out.printf("Coin Sums for 200p is %s", coinSums);
		assertEquals(coinSums,73682);
	}
}
