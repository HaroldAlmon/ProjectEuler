package G09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.junit.Test;

public class P089_RomanNumerals {
	public int characterSaved(String fileName) throws IOException {
		int total = 0;
		
		FileInputStream fileInputStream = new FileInputStream(fileName);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		String line = null;
		
		while((line = bufferedReader.readLine()) != null) {
			//System.out.println(line);
			total += savings( line );
		}

		bufferedReader.close();
		
		return total;
	}
	private int savings(String number) {
		int result = 0;
		if ( number.contains("VIIII") ) {
			System.out.println(number);
			result += 3;
		} else if (number.contains("IIII")) {
			System.out.println(number);
			result += 2; 
		}
		return result;
	}
/*
 * IIII = IV saves 2
 * IIIII = V saves 4
 * IIIIII = VI saves 4
 * VIIII = IX saves 3
 * XXXX = XL saves 2
 * LXXXX = XC saves 2
 * XXXX = XL saves 2
 */
	@Test
	public void RomanNumerals() {
		String inputFile = "src/g09/P089_roman.txt";
		int total = 0;
		try {
			total = characterSaved(inputFile);
			System.out.println(total);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
