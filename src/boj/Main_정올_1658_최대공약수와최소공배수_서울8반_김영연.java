package boj;

import java.util.Scanner;

public class Main_정올_1658_최대공약수와최소공배수_서울8반_김영연 {

	public static int gcd(int a, int b) {
		if(b==0)return a;
		return gcd(b, a%b);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int min = gcd(a,b);
		System.out.println(min);
		System.out.println((a/min)*(b/min)*min);
	}
}
