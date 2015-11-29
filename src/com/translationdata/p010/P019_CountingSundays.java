package com.translationdata.p010;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/** Strategy: Simple mathematics. */

public class P019_CountingSundays {
	@SuppressWarnings( "serial" )
	private static Map<Integer, Integer> daysPerMonth = new HashMap<Integer, Integer>() {{
		this.put( 1, 31 );
		this.put( 2, 28 );
		this.put( 3, 31 );
		this.put( 4, 30 );
		this.put( 5, 31 );
		this.put( 6, 30 );
		this.put( 7, 31 );
		this.put( 8, 31 );
		this.put( 9, 30 );
		this.put( 10, 31 );
		this.put( 11, 30 );
		this.put( 12, 31 );
	}};
	int year = 1901;
	int month = 1;
	int dayOfTheWeek = 3;

	public int countSundays() {
		int daysThisMonth;
		int result = 0;

		for ( int i = 0; i < 12*100; i++ ) {
			if ( month == 13 ) {
				month = 1;
				year += 1;
			}

			daysThisMonth = daysPerMonth.get( month );
			if ( month == 2 ) {
				if (  ( year % 4 == 0 ) && 
						( ( year % 100 ) != 0 ) || year % 400 == 0 ) {
					daysThisMonth = 29;
				}
			}
			dayOfTheWeek += daysThisMonth % 7;
			if ( dayOfTheWeek > 7 ) {
				dayOfTheWeek %= 7;
			}
			if ( dayOfTheWeek == 1 ) {
				result += 1;

			}
			month += 1;
		}
		return result;
	}
	
	@Test( timeout = 500 )
	public void CountSundays(){
		int noOfSundays = countSundays();
		System.out.printf(  "countSundays() = %d%n", noOfSundays  );
		assertEquals( 171, noOfSundays );
	}
}
