package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17144_미세먼지안녕_서울8반_김영연 {
	
	static int n, m, s_x;
	static int[] dx = {0,1,0,-1}; //오른쪽 아래 왼쪽 위
	static int[] dy = {1,0,-1,0};
	static int[][] map;
	static boolean[][] visit;
	
	public static void rotate1() {
		int save = map[s_x-1][0]; // 시작점을 기억
		for(int i=s_x-1; i>0; i--) 
			map[i][0] = map[i-1][0];
		for(int i=1; i<m; i++) 
			map[0][i-1] = map[0][i];
		for(int i=1; i<=s_x; i++) 
			map[i-1][m-1] = map[i][m-1];
		for(int i=m-1; i>=1; i--) 
			map[s_x-1][i] = map[s_x-1][i-1];
		map[s_x-1][0] = -1;
		map[s_x-1][1] = save;
	}
	public static void rotate2() {
		int save = map[s_x][0];
		for(int i=s_x; i<n-1; i++) 
			map[i][0] = map[i+1][0];
		for(int i=1; i<m; i++)
			map[n-1][i-1] = map[n-1][i];
		for(int i=n-1; i>s_x; i--)
			map[i][m-1] = map[i-1][m-1];
		for(int i=m-1; i>0; i--)
			map[s_x][i] = map[s_x][i-1];
		map[s_x][0] = -1;
		map[s_x][1] = save;
	}
	
	public static void BFS(Queue<int[]> q) {
		int[][] copy = new int[n][m];
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int divide = map[tmp[0]][tmp[1]] / 5;
			for(int i=0; i<4; i++) {
				int nx = dx[i] + tmp[0];
				int ny = dy[i] + tmp[1];
				if(0<=nx && nx < n && 0<=ny && ny < m && map[nx][ny] != -1) {
					copy[nx][ny] += divide;
					map[tmp[0]][tmp[1]] -= divide;
				}
			}
			copy[tmp[0]][tmp[1]] += map[tmp[0]][tmp[1]];
		}
		map = copy.clone(); // 짱짱맨
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) s_x = i; //아래부분을 행
			}
		}
		for(int k=t; k>0; k--) {
			//확산.
			visit = new boolean[n][m];
			Queue<int[]> q = new LinkedList<>();
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] != 0 && map[i][j] != -1) 
						q.add(new int[] {i , j});
				}
			}
			BFS(q);
			rotate1();
			rotate2();
		}		
		int sum = 2;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++)
				sum += map[i][j];
		}
		System.out.println(sum);
	}
}