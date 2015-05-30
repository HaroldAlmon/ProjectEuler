package G01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import common.FastTest;
/** Strategy: Simple mathematics. */
@Category( FastTest.class )
public class P006_SumSquareDifference {
	private long sumSquareDifference( int maxNum ) {
		long squareDifference = 0;
		squareDifference = squareSum( maxNum ) - sumSquares( maxNum );
		
		
		return squareDifference;
	}
	
	private long sumSquares( int maxNum ) {
		long result = 0;
		for( int num = 1; num <= maxNum; num++ ) {
			result += num*num;
		}
		return result;
	}
	
	private long squareSum( int maxNum ) {
		long result = 0;
		for( int num= 1; num <= maxNum; num++ ) {
			result += num;
		}
		return result * result;
	}
	
	@Test( timeout = 500 )
	public void SumSquareDifference() {
		long sum = sumSquareDifference( 100 );
		System.out.printf( "sumSquareDifference( %d ) = %d%n", 100, sum );
		assertEquals(  "Incorrect sum", 25164150, sum  );
	}
	
}

