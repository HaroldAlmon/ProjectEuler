package G05;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import G03.P024_LexicographicPermutationsDesc;
//import misc.SieveOfEratosthenesBitSet;;

public class P041_PandigitalPrime {
	public long getNumber() {
		long result = -1;
		//SieveOfEratosthenesBitSet sieve = new SieveOfEratosthenesBitSet();
		//sieve.generatePrimes(Integer.MAX_VALUE -1);
		P024_LexicographicPermutationsDesc iter = new P024_LexicographicPermutationsDesc();
		//int[] number = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] number = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		//int[] number = { 3, 1, 0 };
		
		do {
			result = charArrayToLong( number );
			if ( isPrime( result ) )
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
	
	long charArrayToLong( int[] data )
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
	
	private boolean isPrime( long number ) {
		return ( (( number - 1 ) % 6) == 0 ) || ( ( ( number + 1 ) % 6 ) == 0 );
	}

	@Test
	public void test() {
		long number;
		P041_PandigitalPrime pandigitalPrime = new P041_PandigitalPrime();
		number = pandigitalPrime.getNumber();
		System.out.printf( "number = %010d%n", number );
		assertEquals( number, 1286608609 );
	}
	
	//@Test
	public void test2() {
		//int[] number = { 4, 2, 1, 0 };
		int[] number = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		P024_LexicographicPermutationsDesc iter = new P024_LexicographicPermutationsDesc();
		
		long result = charArrayToInt(number);
		do {
			result = charArrayToInt( number );
			System.out.printf("%010d%n", result);
			//if ( isPrime( result ) )
				//break;
		} while ( iter.nextPermutation(number) );
	}
	@Test
	public void TestPrimes() {
		for (int i = 4; i <= 100; i ++)
			if (isPrime(i)) 
				System.out.printf("%d is prime%n", i);
	}
}


