package array2;

import java.util.Arrays;
import java.util.Scanner;
//중복순열 nPIr = n^r
public class Product {

	public static int n,r,caseCount,data[];
	
	public static void product(int count) {
		if(count == r) {
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}
		else {
			for(int i=1; i<=n; i++) {
				data[count]=i;
				product(count+1);
			}
		}
		// 1 1 1 - 1 1 2 - 1 1 3 - 1 1 4 - 1 1 5 - 1 1 6 - 1 2 1 -...
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		r=sc.nextInt();
		data=new int[r];
		product(0);
		System.out.println(caseCount);
		sc.close();
	}
}