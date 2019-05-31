package com.translationdata.JUnitTests;

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
	private static P001_MultiplesOf3And5 multiplesOf3And5 = new P001_MultiplesOf3And5();

	@Parameters
	public static List<Object []> data() {
		return Arrays.asList( new Object [][] {
			{100,		2_318},
			{1_000,		233_168}, 
			{10_000,	23_331_668}
		} );
	}

	public P001_MultiplesOf3And5Test(int input, int expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	}
	
	@Test
	public void isMultiplesOf3And5() {
		int result;

		result = multiplesOf3And5.multiplesOf3And5(input);
		assertThat("Incorrect sum of multiples of 3 or 5 below 1,000", result, is(expectedResult));
		System.out.printf(this.getClass().getSimpleName() + ": multiplesOf3And5: %s%n", result);
	}
}