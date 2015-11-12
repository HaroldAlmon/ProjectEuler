package misc;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import G01.P001_MultiplesOf3And5;
import G01.P002_EvenFibonacciNumbers;
import G01.P003_LargestPrimeFactor;
import G01.P005_SmallestMultipleArray;
import G01.P006_SumSquareDifference;
import G01.P008_LargestProduct;
import G01.P009_PythagoreanTriplet;
import G02.P011_LargestProduct;
import G02.P012_TriangularNumber;
import G02.P013_LargeSum;
import G02.P014_CollatzSequence;
import G02.P015_LatticePaths;
import G02.P016_PowerDigitSum;
import G02.P017_NumberLetterCounts;
import G02.P018_MaximumPathSumI;
import G02.P019_CountingSundays;
import G03.P020_FactorialDigitSum;
import G03.P021_AmicableNumbers;
import G03.P022_NameScores;
import G03.P025_1000Fibonacci;
import G03.P026_ReciprocalCycles;
import G03.P027_QuadraticPrimes;
import G03.P028_NumberSpiralDiagonals;
import G04.P036_DoubleBasePalindromes;
import G07.P067_MaximumPathSumII;
import G07.P067_PyramidMax;
import misc.P081_PathSum2Ways;

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
