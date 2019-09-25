package dp;

import java.util.Arrays;

public class LisTest1 {

	public static void main(String[] args) {
		int[] a = {3,2,6,4,5,1};
		int n = a.length;
		int[] l = new int[n];
		for(int i=0; i<n; i++) {
			l[i] = 1;
			for(int j=0; j<i; j++) {
				if(a[j]<a[i] && l[i]<1+l[j]) {
								l[i]=1+l[j];
				}
			}
		}
		System.out.println(Arrays.toString(l));
		System.out.println(Arrays.stream(l).max().getAsInt());
	}
}
