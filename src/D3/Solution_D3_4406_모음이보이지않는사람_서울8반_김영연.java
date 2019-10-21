package D3;

import java.util.Scanner;

public class Solution_D3_4406_모음이보이지않는사람_서울8반_김영연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			String str = sc.next();
			String tmp = "";
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') continue;
				tmp += c;
			}
			System.out.println("#"+t+" "+tmp);
		}
	}
}