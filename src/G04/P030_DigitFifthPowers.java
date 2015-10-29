package G04;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class P030_DigitFifthPowers {
	private static final int MAX_POWER = 5;
	private static final int MAX_NUM_LEN = 6;
	private int numLen = 0;
	List<Integer> digitFifths;
	Integer[] number = new Integer[MAX_NUM_LEN];

	@SuppressWarnings("serial")
	Map<Integer, Integer> powerLookup = new HashMap<Integer, Integer>() {{
		this.put(0, 0);
		this.put(1, 1);
		this.put(2, (int) Math.pow((double)2,(double)MAX_POWER));
		this.put(3, (int) Math.pow((double)3,(double)MAX_POWER));
		this.put(4, (int) Math.pow((double)4,(double)MAX_POWER));
		this.put(5, (int) Math.pow((double)5,(double)MAX_POWER));
		this.put(6, (int) Math.pow((double)6,(double)MAX_POWER));
		this.put(7, (int) Math.pow((double)7,(double)MAX_POWER));
		this.put(8, (int) Math.pow((double)8,(double)MAX_POWER));
		this.put(9, (int) Math.pow((double)9,(double)MAX_POWER));
	}};
	
	@Test(timeout = 10000)
	public void main() {
		int sum = -1;
		for(int i=1; i <= MAX_NUM_LEN; i++) {
			numLen = i;
			sum += getSum();
		}
		System.out.printf("Result = %s\n", sum);
		assertEquals("Sum is incorrect, ", 443839, sum);
	}

	public int getSum() {
		int result = 0;
		digitFifths = new ArrayList<>();
		calcNumbers(0);

		for (Integer integer : digitFifths) {
			result += integer;
		}
		return result;
	}

	private void calcNumbers(int digitPos) {
		if (digitPos >= numLen) {
			StringBuilder digitSum = new StringBuilder("");
			for (int pos = 0; pos < numLen; pos++) {
				digitSum.append(number[pos]);
			}
			if ( isFifth(digitSum) == true ) {
				digitFifths.add(Integer.parseInt(digitSum.toString(), 10));
			}
			return;
		}
		for (int digit = 0; digit < 10; digit++) {
			number[digitPos] = digit;
			calcNumbers(digitPos + 1);
		}
	}
	private boolean isFifth(StringBuilder digitSum) {
		int powerSum = 0;
		for (int i = 0; i < numLen; i++) {
			powerSum += powerLookup.get( number[i] ).intValue();
		}
		return Integer.toString(powerSum).equals(digitSum.toString());
	}
}
