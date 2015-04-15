package G03;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
/**
 * Strategy: Brute force.
 * @author Harold Almon
 *
 */
public class P027_QuadraticPrimes {
	static Set<Integer> primes;

	public int getProduct(int limit) {
		primes = getPrimes(168);
		
		int sum;
		int max_a = 0;
		int max_b = 0;
		int numOfPrimes;
		int maxNumOfPrimes = 0;
		for (int a = -limit - 1; a < limit; a++) {
			for (int b = -limit + 1; b < limit; b++) {
				numOfPrimes = 0;

				for (int n = 0; n < limit; n++) {
					sum = n*n + a*n + b;
					if ( isPrime(sum) )
						numOfPrimes += 1;
					else
						break;
				}
				if (numOfPrimes > maxNumOfPrimes)  {
					maxNumOfPrimes = numOfPrimes;
					max_a = a;
					max_b = b;
				}
			}
		}
		System.out.printf("max no. of primes = %d, a=%d, b=%d\n", maxNumOfPrimes, max_a, max_b);
		return max_a * max_b;
	}
	private boolean isPrime(int n) {
		return primes.contains(n);
	}
	
	// This function is adapted from P007 so that it
	// wraps the prime numbers in Integer objects
	// and then returns a Set.
	private Set<Integer> getPrimes(int limit) {
		int candidate;
		int primeCount;
		
		Integer primes[] = new Integer[limit];
		
		primes[0] = 2;
		primeCount = 1;
		candidate = 3;

		while (primeCount < limit) {
			boolean isPrime = true;
			// Check the candidate to see if it is divisible by 
			// any of the known primes calculated so far.
			for(int i = 0; i < primeCount; i++) {
				if ( candidate % primes[i] == 0 ) {
					isPrime = false;
					break;
				}
			}

			if (isPrime == true) {
				primes[primeCount] = candidate;
				primeCount += 1;
			}
			candidate += 2;
		}
		// Primes must be Integer wrapped for the HashSet constructor.
		return new HashSet<Integer>( Arrays.asList(primes) );
	}
	@Test
	public void test1() {
		int result = 0;
		result = getProduct(1000);
		System.out.printf("Result=%s\n", result);
		assertEquals( result, -59231);
	}
}
