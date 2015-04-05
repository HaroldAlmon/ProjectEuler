package G01;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/* 10001st prime, Problem 7
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
What is the 10 001st prime number? */

public class P007_10001PrimeLinkList {
	static int testNo = 1;

	public static void main(String[] args) {
		P007_10001PrimeLinkList main = new P007_10001PrimeLinkList();
		System.out.print( "prime=" + main.run(10_001));
	}
	
	private long run(int limit) {
		int candidate;
		List<Integer> primes = new LinkedList<>();
		primes.add(2);
		primes.add(3);
		candidate = 5;

		while (primes.size() < limit) {
			boolean isPrime = true;
			
			// Boxing takes longer, use an array instead
			Iterator<Integer> primeIter = primes.iterator();
			while(primeIter.hasNext()) {
				if ( (candidate % (primeIter.next())) == 0 ) {
					isPrime = false;
					break;
				}
			}
			if (isPrime == true) {
				primes.add(candidate);
			}
			candidate += 2;
		}

		return primes.get(limit - 1);
	}

	@Before
	public void before() {
		System.out.printf("Running unit test...%d\n", testNo);
		testNo += 1;
	}

	@Test
	public void test1() {
		assertTrue( run(10_001) == 104_743 );
	}
	
	@Test
	public void test2() {
		assertTrue( run(6) == 13 );
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Starting unit test.");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Unit test completed.");
	}
}

