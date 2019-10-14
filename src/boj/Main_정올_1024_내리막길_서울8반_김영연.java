package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1024_내리막길_서울8반_김영연 {

	static int x, y;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] map, dp;
	public static int DFS(int n, int m) {
		if(n == x-1 && m == y-1) return 1;
		if(dp[n][m] != 0) return dp[n][m];
		for(int i=0; i<4; i++) {
			int nx = n + dx[i];
			int ny = m + dy[i];
			if(0<=nx && nx<x && 0<=ny && ny<y && map[nx][ny] < map[n][m]) 
				dp[n][m] += DFS(nx, ny);
		}
		return dp[n][m];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		map = new int[x][y];
		dp = new int[x][y];
		for(int i=0; i<x; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<y; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(DFS(0,0));
	}

}
