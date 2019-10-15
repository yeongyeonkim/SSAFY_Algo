package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_정올_1840_치즈_서울8반_김영연 {

	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<int[]> change;
		
	public static void find(int x, int y) {
		if(map[x][y] == 1) {
			change.add(new int[] { x, y } );
			return;
		}
		//종료조건
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0<=nx && nx < n && 0<=ny && ny < m && !visit[nx][ny]) {
				visit[nx][ny] = true;
				find(nx, ny);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int time = -1;
		int prev_cnt = 0;
		while (true) {
			time++;
			visit = new boolean[n][m];
			change = new ArrayList<>();
			boolean flag = false;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] == 0) {
						visit[i][j] = true;
						find(i,j);
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			if(change.size() == 0) break;
			for(int i=0; i<change.size(); i++) 
				map[change.get(i)[0]][change.get(i)[1]] = 0;
			prev_cnt = change.size();
		}
		System.out.println(time);
		System.out.println(prev_cnt);
	}
}