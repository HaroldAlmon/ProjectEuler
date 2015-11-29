package com.translationdata.p020;
import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class P025_1000Fibonacci {
	public int getIndex(int limit) {
		final boolean isDebug = false;
		int index = 2;
		BigInteger temp;
		BigInteger prev = BigInteger.ONE;
		BigInteger sum = BigInteger.ONE;
		while(sum.toString().length() < limit) {
			temp = prev;
			prev = sum;
			sum = sum.add(temp);
			
			index += 1;
			if(isDebug)
				System.out.printf("sum = %d%n", sum);
		}
		return index;
	}
	
	@Test(timeout = 500)
	public void test() {
		int index = getIndex(1000);
		System.out.printf("getIndex(1000) = %d%n", index);
		assertEquals(4782, index);
	}
}
