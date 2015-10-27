package G05;


import org.junit.Test;

import G03.P024_LexicographicPermutationsDesc;
import misc.SieveOfEratosthenesBitSet;;

public class P041_PandigitalPrime {
	public int getNumber() {
		int result = -1;
		SieveOfEratosthenesBitSet sieve = new SieveOfEratosthenesBitSet();
		sieve.generatePrimes(2_100_000_000);
		P024_LexicographicPermutationsDesc iter = new P024_LexicographicPermutationsDesc();
		int[] number = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		//int[] number = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		
		result = charArrayToInt(number);
		while ( iter.nextPermutation(number) ) {
			result = charArrayToInt(number);
			if ( sieve.isPrime(result) )
				break;
		}
		return result;
	}
	
	int charArrayToInt(int[] data)
	{
	    int result = 0;
	    for (int i = 0; i < data.length; i++)
	    {
	        int digit = (int) data[i];
	        result *= 10;
	        result += digit;
	    }
	    return result;
	}

	@Test
	public void test() {
		int number;
		P041_PandigitalPrime pandigitalPrime = new P041_PandigitalPrime();
		number = pandigitalPrime.getNumber();
		System.out.printf("number = %d%n", number);
	}
}


