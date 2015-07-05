package G03;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import G03.P021_AmicableNumbers.ProperDivisors;

public class P023_NonAbundantSums {
	ProperDivisors properDivisors = new ProperDivisors();
	public long nonAbundantSums() {
		int[] divisors;
		long grandTotal = 0;
		int upperLimit = 28123;
		
		List<Integer> abundantNums = new ArrayList<>();
		Set<Integer> abundantSums = new HashSet<>();
		
		abundantNums = calculateAbundantNumbers( upperLimit, abundantNums );
		abundantSums = calculateAbundantSums( upperLimit, abundantNums, abundantSums );
		grandTotal = grandTotal( grandTotal, upperLimit, abundantSums );
		
		System.out.println( "Grand Total = " + grandTotal );
		return grandTotal;
	}

	private long grandTotal( long grandTotal, int upperLimit, Set<Integer> abundantSums ) {
		for ( int candidate = 1; candidate < upperLimit; candidate++ ) {
			if ( abundantSums.contains( candidate ) == false ) {
				grandTotal += candidate;
			}
		}
		return grandTotal;
	}

	private List<Integer> calculateAbundantNumbers( int upperLimit, List<Integer> abundant ) {
		int[] divisors;
		for ( int candidate = 1; candidate < upperLimit - 12; candidate++ ) {
			divisors = properDivisors.properDivisors( candidate ) ;
			if( sumDivisors( divisors ) > candidate) {
				abundant.add( candidate );
			}
		}
		return abundant;
	}

	private Set<Integer> calculateAbundantSums(int upperLimit, List<Integer> abundant, Set<Integer> abundantSums) {
		for ( int abNum1 = 0; abNum1 < abundant.size(); abNum1++ ) {
			for ( int abNum2 = 0; abNum2 < abundant.size(); abNum2++ )
				if ( abundant.get( abNum1 ) + abundant.get( abNum2 ) < upperLimit ) 
					abundantSums.add( abundant.get( abNum1 ) + abundant.get( abNum2 ) );
				else
					break;
		}
		return abundantSums;
	}
	
	int sumDivisors( int [] array ){
		int total = 0;
		for( int element : array )
			total += element;
		return total;
	}

	@Test( timeout = 10_000 )
	public void NonAbundantSums() {
		long grandTotal = nonAbundantSums();
		assertEquals( 4179871, grandTotal );
	}
}
