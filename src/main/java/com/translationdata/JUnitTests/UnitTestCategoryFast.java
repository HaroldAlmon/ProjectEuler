package com.translationdata.JUnitTests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.translationdata.p000.P001_MultiplesOf3And5;
import com.translationdata.p000.P002_EvenFibonacciNumbers;
import com.translationdata.p000.P003_LargestPrimeFactor;
import com.translationdata.p000.P005_SmallestMultipleHashMap;
import com.translationdata.p000.P006_SumSquareDifference;
import com.translationdata.p000.P007_10001PrimeLinkList;
import com.translationdata.p000.P008_LargestProduct;
import com.translationdata.p000.P009_PythagoreanTriplet;
import com.translationdata.p010.P011_LargestProduct;
import com.translationdata.p010.P012_TriangularNumber;
import com.translationdata.p010.P013_LargeSum;
import com.translationdata.p010.P014_CollatzSequence;
import com.translationdata.p010.P015_LatticePaths;

// Run this file as a JUnit test.
@RunWith(Categories.class)
@IncludeCategory(FastTest.class)
@Suite.SuiteClasses ( {
	P001_MultiplesOf3And5.class,
	P002_EvenFibonacciNumbers.class,
	P003_LargestPrimeFactor.class,
	P005_SmallestMultipleHashMap.class,
	P006_SumSquareDifference.class,
	P007_10001PrimeLinkList.class,
	P007_10001PrimeLinkList.class,
	P008_LargestProduct.class,
	P009_PythagoreanTriplet.class,
	P011_LargestProduct.class,
	P012_TriangularNumber.class,
	P013_LargeSum.class,
	P014_CollatzSequence.class,
	P015_LatticePaths.class
	} )
public class UnitTestCategoryFast {

}
