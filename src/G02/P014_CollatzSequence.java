package G02;

import org.junit.Test;

public class P014_CollatzSequence {
	public long numberProducingLongestChain(int upperLimit) {
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
	@Test(timeout = 20_000)
	public void NumberProducingLongestChain() {
		System.out.printf("numberProducingLongestChain(1_000_000) = %d%n",numberProducingLongestChain(1_000_000));
	}
}
