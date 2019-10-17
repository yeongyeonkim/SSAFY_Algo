package D5;

import java.util.Scanner;

public class Solution_D5_1265_달란트2_서울8반_김영연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int total = sc.nextInt();
			int n = sc.nextInt();
			int[] c = new int[n];
			for(int i=0; i<n; i++) c[i] = total/n;
			for(int i=0; i<total%n; i++) c[i]++;
			long result = 1;
			for(int i=0; i<n; i++) result *= c[i];
			System.out.println("#"+t+" "+result);
		}
	}
}