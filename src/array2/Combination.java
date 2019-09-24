package array2;

import java.util.Arrays;
import java.util.Scanner;

//조합 nCr = nPr/r!   6C3=6*5*4/3*2*1=20
public class Combination {

	public static int n,r,caseCount,data[];
	
	public static void combination(int before, int count) {
		if(count == r) {
			for(int i=0; i<r; i++) {
				for(int j=i+1; j<r; j++) {
					if(data[i]==data[j]) return; //중복제거
				}
			}
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}
		else {
			for(int i=before; i<=n; i++) {
				data[count]=i;
				combination(i, count+1);
			}
		}
		// 1 1 1 - 1 1 2 - 1 1 3 - 1 1 4 - 1 1 5 - 1 1 6 - 1 2 1 -...
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		r=sc.nextInt();
		data=new int[r];
		combination(1, 0);
		System.out.println(caseCount);
		sc.close();
	}

}
