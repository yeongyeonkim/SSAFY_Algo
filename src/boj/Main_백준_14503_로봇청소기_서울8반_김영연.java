package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14503_로봇청소기_서울8반_김영연 {

	static int n, m, s_x, s_y, d, cnt;
	static boolean[][] visit;
	static boolean flag;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void move(int go, int count) {
		if (go == 1) {
			if (!visit[s_x][s_y]) cnt++;
			visit[s_x][s_y] = true; // 청소
		}
		if(count == 4) { 
			s_x -= dx[d];
			s_y -= dy[d]; 
			if(s_x < 0 || s_x >= n || s_y < 0 || s_y >= m || map[s_x][s_y] == 1) {
				flag = true;
				return;
			}
			else
				move(2, 0);
		}
		else {
			d = d == 0 ? 3 : d - 1;
			int nx = s_x + dx[d];
			int ny = s_y + dy[d];
			if(0<=nx&&nx<n&&0<=ny&&ny<m&&!visit[nx][ny]&&map[nx][ny]!=1) { // a
				s_x = nx;
				s_y = ny;
				move(1, 0);
			}
			else if(nx < 0 || nx >= n || 0 > ny || ny >= m || visit[nx][ny] || map[nx][ny] == 1) { // b
				move(2, count + 1);
			}
		}		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		s_x = Integer.parseInt(st.nextToken());
		s_y = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		visit = new boolean[n][m];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		cnt = 0;
		flag = false;
		while (!flag) {
			move(1, 0);
		}
		System.out.println(cnt);
	}
}