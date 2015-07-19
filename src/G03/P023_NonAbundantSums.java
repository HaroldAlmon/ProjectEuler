package G03;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import G03.P021_AmicableNumbers.ProperDivisors;

public class P023_NonAbundantSums {
	ProperDivisors properDivisors = new ProperDivisors();
	public long nonAbundantSums() {
		long grandTotal = 0;
		int upperLimit = 28123;
		int lowerLimit = 12;
		
		List<Integer> abundantNums = new ArrayList<>();
		Set<Integer> abundantSums = new HashSet<>();
		
		abundantNums = calculateAbundantNumbers( upperLimit, lowerLimit, abundantNums );
		abundantSums = calculateAbundantSums( upperLimit, abundantNums, abundantSums );
		grandTotal = grandTotal( grandTotal, upperLimit, abundantSums );
		
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

	private List<Integer> calculateAbundantNumbers( int upperLimit, int lowerLimit, List<Integer> abundant ) {
		int[] divisors;
		for ( int candidate = 1; candidate < upperLimit - lowerLimit; candidate++ ) {
			divisors = properDivisors.properDivisors( candidate ) ;
			if( sumOfElements( divisors ) > candidate) {
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
	
	int sumOfElements( int [] array ){
		int sum = 0;
		for( int element : array )
			sum += element;
		return sum;
	}

	@Test( timeout = 10_000 )
	public void NonAbundantSums() {
		long grandTotal = nonAbundantSums();
		System.out.println( "Sum of all the positive integers which cannot be written as the sum of two abundant numbers = " + grandTotal );
		assertEquals( 4179871, grandTotal );
	}
}
