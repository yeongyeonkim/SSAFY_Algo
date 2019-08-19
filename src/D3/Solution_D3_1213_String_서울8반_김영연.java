package D3;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_1213_String_서울8반_김영연 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int flag = 0;
			int cnt = 0;
			int testcase = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			String str = sc.nextLine();
			for(int i=0; i<=str.length() - s.length(); i++) {
				flag = 0;
				for(int j=i; j<=i+s.length()-1; j++) {
					if(s.charAt(j-i) != str.charAt(j))
						flag = 1;
				}
				if(flag != 1)
					cnt++;
			}
			System.out.println("#"+testcase+" "+cnt);
		}
	}
}