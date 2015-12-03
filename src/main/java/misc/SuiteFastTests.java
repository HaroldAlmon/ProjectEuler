package misc;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import com.translationdata.p000.P001_MultiplesOf3And5;
import com.translationdata.p000.P002_EvenFibonacciNumbers;
import com.translationdata.p000.P003_LargestPrimeFactor;
import com.translationdata.p000.P005_SmallestMultipleArray;
import com.translationdata.p000.P006_SumSquareDifference;
import com.translationdata.p000.P008_LargestProduct;
import com.translationdata.p000.P009_PythagoreanTriplet;
import com.translationdata.p010.P011_LargestProduct;
import com.translationdata.p010.P012_TriangularNumber;
import com.translationdata.p010.P013_LargeSum;
import com.translationdata.p010.P014_CollatzSequence;
import com.translationdata.p010.P015_LatticePaths;
import com.translationdata.p010.P016_PowerDigitSum;
import com.translationdata.p010.P017_NumberLetterCounts;
import com.translationdata.p010.P018_MaximumPathSumI;
import com.translationdata.p010.P019_CountingSundays;
import com.translationdata.p020.P020_FactorialDigitSum;
import com.translationdata.p020.P021_AmicableNumbers;
import com.translationdata.p020.P022_NameScores;
import com.translationdata.p020.P025_1000Fibonacci;
import com.translationdata.p020.P026_ReciprocalCycles;
import com.translationdata.p020.P027_QuadraticPrimes;
import com.translationdata.p020.P028_NumberSpiralDiagonals;
import com.translationdata.p030.P036_DoubleBasePalindromes;
import com.translationdata.p060.P067_MaximumPathSumII;
import com.translationdata.p060.P067_PyramidMax;
import com.translationdata.p080.P081_PathSum2Ways;

@RunWith(Suite.class)
@Suite.SuiteClasses ({
	P001_MultiplesOf3And5.class,
	P002_EvenFibonacciNumbers.class,
	P003_LargestPrimeFactor.class,
	P005_SmallestMultipleArray.class,
	P006_SumSquareDifference.class,
	P008_LargestProduct.class,
	P009_PythagoreanTriplet.class,

	P011_LargestProduct.class,
	P012_TriangularNumber.class,
	P013_LargeSum.class,
	P014_CollatzSequence.class,
	P015_LatticePaths.class,
	P016_PowerDigitSum.class,
	P017_NumberLetterCounts.class,
	P018_MaximumPathSumI.class,
	P019_CountingSundays.class,
	
	P020_FactorialDigitSum.class,
	P021_AmicableNumbers.class,
	P022_NameScores.class,
	P025_1000Fibonacci.class,
	P026_ReciprocalCycles.class,
	P027_QuadraticPrimes.class,
	P028_NumberSpiralDiagonals.class,
	
	P036_DoubleBasePalindromes.class,
	P067_MaximumPathSumII.class,
	P067_PyramidMax.class,
	P081_PathSum2Ways.class
})
public class SuiteFastTests {

}
