package D2;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D2_1989_초심자의회문검사_서울8반_김영연 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/palin.txt"));
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			int cnt = 0;
			sc.nextLine();
			String s = sc.next();
			char[] map = new char[s.length()];
			for (int i = 0; i < s.length(); i++) {
				map[i] = s.charAt(i);
			}
			for (int k = 0; k < s.length() / 2; k++) {
				if (map[k] == map[s.length() - 1 - k])
					cnt++;
			}
			if (cnt == s.length()/2)
				System.out.println("#" + t + " 1");
			else
				System.out.println("#" + t + " 0");
		}
	}
}