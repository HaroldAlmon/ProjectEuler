package G03;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.junit.Test;
/**
 * 
 * @author Harold Almon
 *
 */
public class P022_NameScores {
	public int nameScores(String fileName) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		String line = null;
		if((line = bufferedReader.readLine()) == null) {
			System.out.printf("%s: File read error! Cannot read %s%n", this.getClass().getName(), fileName);
			System.exit(-1);
		}
		bufferedReader.close();
		String[] namesAry;
		namesAry = line.split(",");
		Arrays.sort(namesAry);
		int fileSum = 0;

		for (int nameIndex = 0; nameIndex < namesAry.length; nameIndex++) {
			fileSum += calculateNameScore(namesAry, nameIndex);
		}
		return fileSum;
	}

	private int calculateNameScore(String[] namesAry, int nameIndex) {
		int nameSum;
		char[] byteName;

		byteName = namesAry[nameIndex].toCharArray();
		nameSum = 0;
		nameSum = calculateNameSum(nameSum, byteName);
		return nameSum * (nameIndex + 1);
	}

	private int calculateNameSum(int nameSum, char[] byteName) {
		for (int digitPosition = 1; digitPosition < byteName.length-1; digitPosition++) {
			nameSum += Character.getNumericValue(byteName[digitPosition]) - 9;
		}
		return nameSum;
	}

	@Test
	public void NameScores() throws IOException {
		String inputFile = "src/g03/p022_names.txt";
		int score = nameScores( inputFile );

		System.out.printf("NameScores(%s) = %s%n",inputFile, score);
		assertEquals(871198282, score);
	}
}
