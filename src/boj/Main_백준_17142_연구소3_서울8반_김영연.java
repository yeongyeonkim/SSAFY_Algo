package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17142_연구소3_서울8반_김영연 {

	static int n, m, cnt, blank;
	static int[] a;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<int[]> virus;

	public static void BFS() {
		int asd = blank;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			int[] node = virus.get(a[i]);
			visit[node[0]][node[1]] = true;
			q.add(node);
		}
		int tmp_cnt = 0;
		while (!q.isEmpty() && asd != 0) {
			int size = q.size();
			for(int j=0; j<size; j++) {
				int[] tmp = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + tmp[0];
					int ny = dy[i] + tmp[1];
					if (0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] != 1 && !visit[nx][ny]) {
						if (map[nx][ny] == 0) asd--;
						visit[nx][ny] = true;
						q.add(new int[] { nx, ny });
					}
				}
			}
			tmp_cnt++;
		}
		if(asd == 0) cnt = cnt < tmp_cnt ? cnt : tmp_cnt;
	}

	public static void comb(int start, int count) {
		if (count == m) {
			visit = new boolean[n][n];
			BFS();
			return;
		}
		for (int i = start+1; i < virus.size(); i++) {
			a[count] = i;
			comb(i, count + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		virus = new ArrayList<>();
		blank = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if (num == 2) virus.add(new int[] { i, j });
				else if (num == 0) blank++;
			}
		}
		a = new int[m];
		// 중복없는 순열
		cnt = Integer.MAX_VALUE;
		comb(-1, 0);
		if (cnt >= Integer.MAX_VALUE / 2)
			System.out.println("-1");
		else
			System.out.println(cnt);
	}
}