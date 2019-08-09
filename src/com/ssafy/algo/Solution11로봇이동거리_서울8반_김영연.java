package com.ssafy.algo;
import java.io.FileInputStream;
import java.util.Scanner;

public class Solution11로봇이동거리_서울8반_김영연 {
	static int T, N;
	static int Answer;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// A
					if (map[i][j] == 'A') {
						for (int k = j + 1; k < N; k++) {
							if (map[i][k] == 'S')
								Answer++;
							else
								break;
						}
					}
					// B
					if (map[i][j] == 'B') {
						for (int k = j + 1; k < N; k++) {
							if (map[i][k] == 'S')
								Answer++;
							else
								break;
						}
						for (int k = j - 1; k >= 0; k--) {
							if (map[i][k] == 'S')
								Answer++;
							else
								break;
						}
					}
					// C
					if (map[i][j] == 'C') {
						for (int k = j + 1; k < N; k++) {
							if (map[i][k] == 'S')
								Answer++;
							else
								break;
						}
						for (int k = j - 1; k >= 0; k--) {
							if (map[i][k] == 'S')
								Answer++;
							else
								break;
						}
						for (int k = j - 1; k >= 0; k--) {
							if (map[k][j] == 'S')
								Answer++;
							else
								break;
						}
						for (int k = j + 1; k < N; k++) {
							if (map[k][j] == 'S')
								Answer++;
							else
								break;
						}

					}
				}
			}
			System.out.println("#" + test_case + " " + Answer);
			Answer = 0;
		}
	}
}