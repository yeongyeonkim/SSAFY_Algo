package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정올_2613_토마토고_서울8반_김영연 {

	static int cnt, n, m, total;
	static Queue<int[]> q = new LinkedList<>();

	public static void BFS(int[][] map) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + tmp[0];
				int ny = dy[i] + tmp[1];
				if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 0) {
					map[nx][ny] = 1; // 자람
					q.offer(new int[] { nx, ny, tmp[2] + 1 });
					total--;
				}
			}
			cnt = tmp[2];
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		cnt = 0;
		total = 0;
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 1) q.offer(new int[] { i, j, 0 });
				else if(map[i][j] == 0)  total++;
			}
		}
		BFS(map);
		if(total != 0) System.out.println("-1");
		else 		   System.out.println(cnt);
	}
}