package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_다리만들기2 {

	static int n, m, min, INF;
	static int[][] island;
	static int[][] map;
	static int[][] node;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void make_index(int x, int y, int index) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		map[x][y] = index;
		island[x][y] = 0;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + tmp[0];
				int ny = dy[i] + tmp[1];
				if (0 <= nx && nx < n && 0 <= ny && ny < m && island[nx][ny] == 1) {
					map[nx][ny] = index;
					island[nx][ny] = 0;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}

	public static void count_length(int x, int y) {
		//4방탐색
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int cnt = 0;
			while(true) {
				if(0>nx||nx>=n||0>ny||ny>=m) {
					cnt = INF; 
					break; //범위벗어나면 break
				}
				if(map[nx][ny] != 0) {
					
					break;
				}
				nx += dx[i];
				ny += dy[i];
				cnt++;
			}
			
		}
	}

	public static void kruskal() {

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		island = new int[n][m];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				island[i][j] = Integer.parseInt(st.nextToken());
		}
		int index = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (island[i][j] == 1)
					make_index(i, j, index++);
			}
		}
		node = new int[index + 1][index + 1];
		INF = Integer.MAX_VALUE / 2;
		for (int i = 1; i <= index; i++) {
			for (int j = 1; j <= index; j++)
				node[i][j] = INF;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] != 0) count_length(i, j);
			}
		}
		min = 0;
		kruskal();
		System.out.println(min);
	}
}