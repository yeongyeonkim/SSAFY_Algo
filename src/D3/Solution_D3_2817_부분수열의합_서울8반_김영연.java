package D3;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_2817_부분수열의합_서울8반_김영연 {
//	public static int[] data = { 1, 2, 3, 4 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int cnt = 0;
			int n = sc.nextInt();
			int[] data = new int[n];
			int s = sc.nextInt();
			for (int i = 0; i < n; i++) {
				data[i] = sc.nextInt();
			}
			for (int i = 0; i < (1 << data.length); i++) {
				int sum = 0;
				for (int j = 0; j < data.length; j++) {
					if ((i & (1 << j)) > 0) {//비트연산자
						System.out.print(data[j] + " ");
						sum = sum + data[j];
					}
				}
				if(sum == s)
					cnt++;
				System.out.println();
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}