package test;

public class Solution_midas1 {
	public int[][] solution(int[][] matrix, int r) {
		int n = matrix.length;
		r %= 4;
		while (r > 0) {
			for (int i = 0; i < n / 2; i++) {
				for (int j = i; j < n - i - 1; j++) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[n - j - 1][i];
					matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
					matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
					matrix[j][n - i - 1] = temp;
				}
			}
			r--;
		}
		return matrix;
	}
}