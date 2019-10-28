package boj;

import java.util.Scanner;

public class Main_백준_15649_N과M3_서울8반_김영연 {
	
	static int n,m;
	static StringBuilder sb;
	public static void comb(int index, int count, int[] a) {
		if(count == m) {
			for(int b : a)
				sb.append(b + " ");
			sb.append("\n");
			return;
		}
		for(int i=1; i<=n; i++) {
			a[count] = i;
			comb(i, count+1,a);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sb = new StringBuilder();
		int[] a = new int[m];
		comb(1, 0, a);
		System.out.println(sb.toString());
	}

}
