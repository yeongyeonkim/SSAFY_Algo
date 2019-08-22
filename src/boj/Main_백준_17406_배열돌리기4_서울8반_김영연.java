package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17406_배열돌리기4_서울8반_김영연 {

	static int[][] list;
	static int[] dx = { 0, 1, 0, -1 }; // 정방(오른쪽,아래,왼쪽,위)
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx2 = { 1, 0, -1, 0 }; // 역방(아래,오른쪽,위,왼쪽)
	static int[] dy2 = { 0, 1, 0, -1 };
	static int[][] rcs;
	static int min, n, m, k;
	static boolean[] visit;

	public static void rotate(int r, int c, int s) {
		int x = r - s - 1;
		int y = c - s - 1;
		while (s != 0) {
			int tmp1 = list[x][y]; // 끝점 기억.
			int tmp2 = list[x][y + 1];
			int nx = x, ny = y;
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= s * 2; j++) {
					list[nx + dx[i]][ny + dy[i]] = tmp1; // 값 바꿔주고
					tmp1 = tmp2; // 다음요소를 tmp2에
					nx += dx[i];
					ny += dy[i];
					if (j == s * 2)
						tmp2 = list[nx + dx[(i + 1) % 4]][ny + dy[(i + 1) % 4]];
					else
						tmp2 = list[nx + dx[i]][ny + dy[i]];
				}
			}
			s--;
			x++;
			y++;
		}
	}

	public static void rotate2(int r, int c, int s) {
		int x = r - s - 1;
		int y = c - s - 1;
		while (s != 0) {
			int tmp1 = list[x][y];
			int tmp2 = list[x + 1][y];
			int nx = x, ny = y;
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= s * 2; j++) {
					list[nx + dx2[i]][ny + dy2[i]] = tmp1; // 값 바꿔주고
					tmp1 = tmp2; // 다음 요소를 tmp2에
					nx += dx2[i];
					ny += dy2[i];
					if (j == s * 2)
						tmp2 = list[nx + dx2[(i + 1) % 4]][ny + dy2[(i + 1) % 4]];
					else
						tmp2 = list[nx + dx2[i]][ny + dy2[i]];
				}
			}
			s--;
			x++;
			y++;
		}
	}

	public static void perm(int s, int count) {
		
		if (k == count) {
			// min값 갱신 이때의 배열의 행 합 다 더하기
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < m; j++) {
					sum += list[i][j];
				}
				if (min >= sum)
					min = sum;
			}
		}
		for (int i = 0; i < k; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				rotate(rcs[i][0], rcs[i][1], rcs[i][2]);
				perm(i, count + 1);
				visit[i] = false;
				rotate2(rcs[i][0], rcs[i][1], rcs[i][2]);				
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		list = new int[n][m];
		rcs = new int[k][3];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				list[i][j] = Integer.parseInt(st.nextToken());
		}
		visit = new boolean[k];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			rcs[i][0] = Integer.parseInt(st.nextToken());
			rcs[i][1] = Integer.parseInt(st.nextToken());
			rcs[i][2] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < k; i++) {
			visit[i] = true;
			rotate(rcs[i][0], rcs[i][1], rcs[i][2]);
			perm(i, 1);
			visit[i] = false;
			rotate2(rcs[i][0], rcs[i][1], rcs[i][2]);
		}
		System.out.println(min);
	}
}
