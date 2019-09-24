package array2;

import java.util.Arrays;
import java.util.Scanner;

//중복조합 nHr=n+r-1Cr 6H3=6+3-1C3=8C3=8P3/3!=8*7*6/3*2*1=56
public class Homogeneous {

	public static int n,r,caseCount,data[];
	
	public static void homogeneous(int before, int count) {
		if(count == r) {
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}
		else {
			for(int i=before; i<=n; i++) {
				data[count]=i;
				homogeneous(i, count+1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		r=sc.nextInt();
		data=new int[r];
		homogeneous(1, 0);
		System.out.println(caseCount);
		sc.close();
	}
}