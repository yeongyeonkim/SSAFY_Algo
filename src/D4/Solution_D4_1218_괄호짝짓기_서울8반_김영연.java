package D4;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D4_1218_괄호짝짓기_서울8반_김영연 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/bracket.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int cnt1 = 0; // ( )
			int cnt2 = 0; // [ ]
			int cnt3 = 0; // { }
			int cnt4 = 0; // < > 왼쪽열이 열리면 + 오른쪽이 열리면 - 음수되면 return
			int n = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			for (int i = 0; i < n; i++) {
				switch (s.charAt(i)) {
				case '(':
					cnt1++;
					break;
				case '[':
					cnt2++;
					break;
				case '{':
					cnt3++;
					break;
				case '<':
					cnt4++;
					break;
				case ')':
					cnt1--;
					break;
				case ']':
					cnt2--;
					break;
				case '}':
					cnt3--;
					break;
				case '>':
					cnt4--;
					break;
				}
			}
			if (cnt1 == 0 && cnt2 == 0 && cnt3 ==0 && cnt4 == 0) {
				System.out.println("#" + t + " 1");
			} else {
				System.out.println("#" + t + " 0");
			}
		}
	}
}
