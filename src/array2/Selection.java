package array2;

import java.util.Arrays;

public class Selection {
	public static int[] a = { 64, 25, 10, 22, 11 };

	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		System.out.println();
		
		for(int i=0; i<a.length; i++) {
			int min = i;
			for(int j=i+1; j<a.length; j++) {
				if(a[j]<a[min]) min = j;
			}
			int tmp = a[i];
			a[i] = a[min];
			a[min] = tmp;
			System.out.println(Arrays.toString(a));
		}
		System.out.println(Arrays.toString(a));
	}
}