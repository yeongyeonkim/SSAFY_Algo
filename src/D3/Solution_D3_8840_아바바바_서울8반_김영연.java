package D3;

import java.util.Scanner;

public class Solution_D3_8840_아바바바_서울8반_김영연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		for(int t=1; t<=c; t++) {
			long l = sc.nextLong()/2;
			System.out.println("#"+t+" "+l*l);
		}
	}
}
