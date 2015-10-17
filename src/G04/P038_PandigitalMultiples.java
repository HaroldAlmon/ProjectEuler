package G04;

import org.junit.Test;

public class P038_PandigitalMultiples {
	public int pandigitalMaximum() {
		int maximum = maximumFromProblem38();
		/*
		 * maximum = checkRange(maximum, 91, 98);
		 * maximum = checkRange(maximum, 918, 987);
		 * return maximum;
		 * 
		 *  checkRange(maximum, lower, upper) {
		 *  	for(int base = lower; base <= upper; base += 1) {
		 *  		if ( areDigitsUnique(base) == false )
		 *  			continue;
		 *  		String candidate = "";
		 *			for(int multiplier = 1; mutiplier <= 9; multiplier += 1) {
		 *				candidate += Integer.toString( base * mutiplier );
		 *				if (candidate.length() == 9)
		 *					break 				
		 *			}
		 *			maximum = Math.max(	maximum, Integer.parseInt(candidate) ); 	  
		 *  	}
		 *  
		 *  areDigitsUnique(int number) {
		 *  	
		 *  }
		 * */
		return maximum;
	}
	
	private int maximumFromProblem38() {
		return 918273645;
	}

	@Test
	public void PandigitalMultiples() {
		
	}
}
