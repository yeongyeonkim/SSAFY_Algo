package D3;

import java.util.Scanner;

public class Solution_D3_1216_회문2_서울8반_김영연 {
	public static void main(String args[]) {
//		System.setIn(new FileInputStream("res/palindrome.txt"));
		Scanner sc = new Scanner(System.in);
		char[][] map = new char[100][100]; // 100x100배열

		for (int t = 1; t <= 10; t++) {
			int max = 1;
			int TestCase = sc.nextInt();
			sc.nextLine();
			int cnt_r = 0, cnt_b = 0;
			for (int i = 0; i < 100; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < s.length(); j++) {
					map[i][j] = s.charAt(j);
				}
			}
			for (int h = 100; h >= 0; h--) {
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j < 100; j++) {
						cnt_r = 0;
						cnt_b = 0;
						for (int k = 0; k < h / 2; k++) {
							if (j + h - 1 < 100 && map[i][j + k] == map[i][j + h - 1 - k])
								cnt_r++;
							if (i + h - 1 < 100 && map[i + k][j] == map[i + h - 1 - k][j])
								cnt_b++;
						}
						if (cnt_r == h / 2 || cnt_b == h / 2)
							max = h;
					}
					if (max > 1)
						break;
				}
				if (max > 1) {
					System.out.println("#" + TestCase + " " + max);
					break;
				}
			}
		}
	}
}
