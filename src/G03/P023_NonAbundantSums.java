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
		int upperLimit = 25; //28123;
		
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
		
		for ( int abNum1 = 0; abNum1 < abundant.size(); abNum1++ ) {
			for ( int abNum2 = 0; abNum2 < abundant.size(); abNum2++ )
				if ( abundant.get(abNum1) + abundant.get(abNum2) < upperLimit ) 
					abundantSums.add( abundant.get(abNum1) + abundant.get(abNum2) );
				else
					break;
		}

		System.out.println( "Total no in set = " + abundant.size() );
		System.out.println( "Total no in Sums set = " + abundantSums.size() );
		System.out.println( abundant.toString() );
		System.out.println( "Sums = " + abundantSums.toString() );
		
		// For debug...
		Collections.reverse( abundant );
		System.out.println(abundant.toString() );
		
		for ( int candidate = 1; candidate < upperLimit; candidate++ ) {
			if ( abundantSums.contains(candidate) == false ) {
				grandTotal += candidate;
				System.out.println("Added: " + candidate);
			}
		}
		
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
