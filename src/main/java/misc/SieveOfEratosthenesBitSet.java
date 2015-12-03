package misc;

import java.util.BitSet;

import org.junit.Test;

public class SieveOfEratosthenesBitSet {
	private BitSet primes;

	public int generatePrimes(int n) {
		primes = new BitSet(n + 1);

		for (int position = 2; position <= n; position += 1) {
			primes.set(position);
		}
		
		int upperBound = (int) Math.floor(Math.sqrt( n ));
		
		for (int primeNumber = 2; primeNumber <= upperBound; primeNumber += 1) {
			if( primes.get(primeNumber) == true) {
				for( int notPrime = primeNumber * primeNumber; notPrime <= n; notPrime += primeNumber)
					primes.clear(notPrime);
			}
		}
		
		int count = 0;
		for( int position = 2; position <= n; position += 1) {
			if(primes.get(position) == true) {
				count += 1;
			}
		}
		System.out.printf("Generated %d primes%n", count);
		return count;
	}
	
	public SieveOfEratosthenesBitSet(int n) {
		generatePrimes(n);
	}
	
	public boolean isPrime(int n) {
		return primes.get(n);
	}
	
	@Test
	public void runtest() {
		final int upperLimit = 100;
		generatePrimes(upperLimit);
		for(int number = 2; number <= upperLimit; number += 1) {
			if( isPrime(number) )
				System.out.printf("%d%n", number);
			
		}
	}
}
