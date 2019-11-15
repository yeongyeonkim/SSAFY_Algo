package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_14502_연구소_서울8반_김영연 {

	static int n, m, max;
	static int[] a;
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<int[]> pillar;
	
	public static void BFS(int x, int y) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x , y } );
		visit[x][y] = true;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i=0; i<4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if(0<=nx&&nx<n&&0<=ny&&ny<m&&!visit[nx][ny]&&map[nx][ny]==0) {
					visit[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
	public static void comb(int index, int count) {
		if(count == 3) {
			visit = new boolean[n][m];
			for(int i=0; i<a.length; i++) 
				visit[pillar.get(a[i])[0]][pillar.get(a[i])[1]] = true;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] == 2) BFS(i, j);
				}
			}
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++)
					if(map[i][j] == 0 && !visit[i][j]) cnt++;
			}
			
			max = Math.max(max, cnt);
			return;
		}
		for(int i=index+1; i<pillar.size(); i++) {
			a[count] = i;
			comb(i, count + 1);
		}		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		a = new int[3];
		pillar = new ArrayList<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				int number = Integer.parseInt(st.nextToken());
				map[i][j] = number;
				if(number == 0) pillar.add(new int[] {i, j});
			}
		}
		max = Integer.MIN_VALUE;
		comb(-1, 0);
		System.out.println(max);
	}
}