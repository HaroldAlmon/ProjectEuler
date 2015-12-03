package com.translationdata.p020;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.junit.Test;

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
		nameSum = nameSum(nameSum, byteName);
		return nameSum * (nameIndex + 1);
	}

	private int nameSum(int nameSum, char[] byteName) {
		for (int digitPosition = 1; digitPosition < byteName.length-1; digitPosition++) {
			nameSum += Character.getNumericValue(byteName[digitPosition]) - 9;
		}
		return nameSum;
	}

	@Test(timeout = 500)
	public void NameScores() throws IOException {
		String inputFile = "src/main/java/com/translationdata/p020/p022_names.txt";
		int score = nameScores( inputFile );

		System.out.printf("nameScores(%s) = %s%n",inputFile, score);
		assertEquals(871198282, score);
	}
}
