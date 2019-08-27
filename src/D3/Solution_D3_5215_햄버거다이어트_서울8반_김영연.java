package D3;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_5215_햄버거다이어트_서울8반_김영연{
	static int[][] list;
	static int max_favor;
	static int N, L;

	public static void dfs(int index, int favor, int cal) {
		if(index == N) {
			if(favor > max_favor)
				max_favor = favor;
			return;
		}
		if(cal + list[index][1] < L)
			dfs(index + 1, favor+list[index][0], cal+list[index][1]);
		dfs(index+1, favor, cal);
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int TestCase = sc.nextInt();
		for (int t = 1; t <= TestCase; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			list = new int[N][2];
			for (int i = 0; i < N; i++) {
				int g = sc.nextInt();
				int k = sc.nextInt();
				list[i][0] = g;
				list[i][1] = k;
			}
			max_favor = 0;
			dfs(0, 0, 0);
			System.out.println("#"+t+" "+max_favor);
		}
        sc.close();
	}
}