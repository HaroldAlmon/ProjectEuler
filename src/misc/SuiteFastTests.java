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

@RunWith(Suite.class)
@Suite.SuiteClasses ({
	P001_MultiplesOf3And5.class,
	P002_EvenFibonacciNumbers.class,
	P003_LargestPrimeFactor.class,
	P005_SmallestMultipleArray.class,
	P006_SumSquareDifference.class,
	P008_LargestProduct.class,
	P009_PythagoreanTriplet.class
})
public class SuiteFastTests {

}
