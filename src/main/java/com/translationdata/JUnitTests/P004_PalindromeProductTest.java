package com.translationdata.JUnitTests;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.translationdata.p000.P004_PalindromeProduct;

@RunWith(Parameterized.class)
public class P004_PalindromeProductTest {
	private int input;
	private int expectedResult;
	private static P004_PalindromeProduct palindromeProduct = new P004_PalindromeProduct();

	@Parameters
	public static List<Object []> data() {
		return Arrays.asList( new Object [][] {
			{3, 906609},
			{4, 99000099},
			{5, 1293663921}
		} );
	}

	public P004_PalindromeProductTest(int input, int expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	} 
	
	@Test (timeout=25000)
	public void PalindromeProductTest() throws Exception {
		int result;

		result = palindromeProduct.largestPalindromeProduct(input);
		System.out.printf("PalindromeProductTest = %d%n", result);
		assertThat( "Not the largest palindrome product", result, is(expectedResult) );
	}
	
	@Test(timeout=100, expected=Exception.class)
	public void LengthLessThan1ThrowsException() throws Exception {
		int result = palindromeProduct.largestPalindromeProduct(-1);
		System.out.printf("largestPalindromeProduct = %d%n", result);
		fail("Should not reach this position because the bad input should have caused an exception.");
		assertEquals("Should not reach this position because the bad input should have caused an exception.", 0, result);
	}
}