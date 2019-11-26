package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_아기상어 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int size = 2;
		int cnt = 0;
		int time = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] < o2[2])
					return -1; // 거리 짧
				else if (o1[2] > o2[2])
					return 1;
				else { // 가장 위
					if (o1[0] < o2[0])
						return -1;
					else if (o1[0] > o2[0])
						return 1;
					else
						return Integer.compare(o1[1], o2[1]);
				}
			}
		});

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 9)
					pq.add(new int[] { i, j, 0 });
				else
					map[i][j] = num;
			}
		}
		boolean[][] visit = new boolean[n][n];
		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			int x = tmp[0];
			int y = tmp[1];
			visit[x][y] = true;
			if (map[x][y] != 0 && map[x][y] < size) { // 먹을 수 있으면
				cnt++;
				if (cnt == size) {
					size++;
					cnt = 0;
				}
				time += tmp[2];
				map[x][y] = 0;
				visit = new boolean[n][n];
				pq.clear();
				pq.add(new int[] { x, y, 0 });
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < n && !visit[nx][ny] && map[nx][ny] <= size) {
					visit[nx][ny] = true;
					pq.add(new int[] { nx, ny, tmp[2] + 1 });
				}
			}
		}
		System.out.println(time);

	}
}