package com.translationdata.p050;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.Test;

public class P056_PowerfulDigitSum {
  int powerfulDigitSum() {
    System.out.println("P056_PowerfulDigitSum");
    
    Optional<Integer> maxDigitSum = 
        IntStream.range(1,100).flatMap( base -> 
        IntStream.range(1,100).map( exponent -> 
            {
                BigInteger bigBase = new BigInteger(Integer.toString(base));
                return bigBase.pow(exponent).toString().chars().reduce(0,(a, b) -> a + b - '0');
            }
        ))
        .boxed()
        .max(Comparator.naturalOrder());
    
    return maxDigitSum.get();
  }
  
  @Test 
  public void testP056_PowerfulDigitSum() {
	  final P056_PowerfulDigitSum pds = new P056_PowerfulDigitSum();
	  final int result = pds.powerfulDigitSum();
	  assertThat("Incorrect sum.", result, is(972));
	  System.out.println( "Maximum digital sum = " + result );
  }
  
  public static void main(String[] argv, int argc) {
	  System.out.println("Hello");
  };
}
