package dp;

import java.util.Arrays;
import java.util.Scanner;

/*
4
10
5 10
4 40
6 30
3 50
 */
public class KnapsackTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[] w=new int[N];
		int[] v=new int[N];
		int[][] k = new int[N+1][W+1];
		
		for(int i=0; i<N; i++) {
			w[i]=sc.nextInt();//weight
			v[i]=sc.nextInt();//value
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=W; j++) {
				if(w[i-1]>j) {
					k[i][j] = k[i-1][j];
				} else {
					k[i][j] = Math.max(k[i-1][j-w[i-1]]+v[i-1], k[i-1][j]);
				}
			}
		}
		System.out.println(k[N][W]);
		for(int[] a : k) System.out.println(Arrays.toString(a));
	}
}