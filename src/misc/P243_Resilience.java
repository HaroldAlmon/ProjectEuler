package misc;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import G03.P021_AmicableNumbers.ProperDivisors;

// Find the smallest denominator d, having a resilience R(d) < 15499/94744
public class P243_Resilience {
	ProperDivisors properDivisors = new ProperDivisors();
	public int getResilience() { 
		int lowerLimit = 4;
		int uppperLimit = 10;
		int candidate = 11;
		int total = 0;

		while ( candidate < 14 ) {
			int[] divisors;


			Set<Integer> denominatorSet;
			divisors = properDivisors.properDivisors( candidate );
			System.out.printf("denominator set = %s%n", Arrays.toString(divisors));
			//denominatorSet = new HashSet<Integer>( Arrays.asList(divisors) );
			denominatorSet = new HashSet<Integer>();
			for(int i : divisors) {
				denominatorSet.add(Integer.valueOf(i));
			}

			System.out.printf("Candidate denominator = %s%n", candidate);
			for (int i=2; i < candidate; i++) {
				System.out.printf("numerator = %s%n",i);
				divisors = properDivisors.properDivisors(i);
				System.out.printf("numerator set = %s%n", Arrays.toString(divisors));
				boolean proper = true;

				if ( denominatorSet.contains( Integer.valueOf( i ) ) == true) {
					proper = false;
				} else {
					for( Integer divisor : divisors) {
	
						if (denominatorSet.contains(divisor) && divisor != 1) {
							proper = false;
						}
					}
				}

				if ( proper == true )
					total += 1;
				
				System.out.printf("total = %s%n",total);
				// Too many
				/*if (total >= lowerLimit) {
					System.out.printf("Too many break %s%n");
					break;
				}*/
				
				// Check if ratio is too big...
				if (( (float )total/(candidate-1)) >= ((float)lowerLimit/uppperLimit)) {
					break;
				}
				//break;
			}

			if ((float)total/(candidate-1) < (float)lowerLimit/uppperLimit) {
				break;
			}

			candidate += 1;
			total = 0;
		}
		return candidate;
	}
	
	@Test
	public void test1() {
		int result;
		result = getResilience();
		System.out.printf("Resilience = %s\n", result);
	}
}


