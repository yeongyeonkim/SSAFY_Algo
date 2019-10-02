package Line;

import java.util.Scanner;

public class Solution_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] con = new int[y];
		for(int i=0; i<x; i++) {
			int n = sc.nextInt();
			int min = Integer.MAX_VALUE;
			int min_index = 0;
			for(int j=0; j<y; j++) {
				if(min > con[j]) {
					min = con[j];
					min_index = j;
				}
			}
			con[min_index] += n;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<y; i++) 
			if(max < con[i]) max = con[i];
		System.out.println(max);
	}
}
