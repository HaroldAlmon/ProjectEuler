package misc;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

// Find the smallest denominator d, having a resilience R(d) < 15499/94744
public class P243_Resilience {
	static boolean debug = false;
	ProperDivisors properDivisors = new ProperDivisors();
	public int getResilience() { 

		//int lowerLimit = 4;
		//int uppperLimit = 10;
		
		int lowerLimit = 7;
		int uppperLimit = 13;
		
		//15499/94744
		
		//int lowerLimit = 15499;
		//int uppperLimit = 94744;
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
				divisors = ProperDivisorsMemoized.properDivisors(numerator);
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
					System.out.printf("Fail: %d/%d >= %d/%d%n", total, denominator-1, lowerLimit, uppperLimit);
					break;
				}
			}

			if ( ((float)total/(denominator-1) < (float)lowerLimit/uppperLimit)) {
				System.out.printf("%d has %d factors%n", denominator, total);
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
	
	public static class ProperDivisorsMemoized {
		private static Map< Integer, Set<Integer>> divisors = new HashMap<Integer, Set<Integer>>();
		public static Set<Integer> properDivisors(int number) {
			if (!divisors.containsKey(number)) {
				divisors.put( number, ProperDivisors.properDivisors(number));
			}
			else
				if( debug) System.out.printf("Returned memo for %d%n", number);
			return divisors.get(number);
		}
		
	}
	
	public static class ProperDivisors {
		public static Set<Integer> properDivisors(int number) {
			Set<Integer> factors = new HashSet<>();
			factors.add( Integer.valueOf(1) );

			int limit = (int) (number/2);
			for (int divisor = 2; divisor <= limit; divisor++) {
				boolean isDivisor;
				
				isDivisor = number % divisor == 0;
				if ( isDivisor ) 
				{
					limit = (int) (number / divisor) - 1;
					addTwoDivisorsToSet(number, factors, divisor);
				}
			}
			return factors;
		}

		private static void addTwoDivisorsToSet(int number, Set<Integer> factors, int divisor) {
			factors.add( Integer.valueOf( divisor ) );
			if ( divisor != number / divisor ) 
				factors.add( Integer.valueOf( number / divisor ) );
		}
	}
}


