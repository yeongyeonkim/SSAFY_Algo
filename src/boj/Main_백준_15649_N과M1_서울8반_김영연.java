package boj;

import java.util.Scanner;

public class Main_백준_15649_N과M1_서울8반_김영연 {

	static int n, m;
	static boolean[] visit;

	public static void perm(int count, int[] a) {
		if (count == m) {
			for(int i=0; i<a.length; i++)
				System.out.print(a[i] + " ");
			System.out.println();
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				a[count] = i;
				perm(count + 1, a);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		// n까지 수에서 중복 없이 M개를 고른 수열
		visit = new boolean[n + 1];
		int[] a = new int[m];
		perm(0, a);
	}
}