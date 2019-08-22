package D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1228_암호문1_서울8반_김영연 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/password1.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt(); // 원본 암호문의 길이
			int[] pass = new int[n];
			for (int i = 0; i < n; i++)
				pass[i] = sc.nextInt(); // 원본암호문
			int k = sc.nextInt();
			sc.nextLine();
			String s = new String();
			for (int i = 0; i < k; i++) {
				s = sc.next();
				if (s.equals("I")) {
					int index = sc.nextInt(); // 삽입할 위치인덱스
					int length = sc.nextInt(); // 삽입할 개수
					for (int h = n-1; h >= index; h--) {
						if (h - length < 0)
							break;
						pass[h] = pass[h - length];
					}
					for (int j = index; j < index + length; j++) {
						if (j >= n) // 원본암호문 길이를 벗어나면 안됨.
							sc.nextInt();
						else
							pass[j] = sc.nextInt();
					}
				}
			}
			System.out.print("#" + t);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + pass[i]);
			}
			System.out.println();
		}
	}
}
