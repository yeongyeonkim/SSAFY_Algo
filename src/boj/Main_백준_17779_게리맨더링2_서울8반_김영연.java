package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17779_게리맨더링2_서울8반_김영연 {

	static int n, min, total;
	static int[][] map;

	public static void find(int x, int y, int d1, int d2) {
		int[] number = new int[5];
		// 1
		for (int i = 1; i < x; i++) {
			for (int j = 1; j <= y; j++)
				number[0] += map[i][j];
		}
		int index = 1;
		for (int i = x; i < x + d1; i++) {
			for (int j = y - index; j >= 1; j--) {
				number[0] += map[i][j];
			}
			index++;
		}
		// 2
		for (int i = 1; i < x; i++) {
			for (int j = y + 1; j <= n; j++)
				number[1] += map[i][j];
		}
		index = 0;
		for (int i = x; i <= x + d2; i++) {
			for (int j = y + 1 + index; j <= n; j++) {
				number[1] += map[i][j];
			}
			index++;
		}
		// 3
		index = 0;
		for (int i = x + d1; i <= x + d1 + d2; i++) {
			for (int j = 1; j < y - d1 + index; j++) {
				number[2] += map[i][j];
			}
			index++;
		}
		for (int i = x + d1 + d2 + 1; i <= n; i++) {
			for (int j = 1; j < y - d1 + d2; j++)
				number[2] += map[i][j];
		}
		// 4
		for (int i = x + d1 + d2 + 1; i <= n; i++) {
			for (int j = y - d1 + d2; j <= n; j++) {
				number[3] += map[i][j];
			}
		}
		index = 1;
		for (int i = x + d1 + d2; i > x + d2; i--) {
			for (int j = y - d1 + d2 + index; j <= n; j++) {
				number[3] += map[i][j];
			}
			index++;
		}
		number[4] = total - number[0] - number[1] - number[2] - number[3];
		Arrays.sort(number);
		int tmp_min = number[4] - number[0];
		min = min < tmp_min ? min : tmp_min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		total = 0;
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				int number = Integer.parseInt(st.nextToken());
				map[i][j] = number;
				total += number;
			}
		}
		min = Integer.MAX_VALUE;
		for (int x = 1; x <= n - 2; x++) {
			for (int y = 2; y <= n - 1; y++) {
				for (int d1 = 1; (x + d1 < n) && (y - d1 >= 1); d1++) {
					for (int d2 = 1; (x + d1 + d2 <= n) && (y + d2 <= n); d2++) {
						find(x, y, d1, d2);
					}
				}
			}
		}

		System.out.println(min);
	}
}