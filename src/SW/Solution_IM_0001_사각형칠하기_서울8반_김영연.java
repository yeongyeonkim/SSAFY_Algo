package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_IM_0001_사각형칠하기_서울8반_김영연 {

	static int[] number;
	static int[][] draw, map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			number = new int[11]; // 11가지 색
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			draw = new int[k][5];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				draw[i][0] = Integer.parseInt(st.nextToken());// 시작x
				draw[i][1] = Integer.parseInt(st.nextToken());// 시작y
				draw[i][2] = Integer.parseInt(st.nextToken());// 끝x
				draw[i][3] = Integer.parseInt(st.nextToken());// 끝y
				draw[i][4] = Integer.parseInt(st.nextToken());// 명도
			}
			int cnt = 0;
			while (cnt != k) {
				boolean flag = false;
				for (int i = draw[cnt][0]; i <= draw[cnt][2]; i++) {
					for (int j = draw[cnt][1]; j <= draw[cnt][3]; j++) {
						if (draw[cnt][4] < map[i][j])
							flag = true;
					}
				}
				if (!flag) {
					for (int i = draw[cnt][0]; i <= draw[cnt][2]; i++) {
						for (int j = draw[cnt][1]; j <= draw[cnt][3]; j++)
							map[i][j] = draw[cnt][4];
					}
				}
				cnt++;
			}

			///
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					number[map[i][j]]++;
			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < number.length; i++) {
				if (max < number[i])
					max = number[i];
			}
			System.out.println("#" + t + " " + max);
		}
	}
}