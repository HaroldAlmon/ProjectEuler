package G03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P021_AmicableNumbers {
	Set<Integer> amis = new HashSet<>();
	public int getSum(int n) {
		int result = 0;
		int ami = 0;
		for (int i = 2; i < n; i++) {
			if (!amis.contains(i)) {
				ami = getAmi(i);
				if (ami != 0 && ami != i) {
					// Add the ami to the set so we do not use it in the for-loop...
					amis.add(ami);
					result += i + ami;
					System.out.printf("ami=(%d,%d)\n", i, ami);
				}
			}
		}
		return result;
	}
	private int getAmi(int n) {
		int result = 0;
		int sum = 0;
		int ami;
		ami = getFactorsSum(n);
		sum = getFactorsSum(ami);
		if (n == sum ){
			result = ami;
		}
		return result;
	}
	
	private int getFactorsSum(int n) {
		int result = 0;
		int[] factors = getProperDivisors(n);
		for (int i = 0; i < factors.length; i++) {
			result += factors[i];
		}
		//System.out.printf("sum = %s\n", result);
		return result;
	}
	private int[] getProperDivisors(int n) {
		int [] factors = new int[5000];
		int factorsPos = 1;
		
		factors[0] = 1;
		
		@SuppressWarnings("unused")
		int[] result;
		int limit = (int) (n/2);
		for (int i = 2; i <= limit; i++) {
			if (n % i == 0) 
			{
				//result += 2;
				limit = (int) (n / i) - 1;
				factors[factorsPos] = i;
				factors[factorsPos+1] = n / i;
				factorsPos += 2;
			}
		}
		result = Arrays.copyOf(factors, factorsPos);
		//System.out.printf("factors = %s\n", Arrays.toString(result));
		return Arrays.copyOf(factors, factorsPos);
	}
	@Test
	public void test1() {

		System.out.printf("sum = %s\n", getSum(10000));
	}
}
