package G05;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import G03.P024_LexicographicPermutations;

public class P043_SubstringDvisibility {
	public long getSum() {
		P024_LexicographicPermutations lexiPerm = new P024_LexicographicPermutations();
		long candidateSum = 0;
		final int[] candidate = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		do {
			if (isPrimeMatch( candidate ) ) {
				candidateSum += intArrayToLong( candidate, 0, 9 );
			}
		} while ( lexiPerm.nextPermutation( candidate ) == true );
		return candidateSum;
	}

	private boolean isPrimeMatch( int[] candidate ) {
		if (intArrayToLong(candidate, 1, 3) % 2 == 0
		&& intArrayToLong(candidate, 2, 4) % 3 == 0 
		&& intArrayToLong(candidate, 3, 5) % 5 == 0 
		&& intArrayToLong(candidate, 4, 6) % 7 == 0 
		&& intArrayToLong(candidate, 5, 7) % 11 == 0 
		&& intArrayToLong(candidate, 6, 8) % 13 == 0 
		&& intArrayToLong(candidate, 7, 9) % 17 == 0 )
			return true;
		else
			return false;
	}

	long intArrayToLong(int[] data, int start, int end) {
		long result = 0;
		for ( int digitPosition = start; digitPosition <= end; digitPosition += 1 ) {
			int digit = (int) data[digitPosition];
			result *= 10;
			result += digit;
		}
		return result;
	}

	@Test ( timeout = 5_000 )
	public void substringDvisibility() {
		long sum = getSum();
		System.out.printf( "sum = %d%n", sum );
		assertEquals( Long.toString(sum), "16695334890" );
	}
}
