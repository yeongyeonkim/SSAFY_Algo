package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스_서울8반_김영연 {

	static int n, m, d, cnt, max;
	static int[][] map;
	static boolean[] visit;
	static boolean[][] target;
	static ArrayList<int[]> arr;
	static Queue<int[]> q;
	static int[] dx = { 0, -1, 0 }; // 좌 상 우
	static int[] dy = { -1, 0, 1 };

	public static void shot(int x, int y, int count) {
		// BFS
		if (map[x][y] == 1) { // 바로 보여지면
			target[x][y] = true;
			return;
		}
		boolean[][] visit2 = new boolean[n][m];
		visit2[x][y] = true;
		q.add(new int[] { x, y, 1 });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if(tmp[2] == d) continue;
			for (int i = 0; i < 3; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if (0 <= nx && nx <= n && 0 <= ny && ny < m && !visit2[nx][ny]) {
					if(map[nx][ny] == 1) {
						target[nx][ny] = true;
						q.clear();
						return;
					}
					visit2[nx][ny] = true;
					q.add(new int[] {nx, ny, count + 1});
				}
			}
		}
	}

	public static void move(int[] tmp) {
		int index = n; // 처음 궁수 위치
		while (index != 0) {
			for (int i = 0; i < 3; i++) {
				shot(index - 1, tmp[i], 1);
			}
			for(int i=0 ;i<n; i++) {
				for(int j=0; j<m; j++) {
					if(target[i][j]) {
						cnt++;
						target[i][j] = false;
						map[i][j] = 0;
						arr.add(new int[] { i, j });
					}
				}
			}
			index--;
		}
	}

	public static void perm(int index, int count, int[] tmp) {
		if (count == 3) {
			cnt = 0;
			move(tmp);
			if(cnt > max) max = cnt;
			for(int i=0; i<arr.size(); i++) {
				int[] asd = arr.get(i);
				map[asd[0]][asd[1]] = 1;
			}
			return;
		}
		for (int i = index; i < m; i++) {
			if (!visit[i]) {
				visit[i] = true;
				tmp[count] = i;
				perm(i, count + 1, tmp);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m]; // [0][n]은 궁수의 위치.
		visit = new boolean[m];
		target = new boolean[n][m];
		arr = new ArrayList<>();
		q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int[] array = new int[3];
		max = Integer.MIN_VALUE;
		perm(0, 0, array);
		System.out.println(max);
	}
}
