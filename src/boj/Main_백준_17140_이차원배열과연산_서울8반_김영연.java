package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_백준_17140_이차원배열과연산_서울8반_김영연 {
	static int n, m;
	static int[][] map;

	public static void go() {
		int max = Integer.MIN_VALUE;
		if (n >= m) {
			for (int i = 1; i <= n; i++) { // 행의 개수만큼
				int[][] number = new int[101][2];
				for (int j = 1; j <= 100; j++)
					number[j][0] = j;
				for (int j = 1; j <= m; j++) {
					if(map[i][j] != 0) 
					number[map[i][j]][1]++;
				}
				Arrays.sort(number, new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						return Integer.compare(o1[1], o2[1]);
					}
				});
				int index = 0;
				for(int j=1; j<=100; j++) 
					map[i][j] = 0;
				for (int x = 1; x <= 100; x++) {
					if (number[x][1] == 0) continue;
					for (int y = 0; y <= 1; y++) {
						map[i][++index] = number[x][y];
					}
				}
				max = index > max ? index : max;
			}
			m = max > 100 ? 100 : max; 
		} else {
			for (int i = 1; i <= m; i++) {
				int[][] number = new int[101][2];
				for(int j=1; j<=100; j++)
					number[j][0] = j;
				for(int j=1; j<=n; j++) {
					if(map[j][i] != 0) 
					number[map[j][i]][1]++;
				}
				Arrays.sort(number, new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						return Integer.compare(o1[1], o2[1]);
					}
				});
				int index = 0;
				for(int j=1; j<=100; j++) 
					map[j][i] = 0;
				for(int x = 1; x <= 100; x++) {
					if(number[x][1] == 0) continue;
					for(int y = 0; y <= 1; y++) {
						map[++index][i] = number[x][y];
					}
				}
				max = index > max ? index : max;
			}
			n = max > 100 ? 100 : max;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[101][101];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		n = 3;
		m = 3;
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		// n행의 개수 m열의개수
		int cnt = 0;
		while (cnt <= 100) {
			if(map[a][b] == c) break;
			go();
			cnt++;
		}
		if (cnt > 100)
			System.out.println("-1");
		else
			System.out.println(cnt);
	}
}