package misc;
import java.util.Set;
import org.junit.Test;

/**
 * @author Harold Almon
 * Status of this problem:
 * At this point the code solves the problem for R(12) < 4/10
 * but for R(94744) no solution was found after running for 
 * two hours and reaching R(271,000).
 * 
 * Strategy: Get the proper factors of the numerator and the denominator,
 * Check to see if the factors of the numerator are in the denominator,
 * if true, the fraction is not resilient.
 */

// Find the smallest denominator d, having a resilience R(d) < 15499/94744
public class P243_Resilience {
	static boolean debug = true;
	ProperDivisors properDivisors = ProperDivisors.INSTANCE;
	public int getResilience(int lowerLimit, int uppperLimit) { 

		//15499/94744
		int denominator = uppperLimit;
		
		// 1/N is always resilient, so start total at 1
		int total = 1;

		System.out.printf("Generated 10,000 primes...%n");
		
		// TODO:  Call a function to get the first 10,000 prime numbers.
		// Create the new function in P007.
		Set<Integer> primeSet = null;
		//Set<Integer> primeSet = properDivisors.properDivisorsSet(10_000);

		while ( true ) {
			// **** IF denominator is PRIME then next denominator ****
			Set<Integer> divisors;
			Set<Integer> denominatorSet;

			denominatorSet = properDivisors.properDivisorsSet( denominator );
			if (debug) System.out.printf("-----> Denominator set = %s%n", denominatorSet);
			int numerator;

			if ( debug && denominator == 94770 ) { 
				System.out.printf("%d%n", denominator);
			}

			if (denominator % 1_000 == 0) {
				System.out.printf("Candidate denominator = %s%n", denominator);
				System.exit(0);
			}

			for (numerator=2; numerator < denominator; numerator++) {
				if ( debug && numerator == 94769 ) { 
					System.out.printf("num == %d %n", numerator); 
				}

				// If the numerator OR DENOMINATOR a prime number, the fraction cannot be cancelled so there is 
				// no need to check if the fraction is resilient.
				if ( primeSet.contains(numerator) ) {
					total += 1;
					continue;
				}
				// TODO: check denominator for prime number

				if (debug) 
					System.out.printf("numerator = %s%n",numerator);
				divisors = properDivisors.properDivisorsMemo(numerator);

				boolean resilientFraction = true;

				resilientFraction = isResilientFraction(divisors, denominatorSet, numerator, resilientFraction);
				total = logFractionEvaluation(denominator, total, numerator, resilientFraction);
				
				// Check if ratio is too big...
				//boolean checkRatioRequired;
				//checkRatioRequired = total >= lowerLimit;
				if ( ( (double )total/(denominator-1)) >= ((double)lowerLimit/uppperLimit)) {
					//if (denominator == 94770 ) System.out.printf("Fail: %d/%d >= %d/%d%n", total, denominator - 1, lowerLimit, uppperLimit);
					if (debug) System.out.printf("Fail: %d/%d >= %d/%d%n", total, denominator - 1, lowerLimit, uppperLimit);
					break;
				}
			}

			if ( isRatioLessThanTargetFraction( total, denominator, lowerLimit, uppperLimit) ) {
				System.out.printf("numerator = %s%n", numerator);
				System.out.printf("%d has %d factors%n", denominator, total);
				System.out.printf("%d / %d  < %d / %d%n", total, denominator - 1, lowerLimit, uppperLimit);
				break;
			}

			if (debug) System.out.printf("======%n");
			denominator += 1;
			total = 1;
		}
		return denominator;
	}

	private int logFractionEvaluation(int denominator, int total,
			int numerator, boolean resilientFraction) {
		if ( resilientFraction == true ) {
			total += 1;
			if ( debug ) System.out.printf("%d / %d is resilient%n", numerator, denominator);
		}
		else
			if ( debug ) System.out.printf("%d / %d is not resilient%n", numerator, denominator);
		
		if ( debug ) System.out.printf( "total = %s%n", total );
		return total;
	}

	private boolean isResilientFraction(Set<Integer> divisors,
			Set<Integer> denominatorSet, int numerator,
			boolean resilientFraction) {
		if ( denominatorSet.contains( Integer.valueOf( numerator ) ) == true ) {
			resilientFraction = false;
		} else {
			for( Integer divisor : divisors) {

				if ( denominatorSet.contains( divisor ) && divisor != 1 ) {
					resilientFraction = false;
				}
			}
		}
		return resilientFraction;
	}

	private boolean isAllFractionsChecked(int denominator, int numerator) {
		return numerator == denominator;
	}

	private boolean isRatioLessThanTargetFraction( int total, int denominator, int lowerLimit, int uppperLimit ) {
		return ( float ) total/(denominator-1) < ( float ) lowerLimit / uppperLimit;
	}
	
	@Test
	public void ResilienceTest() {
		int result;
		int lowerLimit = 4;
		int uppperLimit = 10;

		//int lowerLimit = 15499;
		//int uppperLimit = 94744;
		result = getResilience( lowerLimit, uppperLimit );
		System.out.printf( "Resilience = %s%n", result );
	}
}


