package boj;

import java.util.Scanner;

public class Main_정올_1719_별삼각형2_서울8반_김영연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (1 <= n && n <= 99 && n % 2 == 1 && 1 <= m && m <= 4) {
			if (m == 1) {
				for(int i=1; i<=n/2+1; i++) {
					for(int j=1; j<=i; j++) 
						System.out.print("*");
					System.out.println();
				}
				for(int i=n/2; i>=1; i--) {
					for(int j=1; j<=i; j++)
						System.out.print("*");
					System.out.println();
				}
			} else if (m == 2) {
				int index = n/2;
				for(int i=1; i<=n/2 + 1; i++) {
					for(int j=1; j<=index; j++)
						System.out.print(" ");
					for(int j=1; j<=i; j++)
						System.out.print("*");
					System.out.println();
					index--;
				}
				index = 1;
				for(int i=n/2; i>=1; i--) {
					for(int j=1; j<=index; j++) 
						System.out.print(" ");
					for(int j=1; j<=i; j++)
						System.out.print("*");
					System.out.println();
					index++;
				}
			} else if (m == 3) {
				int index = 0;
				for(int i=n/2; i>=0; i--) {
					for(int j=1; j<=index; j++)
						System.out.print(" ");
					for(int j=1; j<=2*i+1; j++)
						System.out.print("*");
					System.out.println();
					index++;
				}
				index = n/2 - 1;
				for(int i=1; i<=n/2; i++) {
					for(int j=1; j<=index; j++)
						System.out.print(" ");
					for(int j=1; j<=2*i+1; j++)
						System.out.print("*");
					System.out.println();
					index--;
				}
			} else {
				int index = 0;
				for(int i=0; i<=n/2; i++) {
					for(int j=1; j<=index; j++)
						System.out.print(" ");
					for(int j=0; j<=n/2 - i; j++)
						System.out.print("*");
					System.out.println();
					index++;
				}
				index = 2;
				for(int i=0; i<n/2; i++) {
					for(int j=1; j<=n/2; j++)
						System.out.print(" ");
					for(int j=1; j<=index; j++)
						System.out.print("*");
					System.out.println();
					index++;
				}
			}
		} else System.out.println("INPUT ERROR!");
	}

}
