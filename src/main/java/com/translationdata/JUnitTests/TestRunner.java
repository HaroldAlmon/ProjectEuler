package com.translationdata.JUnitTests;

import org.junit.runner.JUnitCore;

public class TestRunner {

	public static void main(String[] args) {
		JUnitCore.runClasses(P001_MultiplesOf3And5Test.class);
		JUnitCore.runClasses(P004_PalindromeProductTest.class);
		JUnitCore.runClasses(P010_SummationOfPrimesTest.class);
	}

}
