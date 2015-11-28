package JUnitTests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import G01.P002_EvenFibonacciNumbers;
import G01.P003_LargestPrimeFactor;
import G01.P005_SmallestMultipleHashMap;
import G01.P006_SumSquareDifference;
import G01.P007_10001PrimeLinkList;
import G01.P008_LargestProduct;
import G01.P009_PythagoreanTriplet;

@RunWith(Categories.class)
@IncludeCategory(FastTest.class)
@Suite.SuiteClasses ( {
	P002_EvenFibonacciNumbers.class,
	P003_LargestPrimeFactor.class,
	P005_SmallestMultipleHashMap.class,
	P006_SumSquareDifference.class,
	P007_10001PrimeLinkList.class,
	P007_10001PrimeLinkList.class,
	P008_LargestProduct.class,
	P009_PythagoreanTriplet.class,
	P001_MultiplesOf3And5Test.class
	} )
public class UnitTestCategoryFast {

}
