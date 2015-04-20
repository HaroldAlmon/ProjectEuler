package G01;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class G01_JUnitRunner {
	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		junit.run(FuseTester.class);
		junit.run(P001_MultiplesOf3And5.class);
		junit.run(P002_EvenFibonacciNumbers.class);
		junit.run(P003_LargestPrimeFactor.class);
		junit.run(P004_PalindromeProduct.class);
		junit.run(P005_SmallestMultipleArray.class);
		junit.run(P006_SumSquareDifference.class);
		junit.run(P007_10001PrimeArrays.class);
		junit.run(P008_LargestProduct.class);
		junit.run(P009_PythagoreanTriplet.class);
		System.out.printf("=== Finished ===%n");
	}
}
