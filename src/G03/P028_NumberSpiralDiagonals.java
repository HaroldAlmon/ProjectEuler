package G03;

import java.util.Arrays;

import org.junit.Test;
/**
 * Straegy: Dynamic programming, simple mathematics.
 * @author Harold
 *
 */

public class P028_NumberSpiralDiagonals {
	// I used this data in testing, it's used for the solution.
	int[][] matrix = {
	{21, 22, 23, 24, 25},
	{20,  7,  8,  9, 10},
	{19,  6,  1,  2, 11},
	{18,  5,  4,  3, 12},
	{17, 16, 15, 14, 13}
	};
	public int getSum(int matrixSize) {
		// Dynamic array creation...
		matrix = new int[matrixSize][];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[matrixSize];
		}
		populateMatrix(matrix);
		return calcSum(matrix);
	}
	
	@SuppressWarnings("unused")
	private void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.printf("%s\n",Arrays.toString(matrix[i]));
		}
		System.out.println("");
	}

	
	private int calcSum(int[][] matrix) {
		int result = -1;
		
		for (int i = 0; i < matrix.length; i++) {
			result += matrix[i][i];
		}
		
		for (int i = 0; i < matrix.length; i++) {
			result += matrix[matrix.length - i - 1][i];
		}
		return result;
	}
	
	private void populateMatrix(int[][] matrix) {
		int centre = matrix.length/2;
		matrix[centre][centre] = 1;
		int row = centre;
		int col = centre+1;
		int num = 2;
		for (int i = 1; i <= centre; i++) {
			// Down...
			for (; row <= centre + i; row++) {
				matrix[row][col] = num;
				//printMatrix(matrix);
				num += 1;
			}
			row--;
			
			//System.out.printf("row=%d, col=%d\n",row, col);
			
			// Left...
			col--;
			for (; col >= centre - i ; col--) {
				matrix[row][col] = num;
				//printMatrix(matrix);
				num += 1;
			}
			col++;
			row--;
			
			//System.out.printf("row=%d, col=%d\n",row, col);
			
			// Up...
			for (; row >= centre - i; row--) {
				matrix[row][col] = num;
				//printMatrix(matrix);
				num += 1;
			}
			row++;
			col++;
			
			// Right...
			for (; col <= centre + i ; col++) {
				matrix[row][col] = num;
				//printMatrix(matrix);
				num += 1;
			}
			//System.out.printf("row=%d, col=%d\n",row, col);		
		}
	}
	@Test
	public void test1() {
		System.out.printf("Result=%d\n",getSum(1001));
	}
}
