package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D9_1953_탈주범검거_서울8반_김영연 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s_x = Integer.parseInt(st.nextToken());
			int s_y = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {s_x, s_y, 1});
			boolean[][] visit = new boolean[n][m];
			int[][] map = new int[n][m];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,-1,1};
			int[][] now = {{0,0,0,0},{1,1,1,1},{1,1,0,0},{0,0,1,1},
						   {1,0,0,1},{0,1,0,1},{0,1,1,0},{1,0,1,0}};
			int[][] next = {{0,0,0,0},{1,1,1,1},{1,1,0,0},{0,0,1,1},
							{0,1,1,0},{1,0,1,0},{1,0,0,1},{0,1,0,1}};
			visit[s_x][s_y] = true;
			int cnt = 1;
			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				int x = tmp[0];
				int y = tmp[1];
				if(tmp[2] == time) continue;
				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(0<=nx&&nx<n&&0<=ny&&ny<m&&now[map[x][y]][i]==1&&next[map[nx][ny]][i]==1&&!visit[nx][ny]) {
						visit[nx][ny] = true; cnt++;
						q.add(new int[] {nx, ny, tmp[2] + 1});
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}	
}