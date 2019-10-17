package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_4963_섬의개수_서울8반_김영연_DFS {

	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int m, n, cnt;
	static int[][] map;

	public static void DFS(int x, int y) {
		for(int i=0; i<8; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(0<=nx&&nx<n&&0<=ny&&ny<m&&map[nx][ny]==1) {
				map[nx][ny] = 0;
				DFS(nx,ny);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(m == 0 && n == 0) return;
			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			// 탐색
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					if (map[i][j] == 1) {
						cnt++;
						map[i][j] = 0;
						DFS(i, j);
					}
			}
			System.out.println(cnt);
		}
	}
}