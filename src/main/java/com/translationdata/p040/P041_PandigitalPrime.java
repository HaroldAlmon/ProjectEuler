package com.translationdata.p040;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.function.Function;

import org.junit.Test;

import com.translationdata.p020.P024_LexicographicPermutationsDesc;
import com.translationdata.util.SieveOfEratosthenes;

public class P041_PandigitalPrime {
	public long getNumber() {
		int result = -1;
		SieveOfEratosthenes sieve = new SieveOfEratosthenes();
		sieve.generatePrimes(10_000_000);
		P024_LexicographicPermutationsDesc iter = new P024_LexicographicPermutationsDesc();
		int[] number = { 7, 6, 5, 4, 3, 2, 1 };
		
		do {
			result = charArrayToInt( number );
			if ( sieve.isPrime( result ) )
				break;
		} while ( iter.nextPermutation(number) );
		return result;
	}
	
	int charArrayToInt( int[] data )
	{
	    int result = 0;
	    for ( int i = 0; i < data.length; i += 1 )
	    {
	        int digit = (int) data[i];
	        result *= 10;
	        result += digit;
	    }
	    return result;
	}
	
	long intArrayToLong( int[] data )
	{
	    long result = 0;
	    for ( int i = 0; i < data.length; i += 1 )
	    {
	        int digit = (int) data[i];
	        result *= 10;
	        result += digit;
	    }
	    return result;
	}
	
	private PrintStream printMessages( Function<Void, PrintStream> function ) {
        return function.apply(null);
	}

	@Test
	public void test() {
		long number;
		P041_PandigitalPrime pandigitalPrime = new P041_PandigitalPrime();
		number = pandigitalPrime.getNumber();
		
		// print messages
		System.out.printf( "1. number = %d%n", number );
		System.out.printf( "2. number = %d%n", number );
		
		
		printMessages( (Void v) -> 
		{ 
		    System.out.printf( "3. number = %d%n", number );
		    return System.out.printf( "4. number = %d%n", number);
		} );
		assertEquals( 7652413, number );
	}
}


