package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1113_119구급대_서울8반_김영연 {

	static int n, m, e_n, e_m, min;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] map;
	static boolean[][] visit;
	
	public static void DFS(int x, int y, int count, int dir) {
		if(x == e_n && y == e_m) {
			min = Math.min(min, count);
			return;
		}
		if(count >= min) return;
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(0<=nx&&nx<n&&0<=ny&&ny<m&&!visit[nx][ny]&&map[nx][ny] != 0) {
				int tmp_count = count;
				if(dir != i) tmp_count++;
				visit[nx][ny] = true;
				DFS(nx, ny, tmp_count, i);
				visit[nx][ny] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		e_n = Integer.parseInt(st.nextToken());
		e_m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		visit[0][0] = true;
		for(int i=0; i<2; i++) {
			int nx = dx[i];
			int ny = dy[i];
			if(map[nx][ny] != 0) {
				visit[nx][ny] = true;
				DFS(nx,ny,0,i);
				visit[nx][ny] = false;
			}
		}
		System.out.println(min);
	}
}
