package misc;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import com.translationdata.g000.P004_PalindromeProduct;
import com.translationdata.g000.P007_10001PrimeArrays;
import com.translationdata.p090.P092_SquareDigitChains;

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
