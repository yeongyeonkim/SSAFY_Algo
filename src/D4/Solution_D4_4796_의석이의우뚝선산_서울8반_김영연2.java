package D4;

import java.util.Scanner;

public class Solution_D4_4796_의석이의우뚝선산_서울8반_김영연2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			int cnt = 0;
			for (int i = 1; i < n - 1; i++) {
				if (a[i - 1] < a[i] && a[i] > a[i + 1]) {
					int left = i-1;
					int right = i+1;
					while(true) {
						if(left - 1 >= 0) {
							left--;
							if(a[left] < a[left + 1]) continue; 
							else {
								left++;
								break;
							}
						} else break;
					}
					while(true) {
						if(right + 1 < n) {
							right++;
							if(a[right - 1] < a[right]) continue;
							else {
								right--;
								break;
							}
						} else break;
					}
					cnt += (i - left) * (right - i);
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
