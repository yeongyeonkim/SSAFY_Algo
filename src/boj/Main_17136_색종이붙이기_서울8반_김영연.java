package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기_서울8반_김영연 {

	static int[][] map;
	static int min;

	public static void dfs(int p1, int p2, int p3, int p4, int p5) {
		if (p1 < 0 || p2 < 0 || p3 < 0 || p4 < 0 || p5 < 0)
			return;
		int x = -1;
		int y = -1;
		boolean exit = false;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(exit) break;
				if (map[i][j] == 1) {
					x = i;
					y = j;
					exit = true;
				}
			}
			if(exit) break;
		}
		if (x == -1 && y == -1) {// 못찾았으니
			int cnt = 25 - p1 - p2 - p3 - p4 - p5;
			if (min > cnt)
				min = cnt;
			return;
		}
		int index = 1;
		while (index <= 5) {
			boolean flag = false;
			for (int i = x; i < x + index; i++) {
				for (int j = y; j < y + index; j++) {
					if (map[i][j] == 0)
						flag = true;
				}
			}
			if (flag)
				break;
			index++;
			if (x + index > 10 || y + index > 10)
				break;
		}
		index--;
		switch (index) {
		case 5:
			change(x, y, 5);
			dfs(p1, p2, p3, p4, p5 - 1);
			rechange(x, y, 5);
		case 4:
			change(x, y, 4);
			dfs(p1, p2, p3, p4 - 1, p5);
			rechange(x, y, 4);
		case 3:
			change(x, y, 3);
			dfs(p1, p2, p3 - 1, p4, p5);
			rechange(x, y, 3);
		case 2:
			change(x, y, 2);
			dfs(p1, p2 - 1, p3, p4, p5);
			rechange(x, y, 2);
		case 1:
			change(x, y, 1);
			dfs(p1 - 1, p2, p3, p4, p5);
			rechange(x, y, 1);
		}
	}

	public static void change(int x, int y, int index) {
		for (int i = x; i < x + index; i++) {
			for (int j = y; j < y + index; j++)
				map[i][j] = 0;
		}
	}

	public static void rechange(int x, int y, int index) {
		for (int i = x; i < x + index; i++) {
			for (int j = y; j < y + index; j++)
				map[i][j] = 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		dfs(5, 5, 5, 5, 5);
		if (min > 25)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}