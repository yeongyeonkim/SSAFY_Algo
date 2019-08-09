package stack2;

import java.util.Scanner;
import java.util.Stack;

public class Hello {
	public static Stack<Character> stack = new Stack<Character>();
	public static Stack<Character> stack2 = new Stack<Character>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = sc.nextLine();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ('0' <= c && c <= '9') { // 숫자
				sb.append(c);
			} else if (c == ')') { // 닫는 괄호
				char tmp;
				while ((tmp = stack.pop()) != '(')
					sb.append(tmp);
			} else { // 연산자.
				while (now(c) <= before())
					sb.append(stack.pop());
				stack.push(c);
			}
		}
		while(!stack.empty()) {
			sb.append(stack.pop());
		}
		String str = sb.toString();
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if('0'<= c && c <= '9') {
				stack2.push(c);
			}
			else {
				int n2 = stack.pop();
				int n1 = stack.pop();
				int nn = 0;
				switch(c) {
				case '+': nn = n1 + n2;
				case '-': nn = n1 - n2;
				case '*':
				case '/':
					
				}
			}
		}
	}

	public static int now(char c) {
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

	public static int before() {
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
