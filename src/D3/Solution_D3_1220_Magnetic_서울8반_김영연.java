package D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1220_Magnetic_서울8반_김영연 {

	static int[][] map;

	public static void sort(int n) {
		for (int y = 0; y < n; y++) {
			for (int x = n - 1; x >= 0; x--) {
				if (map[x][y] == 1) {
					int tmp_x = x; // 잠시 사용할 값
					while (true) {
						if (tmp_x + 1 == n) { // 값이 범위에 도달.
							map[x][y] = 0; // 원래 값을 0으로 바꿔준다.
							break;
						}
						if (map[tmp_x + 1][y] != 0) {
							map[x][y] = 0; // 원래 값을 없애고
							map[tmp_x][y] = 1; // 새로운 값에 1을 넣는다.
							break;
						}
						tmp_x++;
					}
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/Magnetic.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int cnt = 0;
			int n = sc.nextInt();
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					map[i][j] = sc.nextInt();
			}
			sort(n);
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == 1 && map[i+1][j] == 2)
						cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
