package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_14500_테트로미노_서울8반_김영연 {

	static int row, col, max;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		visit = new boolean[row][col];
		max = 0;
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				visit[i][j] = true;
				DFS(i, j, 1, map[i][j]);
				visit[i][j] = false;
				T(i, j);
			}
		}
		System.out.println(max);
	}

	public static void DFS(int x, int y, int cnt, int sum) {
		if (cnt == 4 || sum > max) { // 4인 애들 종료
			max = max > sum ? max : sum;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < row && 0 <= ny && ny < col && !visit[nx][ny]) {
				visit[nx][ny] = true;
				DFS(nx, ny, cnt + 1, sum + map[nx][ny]);
				visit[nx][ny] = false;
			}
		}
	}

	public static void T(int x, int y) {
		// 0뺀거 1뺸거 2뺀거 3뺀거 4뺀거
		for (int k = 0; k < 4; k++) {
			int sum = map[x][y];
			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				if(flag)break;
				if(k==i) continue;
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx < row && 0<=ny && ny < col)
					sum += map[nx][ny];
				else flag = true;
			}
			if(!flag) max = max > sum ? max : sum;
		}
	}

}
