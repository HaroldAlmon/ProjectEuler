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
		int upperLimit = 100;
		
		List<Integer> abundant = new ArrayList<>();
		Set<Integer> abundantSums = new HashSet<>();
		
		for (int candidate = 12; candidate < upperLimit - 12; candidate ++) {
			divisors = properDivisors.properDivisors( candidate) ;
			if( sum( divisors ) > candidate) {
				abundant.add(candidate);
			}
		}
		
		// To do: enumerate all sums of 2 abundant numbers
		// Add sums to set
		// enumerate all numbers <= 28123
		// if not in set add to answerSum
		
		for ( int i = 0; i < abundant.size(); i++ ) {
			for ( int j = 0; j < abundant.size(); j++ )
				abundantSums.add( abundant.get(i) + abundant.get(j) );
		}
		
		for ( int i = 24; i < upperLimit; i++ ) {
			if ( abundantSums.contains(1) == false ) {
				grandTotal += i;
			}
		}

		System.out.println( "Total no in set = " + abundant.size() );
		System.out.println( "Total no in Sums set = " + abundantSums.size() );
		System.out.println( abundant.toString() );
		
		// For debug...
		Collections.reverse( abundant );
		System.out.println(abundant.toString() );
		System.out.println("gTotal = " + grandTotal);
		return grandTotal;
	}
	
	int sum(int [] array){
		int total = 0;
		for(int element : array)
			total += element;
		return total;
	}
	

	@Test
	public void test1() {
		assertEquals( 0, nonAbundantSums() );
	}
}
