package misc;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import com.translationdata.p000.P004_PalindromeProduct;
import com.translationdata.p000.P007_10001PrimeArrays;
import com.translationdata.p010.P010_SummationOfPrimes;
import com.translationdata.p090.P092_SquareDigitChains;

@RunWith(Suite.class)
@Suite.SuiteClasses ({
	P004_PalindromeProduct.class,
	P007_10001PrimeArrays.class,
	P010_SummationOfPrimes.class,
	P092_SquareDigitChains.class
})
public class SuiteSlowTests {
}
