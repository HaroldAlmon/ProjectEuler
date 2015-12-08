package com.translationdata.p010;
/** Strategy: Simple Mathematics */
import org.junit.Test;

public class P014_CollatzSequence {
	public long collatzSequence(int upperLimit) {
		long numberProducingLongestChain = 0;

		numberProducingLongestChain = enumerateCandidates(upperLimit,numberProducingLongestChain);
		return numberProducingLongestChain;
	}
	
	private long enumerateCandidates(final int upperLimit, final long number) {
		long numberProducingLongestChain = number;
		for (long candidate = 2; candidate < upperLimit - 1; candidate++) {
			long longestSequence = 0;
			int sequenceLength = 1;
			sequenceLength = calculateSequenceLength(sequenceLength, candidate);
			if (sequenceLength > longestSequence) {
				longestSequence = sequenceLength;
				numberProducingLongestChain = candidate;
			}
		}
		return numberProducingLongestChain;
	}
	
	private int calculateSequenceLength(final int length, final long candidate) {
		int sequenceLength = length;
		// n is an alias for candidate...
		long n = candidate;
		while (n != 1) {
			if (n % 2 == 0)
				n /= 2;
			else
				n = 3 * n + 1;
			sequenceLength += 1;
		};
		return sequenceLength;
	}

	@Test(timeout = 20_000)
	public void NumberProducingLongestChain() {
		System.out.printf("numberProducingLongestChain(1_000_000) = %d%n",collatzSequence(1_000_000));
	}
}
