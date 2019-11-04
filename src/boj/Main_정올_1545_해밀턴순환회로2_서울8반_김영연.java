package boj;

import java.util.*;

public class Main_정올_1545_해밀턴순환회로2_서울8반_김영연 {
	public static int INF = 987654321;
	public static int N;
	public static int[][] G;
	public static int[][] d;
	//
	public static int[][] m;

	public static int solve(int pos, int visited, int start) {
		//
		if (m[pos][visited] != 0) return m[pos][visited];
		if (visited == (1 << N) - 1) return m[pos][visited] = d[pos][start];

		int ret = INF;
		for (int next = 0; next < N; next++) {
			if ((visited & (1 << next)) == 0 && d[pos][next] !=0) {
				int tmp = d[pos][next] + solve(next, visited | (1 << next), start);
				/*
d[2][3] + solve(3, visit | (1<<3),1)
          d[3][4]+solve(4, visit | (1<<4),1)
				        d[4][5] + solve(5, visit | (1<<5), 1).... 이런식
				 */
				ret = Math.min(ret, tmp);
			}
		}
		m[pos][visited] = ret;
		return ret;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		G = new int[N][N];
		d = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				G[i][j] = sc.nextInt();
				if (i != j & G[i][j] == 0)
					G[i][j] = INF;
			}
		}

		int ans = INF;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				d[j] = G[j].clone();
			}
		}
		m = new int[N][1 << N];
		int tmp = solve(0, 1 << 0, 0);
		if (ans > tmp)
			ans = tmp;

		System.out.println(ans);
		sc.close();
	}
}
