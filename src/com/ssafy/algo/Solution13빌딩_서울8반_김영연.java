package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution13빌딩_서울8반_김영연 {
	static void up(int i, int j) {
			while (0 <= i) {
				if(map[i][j] == 'B')
					cnt++;
				i--;
			}
	}
	static void down(int n, int i, int j) {
			while (i <= n - 1) {
				if(map[i][j] == 'B')
					cnt++;
				i++;
			}
	}
	static void left(int i, int j) {
			while (0 <= j) {
				if(map[i][j] == 'B')
					cnt++;
				j--;
			}
	}
	static void right(int n, int i, int j) {
			while (j <= n - 1) {
				if(map[i][j] == 'B') 
					cnt++;
				j++;
			}
	}
	static char[][] map;
	static int cnt;

	public static void main(String args[]) throws Exception
	{;	
	//System.setIn(new FileInputStream("res/Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();

		int[] di = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dj = { -1, 0, 1, 1, 1, 0, -1, -1 };
		for (int t = 1; t <= TestCase; t++) {
			int n = sc.nextInt();
			map = new char[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			int max = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int flag = 0;
					if (map[i][j] == 'G')
						continue;
					for (int d = 0; d < di.length; d++) { // G인경우 그냥 2로설정하고 다음으로
						int ni = i + di[d];
						int nj = j + dj[d];
						if (0 <= ni && ni < n && 0 <= nj && nj < n) {
							if (map[ni][nj] == 'G') { // 탐색
								if (2 > max)
									max = 2;
								flag = 1;
								break;
							}
						}
					}
					if (flag == 0) { // B+ 더해주기
						cnt = 1;
						up(i - 1, j);
						down(n, i + 1, j);
						left(i, j - 1);
						right(n, i, j + 1);
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
			cnt = 1;
		}
	}
}