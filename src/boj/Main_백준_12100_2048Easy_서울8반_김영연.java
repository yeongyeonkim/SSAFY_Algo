package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_12100_2048Easy_서울8반_김영연 {

	static int n, max;

	public static void move(int count, int[][] map) {
		if (count == 5) {
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					result = Math.max(result, map[i][j]);
					max = Math.max(max, map[i][j]);
				}
			}
			return;
		}

		for (int d = 0; d < 4; d++) {
			boolean[][] visit = new boolean[n][n];
			int[][] tmp = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					tmp[i][j] = map[i][j];
				}
			}
			if (d == 0) { // up
				for (int j = 0; j < n; j++) {
					for (int i = 1; i < n; i++) {
						int now = tmp[i][j];
						if (now == 0)
							continue;
						int nx = i - 1;
						while (nx >= 0 && tmp[nx][j] == 0)
							nx--;
						if (nx == -1) { // 혹여 범위가 벗어 난 것이라면
							tmp[nx + 1][j] = tmp[i][j]; // swap하고 continue
							tmp[i][j] = 0;
							continue;
						}
						// nx값과 비교
						else {
							if (!visit[nx][j] && tmp[nx][j] == now) {
								tmp[nx][j] *= 2;
								tmp[i][j] = 0;
							} else {
								int asd = tmp[i][j];
								tmp[i][j] = 0;
								tmp[nx + 1][j] = asd;
							}
							visit[nx][j] = true;
						}
					}
				}
				move(count + 1, tmp);
			} else if (d == 1) { // left
				for (int i = 0; i < n; i++) {
					for (int j = 1; j < n; j++) {
						int now = tmp[i][j];
						if (now == 0)
							continue;
						int ny = j - 1;
						while (ny >= 0 && tmp[i][ny] == 0)
							ny--;
						if (ny == -1) { // 혹여 범위가 벗어 난 것이라면
							int asd = tmp[i][j];
							tmp[i][j] = 0;
							tmp[i][ny + 1] = asd; // swap하고 continue
							continue;
						}
						// nx값과 비교
						else {
							if (!visit[i][ny] && tmp[i][ny] == tmp[i][j]) {
								tmp[i][ny] *= 2;
								tmp[i][j] = 0;
							} else {
								int asd = tmp[i][j];
								tmp[i][j] = 0;
								tmp[i][ny + 1] = asd;
							}
							visit[i][ny] = true;
						}
					}
				}
				move(count + 1, tmp);
			} else if (d == 2) { // down
				for (int j = 0; j < n; j++) {
					for (int i = n - 2; i >= 0; i--) {
						int now = tmp[i][j];
						if (now == 0)
							continue;
						int nx = i + 1;
						while (nx < n && tmp[nx][j] == 0)
							nx++;
						if (nx == n) { // 혹여 범위가 벗어 난 것이라면
							int asd = tmp[i][j];
							tmp[i][j] = 0;
							tmp[nx - 1][j] = asd; // swap하고 continue
							continue;
						}
						// nx값과 비교
						else {
							if (!visit[nx][j] && tmp[nx][j] == tmp[i][j]) {
								tmp[nx][j] *= 2;
								tmp[i][j] = 0;
							} else {
								int asd = tmp[i][j];
								tmp[i][j] = 0;
								tmp[nx - 1][j] = asd;
							}
							visit[nx][j] = true;
						}
					}
				}
				move(count + 1, tmp);
			} else { // right
				for (int i = 0; i < n; i++) {
					for (int j = n - 2; j >= 0; j--) {
						int now = tmp[i][j];
						if (now == 0)
							continue;
						int ny = j + 1;
						while (ny < n && tmp[i][ny] == 0)
							ny++;
						if (ny == n) { // 혹여 범위가 벗어 난 것이라면
							int asd = tmp[i][j];
							tmp[i][j] = 0;
							tmp[i][ny - 1] = asd; // swap하고 continue
							continue;
						}
						// nx값과 비교
						else {
							if (!visit[i][ny] && tmp[i][ny] == tmp[i][j]) {
								tmp[i][ny] *= 2;
								tmp[i][j] = 0;
							} else {
								int asd = tmp[i][j];
								tmp[i][j] = 0;
								tmp[i][ny - 1] = asd;
							}
							visit[i][ny] = true;
						}
					}
				}
				move(count + 1, tmp);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		max = 0;
		move(0, map);
		System.out.println(max);
	}
}