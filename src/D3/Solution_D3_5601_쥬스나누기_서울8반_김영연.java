package D3;

import java.util.Scanner;

public class Solution_D3_5601_쥬스나누기_서울8반_김영연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			System.out.print("#"+t);
			for(int i=0; i<n; i++)
				System.out.print(" 1/"+n);
			System.out.println();
		}
	}
}
