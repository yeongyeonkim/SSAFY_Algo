package D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1217_거듭제곱_서울8반_김영연 {
//	static int sum;
//	public static int expo(int n, int k) {
//		if(k == 0)
//			return sum;
//		sum *= n;
//		return expo(n,k - 1);
//	}
//	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/exponentiation.txt"));
//		Scanner sc = new Scanner(System.in);
//		for (int t = 1; t <= 10; t++) {
//			int testcase =sc.nextInt();
//			sum  = 1;
//			int n = sc.nextInt();
//			int k = sc.nextInt();
//			System.out.println("#"+testcase+" "+expo(n, k));
//		}
//	}
	public static int pow3(int n,int m) {
		if(m==1) return n;
		if((m&1) == 0 ) {
			int y = pow3(n,m/2);
			return y*y;
		}
		else {
			int y = pow3(n, (m-1)/2);
			return n*y*y;
		}
	}
}
