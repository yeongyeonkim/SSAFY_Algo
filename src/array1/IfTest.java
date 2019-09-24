package array1;

import java.util.Random;
import java.util.Scanner;

public class IfTest {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("수=");
//		int a = sc.nextInt();
		
		Random r = new Random();
		int N=r.nextInt(100)+1;
		
		if(N % 2 == 0)
			System.out.println(N+" 짝수");
		else
			System.out.println(N+" 홀수");
	}
}
/*

수=10

짝수 출력

----------

수 =9

홀수

*/