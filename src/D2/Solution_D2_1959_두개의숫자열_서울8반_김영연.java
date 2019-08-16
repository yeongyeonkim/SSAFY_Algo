package D2;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D2_1959_두개의숫자열_서울8반_김영연 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/TwoString.txt"));
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			int max = 0;
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] list1 = new int[n];
			int[] list2 = new int[m];
			for (int i = 0; i < n; i++) {
				list1[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				list2[i] = sc.nextInt();
			}
			if (m > n) { // n이 작으면
				for (int i = 0; i <= m - n; i++) {
					int sum = 0;
					for (int j = 0; j < n; j++) {
						sum += list1[j] * list2[j+i];
					}
					if(sum > max) max = sum;
				}
			}
			else { // m이 작으면
				for(int i=0; i<= n-m; i++) {
					int sum = 0;
					for(int j=0; j<m; j++) {
						sum += list1[j+i] * list2[j];
					}
					if(sum > max) max = sum;
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}