package G02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static G01.Formatter.errorText;

// ProjectEuler.net problem 12
public class P012_TriangularNumber {
 
	long getNumber(int factors) {
		int n = 2;
		long sum = 3;
		int count = 0;
		while (true) {
			count = getCount(sum);
			if (count > 500) 
				break;
			n += 1;
			sum += n;
		};
		System.out.printf("no. of factors = %d, Triangle seq no. = %d\n",count , n);
		return sum;
	}
	int getCount(long n) {
		int result = 0;
		int limit = (int) (n/2);
		for (int i = 2; i <= limit; i++) {
			if (n % i == 0) 
			{
				result += 2;
				limit = (int) (n / i) - 1;
			}
		}
		return result + 2;
	}

	@Test(timeout = 2_000)
	public void test1() {
		long result = getNumber(500);
		System.out.printf("Result = %d", result);
		assertEquals( errorText("Incorrect count"), 76576500, result );
	}
}
