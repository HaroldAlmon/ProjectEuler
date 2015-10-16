package G04;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import misc.PrimeNumbers;

public class P035_CircularPrimes {
	public int circularPrimeCount() {
		int primeMax = 30_000;
		Set<Integer> primes = new HashSet<Integer>();
		Set<Integer> circularPrimes = new HashSet<Integer>();
		Set<Integer> checked = new HashSet<Integer>();
		PrimeNumbers numberGenerator = new PrimeNumbers();
		
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		System.out.printf("time = %s%n", timeStamp );

		primes = numberGenerator.primeNumberSet(primeMax);
		
		timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Primes generated");
		System.out.printf("time = %s%n", timeStamp );

		
		for( int n = 1; n < primeMax; n += 1) {
			if ( checked.contains(n) == false ) {
				Set<Integer> rotations = new HashSet<Integer>();
				rotations = getAllRotations(n);
				Iterator<Integer> iterator = rotations.iterator();
				while(iterator.hasNext()) {
					Integer num = iterator.next();
					if (primes.contains(num) == false) 
						break;
					
					if (iterator.hasNext() == false) {
						circularPrimes.addAll(rotations);
						//System.out.println( rotations.toString() );
					}
				}
				checked.addAll(rotations);
			}
		}
		timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		System.out.printf("time = %s finished%n", timeStamp );
		
		return circularPrimes.size();
	}
	private Set<Integer> getAllRotations(int n) {
		Set<Integer> rotations = new HashSet<Integer>();
		String number = Integer.toString(n);
		for(int i = 0; i < number.length(); i += 1) {
			rotations.add( Integer.parseInt(number) );
			number = number.substring(number.length() - 1, number.length()) + number.substring(0, number.length() - 1 );
		}
		return rotations;
	}

/*	for n = 1 to 999,999
			if n is not previously checked
				r = getAllRotations(n)
				foreach n in r
					if n is is not prime
						break
					end if
					if last n 
						primeSet.addAll(r)
					end if
				end foreach
				checked.add(all r)
			end if
		end for*/
	
	@Test 
	public void runTest() {
		int primeCount = circularPrimeCount();
		System.out.printf("Circular Prime Count = %d%n", primeCount);
	}

}
