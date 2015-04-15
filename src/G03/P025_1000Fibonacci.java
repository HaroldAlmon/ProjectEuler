package G03;

import java.math.BigInteger;

import org.junit.Test;

public class P025_1000Fibonacci {
	public int getTerm(int limit) {
		int termNo = 2;
		BigInteger temp;
		BigInteger prev = BigInteger.ONE;
		BigInteger sum = BigInteger.ONE;
		while(sum.toString().length() < limit) {
			temp = prev;
			prev = sum;
			sum = sum.add(temp);
			
			termNo += 1;
			//System.out.printf("product=%d\n", sum);
		}
		return termNo;
	}
	
	@Test
	public void test() {
		System.out.printf("term=%d\n",getTerm(1000));
	}
}
