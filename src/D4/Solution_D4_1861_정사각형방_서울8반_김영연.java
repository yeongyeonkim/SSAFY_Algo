package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_서울8반_김영연 {

	static int n, max, min;
	static int[][] map;
	static int[][] findmin;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void DFS(int start_x, int start_y, int x, int y, int count) {
		if(count >= max) { 
			max = count;
			findmin[start_x][start_y] = count;
		}
		visit[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0<=nx && nx < n && 0<=ny && ny < n && 
			map[x][y] + 1 == map[nx][ny]) {
				DFS(start_x, start_y, nx, ny, count + 1);
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			findmin = new int[n][n];
			visit = new boolean[n][n];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visit[i][j])
						DFS(i,j ,i, j, 1);
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(findmin[i][j] == max) 
						if(min > map[i][j]) min = map[i][j];
				}
			}
			
			System.out.println("#"+t+" "+min+" " +max);
		}
		
	}
}