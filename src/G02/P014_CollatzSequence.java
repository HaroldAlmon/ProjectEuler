package G02;

import org.junit.Test;

public class P014_CollatzSequence {
	public long getLength(int upperLimit) {
		long result = 0;
		long longest = 0;
		int length;
		for (long num = 2; num < upperLimit - 1; num++) {
			length = 1;
			long n = num;
			while (n != 1) {
				if (n % 2 == 0)
					n /= 2;
				else
					n = 3 * n + 1;
				length += 1;
			}
			if (length > longest) {
				longest = length;
				result = num;
			}
		}
		return result;
	}
	@Test
	public void test1() {
		System.out.printf("%d",getLength(1_000_000));
	}
}
