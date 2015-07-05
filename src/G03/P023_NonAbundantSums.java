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
	public int nonAbundantSums() {
		int[] divisors;
		List<Integer> abundant= new ArrayList<>();
		Set<Integer> abundantSums= new HashSet<>();
		
		for (int candidate = 12; candidate < 28123 - 12; candidate ++) {
			divisors = properDivisors.properDivisors(candidate);
			if( sum(divisors) > candidate) {
				abundant.add(candidate);
			}
		}
		
		// To do: enumerate all sums of 2 abundant numbers
		// Add sums to set
		// enumerate all numbers <= 28123
		// if not in set add to answerSum

		System.out.println("Total no in set = " + abundant.size() );
		System.out.println(abundant.toString());
		Collections.reverse(abundant);
		System.out.println(abundant.toString());
		return 1;
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
