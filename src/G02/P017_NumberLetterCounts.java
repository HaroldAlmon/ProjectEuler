package G02;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class P017_NumberLetterCounts {
	int Land = "and".length();
	
	static int L1 = "one".length();
	static int L2 = "two".length();
	static int L3 = "three".length();
	static int L4 = "four".length();
	static int L5 = "five".length();
	static int L6 = "six".length();
	static int L7 = "seven".length();
	static int L8 = "eight".length();
	static int L9 = "nine".length();
	
	static List<Integer> digitLen = new ArrayList<Integer>() {
		private static final long serialVersionUID = -8110120484993544128L;

		{ 
			add(L1);
			add(L2);
			add(L3);
			add(L4);
			add(L5);
			add(L6);
			add(L7);
			add(L8);
			add(L9);
		}
	};
	
	@SuppressWarnings("serial")
	static List<Integer> tens = new ArrayList<Integer>() {
		{ 
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
	
	int L1to9 = L1+L2+L3+L4+L5+L6+L7+L8+L9;
	
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
	int L20to99 = 0;
	int L1to99 = 0;
	
	int Lhundred = "hundred".length();
	int Lthousand = "thousand".length();
	
	int Land1to99 = 0;
	
	public int getCount() {
		int result;
		// 20-99
		for( int i : P017_NumberLetterCounts.tens)
			L20to99 += i * 10 + L1to9;
		L1to99 = L1to19 + L20to99;
		result = L1to99;
		Land1to99 = L1to99 + Land * 99;
		
		// 100 - 999
		System.out.printf("AND 1 to 99 = %d%n", Land1to99);
		for( int i : P017_NumberLetterCounts.digitLen)
			result += (i + Lhundred) * 100 + Land1to99;
		
		// 1000
		result += L1 + Lthousand;
		return result;
	}
	@Test
	public void test1() {
		System.out.printf("Count = %d", getCount());
	}
}
