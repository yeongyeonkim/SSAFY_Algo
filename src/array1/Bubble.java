package array1;

import java.util.Arrays;
import java.util.Scanner;

public class Bubble {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i=a.length-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				if(a[i] < a[j]) {
					int tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
				System.out.println(Arrays.toString(a)+" i="+i);				
			}
		}
		for(int i=0; i<n; i++) {
			System.out.print(a[i] + " ");
		}
	}
}