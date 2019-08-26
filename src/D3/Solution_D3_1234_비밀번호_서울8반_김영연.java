package D3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_1234_비밀번호_서울8반_김영연 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack();

		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			int[] list = new int[n];
			int cnt = 0;
			String s = sc.next();
			for (int i = 0; i < n; i++) {
				if (stack.isEmpty()) {
					stack.push(s.charAt(i));
					cnt++;
					continue;
				}
				char c = s.charAt(i);
				if (stack.peek() == c) {
					stack.pop();
					cnt--;
				} else {
					stack.push(c);
					cnt++;
				}
			}
			char[] c = new char[cnt];
			for (int i = 0; i < cnt; i++)
				c[i] = stack.pop();
			System.out.print("#" + t + " ");
			for (int i = cnt - 1; i >= 0; i--)
				System.out.print(c[i]);
			System.out.println();
		}
	}
}
