package G03;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P029_DistinctPowers {
	public int distinctPowers(int upperLimit) {
		BigInteger limit = new BigInteger(String.valueOf(upperLimit));
		Set<String> powers = new HashSet<String>();
		BigInteger a = new BigInteger("2");
		BigInteger one = new BigInteger("1");
		BigInteger power;
		
		while( a.compareTo(limit) != 1 ) {
			for( int b = 2; b <= upperLimit; b++ ) {
				power = a.pow(b);
				powers.add(power.toString());
			}
			a = a.add(one);
		}
		
		return powers.size();
	}

	@Test
	public void DistinctPowers() {
		System.out.printf("%d%n", distinctPowers(100));
	}
}
