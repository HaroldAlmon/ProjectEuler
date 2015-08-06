package misc;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

// Find the smallest denominator d, having a resilience R(d) < 15499/94744
public class P243_Resilience {
	static boolean debug = false;
	ProperDivisors properDivisors = ProperDivisors.INSTANCE;
	public int getResilience() { 

		//int lowerLimit = 7;
		//int uppperLimit = 20;
		
		//int lowerLimit = 4;
		//int uppperLimit = 10;
		
		//15499/94744
		
		int lowerLimit = 15499;
		int uppperLimit = 94744;
		int denominator = uppperLimit;

		int total = 1;
		PrimeNumbers primeNumbers = new PrimeNumbers();
		Set<Integer> primeSet = primeNumbers.primeNumberSet(10_000);
		System.out.printf("Generated primes...%n");

		while ( true ) {
			Set<Integer> divisors;
			Set<Integer> denominatorSet;

			denominatorSet = properDivisors.primeNumberSet( denominator );
			if (debug) System.out.printf("-----> Denominator set = %s%n", denominatorSet);
			int numerator;
			if ( denominator == 94770 ) { 
				System.out.printf("%d%n", denominator);
			}
			if (denominator % 1_000 == 0) {
				System.out.printf("Candidate denominator = %s%n", denominator);
				System.exit(0);
			}
			for (numerator=2; numerator < denominator; numerator++) {
				if ( numerator == 94769 ) { 
					System.out.printf("num == %d %n", numerator); 
				}
				if ( primeSet.contains(numerator) ) {
					total = 1;
					continue;
				}

				if (debug) System.out.printf("numerator = %s%n",numerator);
				divisors = properDivisors.properDivisorsMemo(numerator);
				//if (debug) System.out.printf("numerator set = %s%n", divisors);
				boolean resilientFraction = true;

				if ( denominatorSet.contains( Integer.valueOf( numerator ) ) == true) {
					resilientFraction = false;
				} else {
					for( Integer divisor : divisors) {
	
						if (denominatorSet.contains(divisor) && divisor != 1) {
							resilientFraction = false;
						}
					}
				}

				if ( resilientFraction == true )
					total += 1;
				
				if (debug) System.out.printf("total = %s%n",total);
				
				// Check if ratio is too big...
				boolean checkRatioRequired;
				checkRatioRequired = total >= lowerLimit;
				
				if ( ( (double )total/(denominator-1)) >= ((double)lowerLimit/uppperLimit)) {
					//if (denominator == 94770 ) System.out.printf("Fail: %d/%d >= %d/%d%n", total, denominator - 1, lowerLimit, uppperLimit);
					if (debug) System.out.printf("Fail: %d/%d >= %d/%d%n", total, denominator - 1, lowerLimit, uppperLimit);
					break;
				}
			}

			if ( ((double)total / (denominator-1)) < ((double)lowerLimit / uppperLimit )) {
				System.out.printf("numerator = %s%n", numerator);
				System.out.printf("%d has %d factors%n", denominator, total);
				System.out.printf("%d / %d  < %d / %d%n", total, denominator - 1, lowerLimit, uppperLimit);
				break;
			}

			denominator += 1;
			total = 1;
		}
		return denominator;
	}
	
	@Test
	public void test1() {
		int result;
		result = getResilience();
		System.out.printf("Resilience = %s%n", result);
	}
}


