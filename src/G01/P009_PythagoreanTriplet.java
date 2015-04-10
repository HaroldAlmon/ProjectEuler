package G01;

import org.junit.Test;

// Assume x + y + r = sum;
public class P009_PythagoreanTriplet {
	public int product(int sum) {
		int result = 0;
		int x,y,r;
		for (x = 3; x <= sum - 2; x++) {
			for (y = x + 1; y <= sum - 2; y++) {
				r = sum - x - y;
				if (x*x + y *y == r*r) {
					result = x* y*r;
					System.out.printf("Triplet (x, y, r) = (%d,%d,%d)\n", x,y,r);
					return result;
				}
			}
		}
		return result;
	}

	@Test
	public void test1() {
		System.out.printf("product = %d\n",product(1000));
	}
}
