package G03;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
/** Strategy: Dynamic programming, simple mathematics. */

public class P028_NumberSpiralDiagonals {
	int[][] matrix;
	int num = 2;

	public int numberSpiralDiagonals(int matrixSize) {
		matrix = dynamicallyCreateArray(matrixSize);
		populateMatrix(matrix);
		return diagonalsSum(matrix);
	}

	private int[][] dynamicallyCreateArray(int matrixSize) {
		int[][] matrix = new int[matrixSize][];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[matrixSize];
		}
		return matrix;
	}

	private int diagonalsSum(int[][] matrix) {
		int result = -1;

		result += sumFallingDiagonal(matrix);
		result += sumRisingDiagonal(matrix);
		return result;
	}

	private int sumRisingDiagonal(int[][] matrix) {
		int result = 0;
		for (int i = 0; i < matrix.length; i++) {
			result += matrix[matrix.length - i - 1][i];
		}
		return result;
	}

	private int sumFallingDiagonal(int[][] matrix) {
		int result = 0;
		for (int i = 0; i < matrix.length; i++) {
			result += matrix[i][i];
		}
		return result;
	}
	
	private void populateMatrix(int[][] matrix) {
		int row;
		int col;
		
		int centre = matrix.length/2;
		matrix[centre][centre] = 1;
		row = centre;
		col = centre+1;

		for (int offsetFromCentre = 1; offsetFromCentre <= centre; offsetFromCentre++) {
			row = populateMatrixGoingDown(row, col, centre, offsetFromCentre);
			col = populateMatrixGoingLeft(row, col, centre, offsetFromCentre);
			row--;
			row = populateMatrixGoingUp(row, col, centre, offsetFromCentre);
			col++;
			col = populateMatrixGoingRight(row, col, centre, offsetFromCentre);
		}
	}
	
	private int populateMatrixGoingDown(int row, int col, int centre, int offsetFromCentre) {
		for (; row <= centre + offsetFromCentre; row++) {
			matrix[row][col] = num;
			num += 1;
		}
		row--;
		return row;
	}
	
	private int populateMatrixGoingLeft(int row, int col, int centre, int offsetFromCentre) {
		col--;
		for (; col >= centre - offsetFromCentre ; col--) {
			matrix[row][col] = num;
			num += 1;
		}
		col++;
		return col;
	}
	
	private int populateMatrixGoingUp(int row, int col, int centre, int offsetFromCentre) {
		for (; row >= centre - offsetFromCentre; row--) {
			matrix[row][col] = num;
			num += 1;
		}
		row++;
		return row;
	}
	
	private int populateMatrixGoingRight(int row, int col, int centre, int offsetFromCentre) {
		for (; col <= centre + offsetFromCentre ; col++) {
			matrix[row][col] = num;
			num += 1;
		}
		return col;
	}
		
	@SuppressWarnings("unused")
	private void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.printf("%s%n",Arrays.toString(matrix[i]));
		}
	}

	@Test(timeout = 500)
	public void SumOfDiagonals() {
		int sum = numberSpiralDiagonals(101);
		System.out.printf("sumOfDiagonals(101)=%d%n", sum);
		assertEquals("Incorrect sum of diagonals", 692101, sum);
	}
}
