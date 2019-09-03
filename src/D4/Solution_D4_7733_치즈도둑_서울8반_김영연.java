package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_7733_치즈도둑_서울8반_김영연 {
	static int n, cnt, max;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<int[]> q = new LinkedList<>();

	public static void BFS(int x, int y, int day) {
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n && visit[nx][ny] == false && map[nx][ny] > day) {
					q.offer(new int[] { nx, ny });
					visit[nx][ny] = true;
				}
			}
		}
	}

	public static void cheese(int day) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == false && map[i][j] > day) {
					q.offer(new int[] { i, j });
					visit[i][j] = true;
					cnt++;
					BFS(i, j, day);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			max = 1;
			q.clear();
			int max_index = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (max_index < map[i][j])
						max_index = map[i][j];
				}
			}
			for (int i = 1; i <= max_index; i++) {
				cnt = 0;
				visit = new boolean[n][n];
				cheese(i);
				if (max < cnt)
					max = cnt;
			}
			System.out.println("#" + t + " " + max);
		}

	}

}
