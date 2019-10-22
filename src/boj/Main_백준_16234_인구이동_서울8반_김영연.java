package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16234_인구이동_서울8반_김영연 {

	static int n, l, r;
	static boolean flag;
	static int[][] map, number;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visit;
	

	public static void union(int x, int y) {
		boolean b = false;
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(0<=nx&&nx<n&&0<=ny&&ny<n&&!visit[nx][ny]) {
				int differ = Math.abs(map[nx][ny] - map[x][y]);
				if(l<=differ && differ<=r) {
					b = true;
					break;
				}
			}
		}
		if(!b) return;
		//탐색가능
		flag = true;
		boolean[][] tmp_visit = new boolean[n][n];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		tmp_visit[x][y] = true;
		int sum = 0;
		int count = 0;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			count++;
			sum += map[tmp[0]][tmp[1]];
			for(int i=0; i<4; i++) {
				int nx = dx[i] + tmp[0];
				int ny = dy[i] + tmp[1];
				if(0<=nx&&nx<n&&0<=ny&&ny<n&&!tmp_visit[nx][ny]) {
					int differ = Math.abs(map[nx][ny] - map[tmp[0]][tmp[1]]);
					if(l<=differ && differ<=r) {
						tmp_visit[nx][ny] = true;
						q.add(new int[] { nx, ny });
					}
				}
			}
		}
		int divide = sum / count;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(tmp_visit[i][j]) number[i][j] = divide;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		while (true) {
			visit = new boolean[n][n];
			number = new int[n][n];
			flag = false;// 모든지점 다 탐색해서 가능한게없으면 ㄴ
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visit[i][j] = true;
					union(i, j);
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++)
					if(number[i][j] != 0) map[i][j] = number[i][j];
			}
			if(!flag) break;
			cnt++;
		}
		System.out.println(cnt);
	}
}
