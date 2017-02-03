package com.translationdata.p050;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class P056_PowerfulDigitSum {
  int powerfulDigitSum() {
    System.out.println("P056_PowerfulDigitSum");
    
    final List<Integer> range1to99 = IntStream
    		.rangeClosed(1, 99)
    	    .boxed()
    	    .collect(Collectors.toList());
    
    List<Integer> powers = new ArrayList<Integer>();
    
    for(int base : range1to99) {
        for(int exponent : range1to99) {
    		BigInteger bigBase = new BigInteger(Integer.toString(base));
    		powers.add(stringSum( bigBase.pow(exponent).toString() ) );
        }
    }
    
    return Collections.max(powers).intValue();
  }

  int stringSum(String numberString){
    return stringSumImpl(numberString, 0);
  }
  
  int stringSumImpl(String numberString, int sum) {
      if ( numberString.isEmpty() )
        return sum;
      else
        return stringSumImpl(numberString.substring(1), sum + numberString.charAt(0) - '0');
    }
  
  @Test 
  public void testP056_PowerfulDigitSum() {
	  final P056_PowerfulDigitSum pds = new P056_PowerfulDigitSum();
	  final int result = pds.powerfulDigitSum();
	  assertThat("Incorrect sum.", result, is(972));
	  System.out.println( "Maximum digital sum = " + result );
  }
}
