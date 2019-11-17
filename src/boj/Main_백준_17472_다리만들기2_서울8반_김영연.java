package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17472_다리만들기2_서울8반_김영연 {
	static int n, m, max;
	static int INF=Integer.MAX_VALUE/2;
	static int[][] island;
	static boolean[][] make_visit;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[] w;
	// 다리의 길이는 2 이상이어야 한다.
	// 불가능하면 -1
	public static void make_island(int x, int y, int index) {
		make_visit[x][y] = true;
		map[x][y] = index;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] tmp = q.poll(); // x, y
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m && !make_visit[nx][ny] && map[nx][ny] == 1) {
					make_visit[nx][ny] = true;
					map[nx][ny] = index;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}

	public static void find_island(int x, int y, int start) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int cnt = 0;
			// 범위넘지않고 가는 곳에 start점과 같은 게 있다면 안감
			while (true) {
				if (0 > nx || nx >= n || 0 > ny || ny >= m || map[nx][ny] == start)
					break;// 범위 나가거나 나 자체인경우
				else if (map[nx][ny] == 0) { // 다리 연결가능.
					cnt++;
					nx += dx[i];
					ny += dy[i];
					continue;
				} // 그 외는 섬을 만나면
				if (cnt < 2)
					break;
				int end = map[nx][ny];
				island[start][end] = (island[start][end] > cnt) ? cnt : island[start][end];
				island[end][start] = island[start][end];
				break;
			}
		}
	}
	
	public static void prim(int index) {
		Arrays.fill(w, -1);
		w[0] = 0;
		for(int k=1; k<index; k++) {
			int W = INF;
			int V = 0;
			for(int i = 0; i<index; i++) {
				if(w[i] < 0) continue;
				for(int j=0; j<index; j++) {
					if(w[j] >= 0) continue;
					if(island[i+1][j+1] < W) {
						W = island[i+1][j+1];
						V = j;
					}
				}
			}
			w[V] = W;
		}
		for(int i=0;i<index;i++) max += w[i];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		make_visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !make_visit[i][j])
					make_island(i, j, ++index);
			}
		}
		max = 0;
		// index개수만큼의 섬이 있음
		island = new int[index + 1][index + 1];
		for (int i = 1; i <= index; i++) {
			for (int j = 1; j <= index; j++)
				island[i][j] = INF;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (map[i][j] != 0)// 0이 아닌값이면 탐색
					find_island(i, j, map[i][j]);
		}
		w = new int[index];
		prim(index);
		if(max > 100) 
			System.out.println(-1);
		else
			System.out.println(max);
	}
}