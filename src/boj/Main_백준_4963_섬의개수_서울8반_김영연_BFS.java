package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_4963_섬의개수_서울8반_김영연_BFS {

	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int m, n, cnt;
	static int[][] map;

	public static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 8; i++) {
				int nx = dx[i] + tmp[0];
				int ny = dy[i] + tmp[1];
				if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 1) {
					map[nx][ny] = 0;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if (m == 0 && n == 0)
				return;
			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < m; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					if (map[i][j] == 1) {
						cnt++;
						map[i][j] = 0;
						BFS(i, j);
					}
			}
			
			System.out.println(cnt);
		}
	}
}