package D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1221_GNS_서울8반_김영연 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/GNS_test_input.txt"));
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		String[][] number_s = {{"ZRO"}, {"ONE"}, {"TWO"}, {"THR"}, {"FOR"}, 
							   {"FIV"}, {"SIX"}, {"SVN"}, {"EGT"}, {"NIN"}};
		for (int t = 1; t <= testcase; t++) {
			int[] number = new int[10];
			String s = sc.next();
			int n = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				switch (str) {
				case "ZRO": number[0]++; break;
				case "ONE":	number[1]++; break;
				case "TWO":	number[2]++; break;
				case "THR":	number[3]++; break;
				case "FOR":	number[4]++; break;
				case "FIV":	number[5]++; break;
				case "SIX":	number[6]++; break;
				case "SVN":	number[7]++; break;
				case "EGT":	number[8]++; break;
				case "NIN":	number[9]++; break;
				}
			}
			System.out.println("#"+t);
			for(int i=0; i<=9; i++) {
				for(int j=0; j<number[i]; j++) {
					System.out.print(number_s[i][0]+" ");
				}
			}
		}
	}
}