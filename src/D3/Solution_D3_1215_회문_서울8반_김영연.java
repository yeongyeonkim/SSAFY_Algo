package D3;

import java.util.Scanner;

public class Solution_D3_1215_회문_서울8반_김영연 {
	public static void main(String args[]){
//		System.setIn(new FileInputStream("res/palindrome.txt"));
		Scanner sc = new Scanner(System.in);
		char[][] map = new char[8][8];
		int flag_r, flag_b;
		for (int t = 1; t <= 10; t++) {
			int cnt = 0;
			int n = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < 8; i++) {
				String s = sc.nextLine();
				for(int j=0; j<s.length(); j++) {
					map[i][j] = s.charAt(j);
				}
			}
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					flag_r = 0;
					flag_b = 0;
					for (int k = 0; k < n / 2; k++) {
						if (j + n - 1 < 8 && map[i][j + k] == map[i][j + n - 1 - k]) flag_r++;
						if (i + n - 1 < 8 && map[i + k][j] == map[i + n - 1 - k][j]) flag_b++;
					}
					if (flag_r == n/2) cnt++;
					if (flag_b == n/2) cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}