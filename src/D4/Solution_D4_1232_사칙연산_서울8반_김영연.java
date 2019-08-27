package D4;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D4_1232_사칙연산_서울8반_김영연 {
	static String[][] list;

	public static int dfs(int n) {
		if (list[n][1].equals("*"))
			return dfs(Integer.parseInt(list[n][2])) * dfs(Integer.parseInt(list[n][3]));
		else if (list[n][1].equals("/"))
			return dfs(Integer.parseInt(list[n][2])) / dfs(Integer.parseInt(list[n][3]));
		else if (list[n][1].equals("+"))
			return dfs(Integer.parseInt(list[n][2])) + dfs(Integer.parseInt(list[n][3]));
		else if (list[n][1].equals("-"))
			return dfs(Integer.parseInt(list[n][2])) - dfs(Integer.parseInt(list[n][3]));
		else
			return Integer.parseInt(list[n][1]);
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/Arithmetic.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			sc.nextLine();
			list = new String[n + 1][4];
			for (int i = 1; i <= n; i++) {
				String[] info = sc.nextLine().split(" ");
				int cnt = 0;
				for (String wo : info) {
					list[i][cnt++] = wo;
				}
			}
			System.out.println("#" + t + " " + dfs(1));
		}
	}
}
