package com.translationdata.JUnitTests;

// We need to configure the following jars:
// hamcrest-core-1.3.jar
// junit-4.13.2.jar

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.translationdata.p000.P001_MultiplesOf3And5;

@RunWith(Parameterized.class)
public class P001_MultiplesOf3And5Test {
	private int input;
	private int expectedResult;
	private static P001_MultiplesOf3And5 solution = new P001_MultiplesOf3And5();

	@Parameters
	public static List<Object []> data() {
		return Arrays.asList( new Object [][] {
			{100,		2_318},
			{1_000,		233_168}, 
			{10_000,	23_331_668}
		} );
	}

	// Constructor
	public P001_MultiplesOf3And5Test(int upperBound, int expectedResult) {
		this.input = upperBound;
		this.expectedResult = expectedResult;
	}
	
	@Test
	public void isMultiplesOf3And5() {
		int result;

		result = solution.multiplesOf3And5(input);
		assertThat("Incorrect sum of multiples of 3 or 5 below 1,000", result, is(expectedResult));
		System.out.printf(this.getClass().getSimpleName() + ": The number of multiples of 3 or 5 below %d are: %s%n", input, result);
	}
}