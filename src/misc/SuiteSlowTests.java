package misc;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import com.translationdata.g10.P092_SquareDigitChains;

import G01.P004_PalindromeProduct;
import G01.P007_10001PrimeArrays;
import G02.P010_SummationOfPrimes;

@RunWith(Suite.class)
@Suite.SuiteClasses ({
	P004_PalindromeProduct.class,
	P007_10001PrimeArrays.class,
	P010_SummationOfPrimes.class,
	P092_SquareDigitChains.class
})
public class SuiteSlowTests {
}
