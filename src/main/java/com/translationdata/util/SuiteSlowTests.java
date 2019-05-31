package com.translationdata.util;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.translationdata.p010.P010_SummationOfPrimes;
import com.translationdata.p010.P014_CollatzSequence;
import com.translationdata.p020.P023_NonAbundantSums;
import com.translationdata.p090.P092_SquareDigitChains;
import com.translationdata.p120.P125_PalindromicSums;

@RunWith(Suite.class)
@Suite.SuiteClasses ({
	P010_SummationOfPrimes.class,
	P014_CollatzSequence.class,
	
	P023_NonAbundantSums.class,

	P092_SquareDigitChains.class,
	
	P125_PalindromicSums.class
})
public class SuiteSlowTests {
}
