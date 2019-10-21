package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17070_파이프옮기기1_서울8반_김영연 {
	static int n, cnt;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,1,1};//오른쪽, 대각선, 아래
	static int[] dy = {1,1,0};
	
	public static void dfs(int x, int y, int flag) {
		if(x == n-1 && y == n-1) {
			cnt++;
			return;
		}
		//대각선(flag==2)는 언제나 가능하고 오른쪽,아래,대각선 3군데 봐야해
		int cnt = 0;
		int nx = 0, ny = 0;
		for(int i=0; i<3; i++) {
			nx = dx[i] + x;
			ny = dy[i] + y;
			if(0<=nx && nx < n && 0<=ny && ny < n && map[nx][ny] != 1) 
				cnt++;
		}
		if(cnt == 3) dfs(x+1,y+1,2);
		//1과 3은 우나 아래만 보면되
		
		if(flag == 1 || flag == 3) {
			nx = dx[flag-1] + x;
			ny = dy[flag-1] + y;
			if(0<=nx && nx < n && 0<=ny && ny < n && map[nx][ny] != 1)
				dfs(nx, ny, flag); //그 flag값을 그대로 또 따라간다.
		}
		else { //2인경우 둘다.
			nx = dx[0] + x;
			ny = dy[0] + y;
			if(0<=nx && nx < n && 0<=ny && ny < n && map[nx][ny] != 1)
				dfs(nx,ny,1); 
			nx = dx[2] + x;
			ny = dy[2] + y;
			if(0<=nx && nx < n && 0<=ny && ny < n && map[nx][ny] != 1)
				dfs(nx,ny,3);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		cnt = 0;
		if(map[0][1] == 1) {System.out.println("0"); return;}
		dfs(0, 1, 1);//0,1부터 시작하게 하겠다.
		System.out.println(cnt);
	}
}