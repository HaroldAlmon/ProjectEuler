package com.translationdata.p040;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import org.junit.Test;

public class P042_CodedTriangleNumbers {
	public int codedTriangleNumbers(String fileName) throws IOException {
		int wordCount = 0;
		String[] word = getNames( fileName );
		Set<Integer> triangleNumbers = createTriangleNumbers(20);
		
		for ( int i = 0; i < word.length; i += 1 ) {
			if ( triangleNumbers.contains( calculateWordValue( word[i] ) ) ) {
				wordCount += 1;
			}
		}
		
		return wordCount;
	}
	
	private Set<Integer> createTriangleNumbers( int size ) {
		Set<Integer> triangleNumbers = new HashSet<>( size );
		int triangleNumber = 0;
		for ( int i = 1; i < size; i += 1 ) {
			triangleNumber += i;
			triangleNumbers.add( Integer.valueOf( triangleNumber ) );
		}
		return triangleNumbers;
	}
	
	private int calculateWordValue( String word ) {
		int wordValue = 0;
		for( int i = 1; i < word.length() - 1; i += 1 ) {
			wordValue += word.charAt( i ) - 0x40;
		}
		return wordValue;
	}
	
    Boolean bufferedReadIsNull(Supplier<Boolean> function) {
        return function.get();
    }
    
	public String[] getNames(String fileName) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		String line = bufferedReader.readLine();
		
		if(bufferedReadIsNull( () -> line == null) ) {
			System.out.printf("%s: File read error! Cannot read %s%n", this.getClass().getName(), fileName);
			System.exit(-1);
		}

		bufferedReader.close();
		String[] words;
		words = line.split(",");

		return words;
	}
	
	@Test
	public void CodedTriangleNumbers() throws IOException {
		int wordCount = 0;
		try {
			wordCount = codedTriangleNumbers("src/main/java/com/translationdata/p040/P042_words.txt");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		System.out.printf( "Triangle word count = %d%n", wordCount );
		assertEquals(wordCount, 162);
	}
	
	/* ALGORITHM
	 main()
		 create wordCount set equal to zero
		 call createTriangleNumberSet(1000)
	
		 read word file into List
		 for each word in List
		 	call calculate word value
		 	if Set contains word value then
		 		increment word count
		 	end if
		 end for
		 return word count
	end function
	 
	 createTriangleNumberSet(upperLimit)
		 create Set of Integers
		 create triangleNumber Set
		 create triangleNumber set to zero
		 for i = 1 to upperLimit do
		 	triangleNumber += i
		 	add triangleNumber to Set
		 end for
		 return Set
	 end function
	 
	 calculateWordValue(word)
	 	word value = 0
	 	foreach char in word do
	 		convert char to integer value
	 		add integer value to word value 
	 	end foreach
	 	return word value
	 end function
	 */
}
