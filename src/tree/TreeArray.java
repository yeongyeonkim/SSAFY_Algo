package tree;

import java.util.Scanner;

public class TreeArray {

	public static int N;
	public static int[] a;
	
	public static void preorder(int i) {
		if(i<=N && a[i] !=0) {
			System.out.print(a[i] + " ");
			preorder(2*i);
			preorder(2*i + 1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N+1];
		for(int i=1; i<=N; i++) a[i] = sc.nextInt();
		preorder(1);
		System.out.println();
	}

}
