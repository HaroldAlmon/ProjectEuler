package G02;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P017_NumberLetterCounts {
	int Land = "and".length();
	
	@SuppressWarnings("serial")
	static List<Integer> digitLen = new ArrayList<Integer>() {
		{
			// TODO: USe Arrays.asList() instead
			add("one".length());
			add("two".length());
			add("three".length());
			add("four".length());
			add("five".length());
			add("six".length());
			add("seven".length());
			add("eight".length());
			add("nine".length());
		};
	};
	
	@SuppressWarnings("serial")
	static List<Integer> tens = new ArrayList<Integer>() {
		{ 
			// TODO: USe Arrays.asList() instead
			add("twenty".length());
			add("thirty".length());
			add("forty".length());
			add("fifty".length());
			add("sixty".length() );
			add("seventy".length());
			add("eighty".length());
			add("ninety".length());
		}
	};

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
		System.out.printf("countLetters() = %d%n", letterCount);
		assertEquals( 43945, letterCount );
	}
}
