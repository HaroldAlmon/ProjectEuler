package misc;

import static org.junit.Assert.assertEquals;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class P092_SquareDigitChanges {
	public int squareDigitChanges(int number) {
		int result = 0;
		
		for (int i = 1; i < number; i++) {
			if (is89loop(i))
				result += 1;
		}
		return result;
	}
	
	private boolean is89loop (int number ) {
		int total = 0;
		int digit = 0;
		
		String s = Integer.toString((number));
		
		total = number;
		while (total != 1 ) {
			s = Integer.toString((total));
			//System.out.printf("Number = %s\n", s);
			total = 0;
			for (int i = 0; i < s.length(); i++) {
				//System.out.printf("char = %s\n", s.substring(i, i + 1));
				//digit = Integer.parseInt(s.substring(i, i + 1)); // Slow, uses substring
				//digit = Character.getNumericValue(s.charAt(i)); // Faster, uses wrapper class function
				digit = (int) s.charAt(i) & 0x0000_000F; // Fastest, uses bitwise AND
				total += digit * digit;
			}
			if (is89cycle(total))
			{
				//System.out.printf("%d, 89 loop\n",number);
				return true;
			}
		}
		//System.out.printf("%d, 1 loop\n",number);
		return false;
	}
	
	private static Set<Integer> loopNums = new HashSet<Integer>() {
		private static final long serialVersionUID = 8510317940825586317L;
		{
			add(89);
			add(145);
			add(42);
			add(20);
			add(4);
			add(16);
			add(37);
			add(58);
		}
	};
	
	private boolean is89cycle(int number) {
		return loopNums.contains(number);
	}
	
	@Test(timeout = 10_000)
	public void SquareDigitChanges() {
		//8581146
		int result = squareDigitChanges( 10_000_000 );
		System.out.printf("squareDigitChanges( 10_000_000 ) = %d%n",result);
		assertEquals( result, 8581146 );
	}
}
