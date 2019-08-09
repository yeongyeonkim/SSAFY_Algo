package stack2;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static Stack<Character> stack = new Stack<Character>();
	public static Stack<Integer> stack2 = new Stack<Integer>();

	public static void main(String args[]){		
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			String msg = sc.next();
			String msg2;
			for (int i = 0; i < msg.length(); i++) {
				char c = msg.charAt(i);
				if ('0' <= c && c <= '9') {
					sb.append(c);
				} else if (c == ')') {
					char s;
					while ((s = stack.pop()) != '(')
						sb.append(s);
				} else {
					while (getIcp(c) <= getIsp())
						sb.append(stack.pop());
					stack.push(c);
				}
			}
			while (!stack.empty()) {
				char s = stack.pop();
				sb.append(s);
			}
			msg2 = sb.toString();
			
			for (int i = 0; i < msg2.length(); i++) {
				char c = msg2.charAt(i);
				if ('0' <= c && c <= '9') {
					stack2.push(c - '0');
				} else {
					int n2 = stack2.pop();
					int n1 = stack2.pop();
					int nn = 0;
					switch (c) {
					case '+':
						nn = n1 + n2;
						break;
					case '-':
						nn = n1 - n2;
						break;
					case '*':
						nn = n1 * n2;
						break;
					case '/':
						nn = n1 / n2;
						break;
					}
					stack2.push(nn);
				}
			}
			System.out.println("#"+t+" "+stack2.pop());
		}
	}

	public static int getIcp(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 3;
		default:
			return 0;
		}
	}

	public static int getIsp() {
		char c = (stack.empty()) ? '(' : stack.peek();
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 0;
		default:
			return 0;
		}
	}
}
