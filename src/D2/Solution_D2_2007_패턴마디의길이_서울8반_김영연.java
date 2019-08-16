package D2;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D2_2007_패턴마디의길이_서울8반_김영연 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/pattern.txt"));
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		sc.nextLine();
		for(int t=1; t<=testcase; t++) {
			int sum = 0;
			String s = sc.nextLine();
			for(int i=1; i<s.length()/2; i++) {
				String s1 = s.substring(0,i+1);
				String s2 = s.substring(i+1, 2*(i + 1));
				if(s1.equals(s2)) {
					sum = (i+1/s.length())+1;
					break;
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}