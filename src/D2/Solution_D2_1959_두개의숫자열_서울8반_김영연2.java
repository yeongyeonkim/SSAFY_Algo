package D2;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D2_1959_두개의숫자열_서울8반_김영연2 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/TwoString.txt"));
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			int total = 0;
			int n = sc.nextInt();
			int m = sc.nextInt();
			int min = n <= m ? n : m;
			int max = n >= m ? n : m;
			int[] list1 = new int[n];
			int[] list2 = new int[m];
			for (int i = 0; i < n; i++)
				list1[i] = sc.nextInt();
			for (int i = 0; i < m; i++)
				list2[i] = sc.nextInt();
			for (int i = 0; i <= max - min; i++) {
				int sum = 0;
				for (int j = 0; j < min; j++) {
					if (n < m)
						sum += list1[j] * list2[j + i];
					else
						sum += list1[j + i] * list2[j];
				}
				if (sum > total)
					total = sum;
			}
			System.out.println("#" + t + " " + total);
		}
	}
}