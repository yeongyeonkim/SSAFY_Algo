package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_2580_스도쿠_서울8반_김영연 {
	static int n, count;
	static int[][] map;
	static ArrayList<int[]> arr;
	static boolean flag;

	public static boolean col(int x, int y) { // 행
		for (int j = 0; j < n; j++) {
			if (y == j) continue;
			if (map[x][y] == map[x][j])  return false;
		}
		return true;
	}

	public static boolean row(int x, int y) { // 열
		for (int i = 0; i < n; i++) {
			if (x == i) continue;
			if (map[x][y] == map[i][y]) return false;
		}
		return true;
	}

	public static boolean check(int x, int y) {
		if (col(x, y) && row(x, y)) return true;
		else return false;
	}

	public static void find(int count) {
		if (count == arr.size()) {
			flag = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
		if (flag) return;
		
		int x = arr.get(count)[0];
		int y = arr.get(count)[1];
		int r = x / 3;
		int c = y / 3;
		r *= 3;
		c *= 3;
		boolean[] can = new boolean[10];
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) can[map[i][j]] = true;
		} // square check

		for (int i = 1; i < 10; i++) {
			if (!can[i] && map[x][y] == 0) {
				map[x][y] = i;
				if (check(x, y)) find(count + 1);
				map[x][y] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = 9;
		map = new int[n][n];
		arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if (num == 0) arr.add(new int[] { i, j });
			}
		}
		flag = false;
		find(0);
	}
}