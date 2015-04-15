package G03;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.junit.Test;
public class P022_NameScores {
	public int getScore(String fileName) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		String line = null;
		if((line = bufferedReader.readLine()) == null) {
			System.out.printf("File read error! Cannot read %s", fileName);
			System.exit(-1);
		}
		bufferedReader.close();
		String[] namesAry;
		namesAry = line.split(",");
		Arrays.sort(namesAry);

		int fileSum = 0;
		int nameSum;
		char[] byteName;
		for (int i = 0; i < namesAry.length; i++) {
			byteName = namesAry[i].toCharArray();
			nameSum = 0;
			for (int j = 1; j < byteName.length-1; j++) {
				nameSum += Character.getNumericValue(byteName[j]) - 9;
			}
			fileSum += nameSum * (i+1);
		}
		return fileSum;
	}

	@Test
	public void test1() throws IOException {
		int result = getScore("src/g03/p022_names.txt");
		System.out.printf("result = %s\n",result);
		assertTrue(871198282 == result);
	}
}
