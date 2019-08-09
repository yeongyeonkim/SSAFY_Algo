package stack2;

import java.util.Scanner;

public class NQueen {

	public static int N;
	public static int[] col;
	public static int result;

	public static boolean promising(int i) {
		for (int j = 0; j < i; j++) {
			if (col[j] == col[i] || Math.abs(col[i] - col[j]) == (i - j))
				// 같은 열 || 대각선 내
				return false;
		}
		return true;
	}

	public static void nqueen(int i) {
		if (i == N) {
			result++;
			return;
		}
		for (int j = 0; j < N; j++) {
			col[i] = j;
			if (promising(i)) nqueen(i + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int k = 1; k <= t; k++) {
			N = sc.nextInt();
			col = new int[N];
			result = 0;
			nqueen(0);
			System.out.println("#" + k + " " + result);
		}
	}
}
