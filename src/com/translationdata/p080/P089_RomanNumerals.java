package com.translationdata.p080;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class P089_RomanNumerals {
	public int characterSaved(String fileName) throws IOException {
		int total = 0;
		
		FileInputStream fileInputStream = new FileInputStream(fileName);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		String line = null;
		
		while((line = bufferedReader.readLine()) != null) {
			total += savings( line );
		}

		bufferedReader.close();
		
		return total;
	}
	private int savings(String number) {
		int savedCharacters = 0;
		
		savedCharacters = minimise9and4(number, savedCharacters);
		savedCharacters = minimise90and40(number, savedCharacters);
		savedCharacters = minimise900and400(number, savedCharacters);
		
		return savedCharacters;
	}
	private int minimise900and400(String number, int savedCharacters) {
		if ( number.contains("DCCCC") ) {
			savedCharacters += 3;

		} else if(number.contains("CCCC"))  {
			savedCharacters += 2;			
		}
		return savedCharacters;
	}
	private int minimise90and40(String number, int savedCharacters) {
		if ( number.contains("LXXXX") ) {
			savedCharacters += 3;
			
		} else if ( number.contains("XXXX") ) {
			savedCharacters += 2;
		}
		return savedCharacters;
	}
	private int minimise9and4(String number, int savedCharacters) {
		if ( number.contains("VIIII") ) {
			savedCharacters += 3;

		} else if (number.contains("IIII")) {
			savedCharacters += 2; 
		}
		return savedCharacters;
	}

	@Test (timeout = 1_000)
	public void RomanNumerals() {
		String inputFile = "src/g09/P089_roman.txt";
		int charactersSaved = 0;
		try {
			charactersSaved = characterSaved(inputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.printf("Characters saved %d%n", charactersSaved);
		assertEquals( charactersSaved, 743 );
	}
}
