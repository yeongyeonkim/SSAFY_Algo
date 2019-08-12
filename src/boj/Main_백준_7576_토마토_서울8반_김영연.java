package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_7576_토마토_서울8반_김영연 {

	static int cnt, n, m;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<int[]> q = new LinkedList<>();

	public static void BFS(int x, int y, int count) {
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + tmp[0];
				int ny = dy[i] + tmp[1];
				if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 0) {
					map[nx][ny] = 1; //자람
					q.offer(new int[] { nx, ny, tmp[2]+1 });
				}
			}
			cnt = tmp[2];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] size = br.readLine().split(" ");
		m = Integer.parseInt(size[0]);
		n = Integer.parseInt(size[1]);
		int start_x = 0;
		int start_y = 0;
		map = new int[n][m];
		cnt = 0;
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 1) {
					start_x = i;
					start_y = j;
					q.offer(new int[] { start_x, start_y, 0} );
				}
			}
		}
		BFS(start_x, start_y, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) { // bfs했는데도 자라지않은 친구가 있다면.
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(cnt);

	}

}
