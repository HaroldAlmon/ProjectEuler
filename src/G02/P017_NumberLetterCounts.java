package G02;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class P017_NumberLetterCounts {
	int Land = "and".length();
	
	static List<Integer> digitLen = Arrays.asList( new Integer[] {
		"one".length(),
		"two".length(),
		"three".length(),
		"four".length(),
		"five".length(),
		"six".length(),
		"seven".length(),
		"eight".length(),
		"nine".length()
	});

	static List<Integer> tens = Arrays.asList(new Integer[] {
		"twenty".length(),
		"thirty".length(),
		"forty".length(),
		"fifty".length(),
		"sixty".length(),
		"seventy".length(),
		"eighty".length(),
		"ninety".length()
	});

	int L1to9 = sum1to9(digitLen);

	private int sum1to9(List<Integer> digitLen) {
		List<Integer> d = digitLen;
		return d.get(0)+d.get(1)+d.get(2)+d.get(3)+d.get(4)+d.get(5)+d.get(6)+d.get(7)+d.get(8);
	}

	int L10to19= 
		"ten".length() +
		"eleven".length() +
		"twelve".length() +
		"thirteen".length() +
		"fourteen".length() +
		"fifteen".length() +
		"sixteen".length() +
		"seventeen".length() +
		"eighteen".length() +
		"nineteen".length();
	
	int L1to19 = L1to9 + L10to19;
	int L1to99 = 0;
	
	int Lhundred = "hundred".length();
	int Lthousand = "thousand".length();
	
	int Land1to99 = 0;
	
	public int numberLetterCounts() {
		int result = 0;

		L1to99 = sum1To99();
		Land1to99 = sumAnd1To99();

		result = L1to99;
		result += sum100to999(result);
		result += lengthOf1000(result);
		return result;
	}
	private int sumAnd1To99() {
		return L1to99 + Land * 99;
	}
	private int sum1To99() {
		return L1to19 + sum20to99();
	}
	private int lengthOf1000(int result) {
		result += digitLen.get(0) + Lthousand;
		return result;
	}
	private int sum100to999(int result) {
		for( int i : digitLen)
			result += (i + Lhundred) * 100 + Land1to99;
		return result;
	}
	private int sum20to99() {
		int L20to99 = 0;
		for( int i : P017_NumberLetterCounts.tens)
			L20to99 += i * 10 + L1to9;
		return L20to99;
	}

	@Test
	public void CountLetters() {
		int letterCount = numberLetterCounts();
		System.out.printf("numberLetterCounts() = %d%n", letterCount);
		assertEquals( 43945, letterCount );
	}
}
