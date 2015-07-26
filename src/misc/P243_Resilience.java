package misc;
import java.util.Set;
import org.junit.Test;

/**
 * @author Harold Almon
 * Status of this problem:
 * At this point the code solves the problem for R(11) < 4/10
 * but for R(94744) no solution was found after running for 
 * two hours and reaching R(271,000).
 * 
 * Strategy: Get the proper factors of the numerator and the denominator,
 * Check to see if the factors of the numerator are in the denominator,
 * if true, the fraction is not resilient.
 */

// Find the smallest denominator d, having a resilience R(d) < 15499/94744
public class P243_Resilience {
	static boolean debug = false;
	ProperDivisors properDivisors = ProperDivisors.INSTANCE;
	public int getResilience() { 

		//int lowerLimit = 7;
		//int uppperLimit = 20;
		
		//int lowerLimit = 7;
		//int uppperLimit = 13;
		
		//15499/94744
		
		int lowerLimit = 15499;
		int uppperLimit = 94744;
		int denominator = uppperLimit;

		int total = 1;

		while ( true ) {
			Set<Integer> divisors;
			Set<Integer> denominatorSet;

			denominatorSet = properDivisors.properDivisors( denominator );
			if (debug) System.out.printf("-----> Denominator set = %s%n", denominatorSet);

			if (denominator % 1_000 == 0) System.out.printf("Candidate denominator = %s%n", denominator);
			for (int numerator=2; numerator < denominator; numerator++) {
				if (debug) System.out.printf("numerator = %s%n",numerator);
				divisors = properDivisors.properDivisorsMemo(numerator);
				if (debug) System.out.printf("numerator set = %s%n", divisors);
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
				
				if ( checkRatioRequired  && ( (float )total/(denominator-1)) >= ((float)lowerLimit/uppperLimit)) {
					if (debug) System.out.printf("Fail: %d/%d >= %d/%d%n", total, denominator-1, lowerLimit, uppperLimit);
					break;
				}
			}

			if ( ((float)total/(denominator-1) < (float)lowerLimit/uppperLimit) ) {
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
	public void ResilienceTest() {
		int result;
		result = getResilience();
		System.out.printf("Resilience = %s%n", result);
	}
}


