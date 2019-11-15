package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_15683_감시_서울8반_김영연 {

	static int n, m, min;
	static int[][] map;
	static ArrayList<int[]> cctv;
	static int[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void revert(Queue<int[]> change) {
		while (!change.isEmpty()) {
			int[] t_c = change.poll();
			visit[t_c[0]][t_c[1]]--;
		}
	}

	public static void comb(int count) {
		if (count == cctv.size()) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					if (visit[i][j] == 0 && map[i][j] != 6) cnt++;
			}
			min = Math.min(min, cnt);
			return;
		}
		int tmp[] = cctv.get(count);
		Queue<int[]> change = new LinkedList<>();
		if (tmp[2] == 1 || tmp[2] == 5) {
			for (int i = 0; i < 4; i++) {
				int x = tmp[0];
				int y = tmp[1];
				while (0 <= x && x < n && 0 <= y && y < m && map[x][y] < 6) {
					visit[x][y]++;
					change.add(new int[] { x, y });
					x += dx[i];
					y += dy[i];
				}
				if(tmp[2] == 5) continue;
				comb(count + 1);
				revert(change);
			}
			if(tmp[2] == 1) return;
			comb(count + 1);
			revert(change);
		} else if (tmp[2] == 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = i; j <= i + 2; j += 2) {
					int x = tmp[0];
					int y = tmp[1];
					while (0 <= x && x < n && 0 <= y && y < m && map[x][y] < 6) {
						visit[x][y]++;
						change.add(new int[] { x, y });
						x += dx[j];
						y += dy[j];
					}
				}
				comb(count + 1);
				revert(change);
			}
		} else { // 3, 4
			for (int i = 0; i < 4; i++) {
				for (int j = i; j <= i + tmp[2] - 2; j++) {
					int x = tmp[0];
					int y = tmp[1];
					while (0 <= x && x < n && 0 <= y && y < m && map[x][y] < 6) {
						visit[x][y]++;
						change.add(new int[] { x, y });
						x += dx[j%4];
						y += dy[j%4];
					}
				}
				comb(count + 1);
				revert(change);
			}
		} 
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cctv = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				int number = Integer.parseInt(st.nextToken());
				map[i][j] = number;
				if (number != 0 && number != 6)
					cctv.add(new int[] { i, j, number });
			}
		}
		visit = new int[n][m];
		min = Integer.MAX_VALUE;
		comb(0);
		System.out.println(min);
	}

}