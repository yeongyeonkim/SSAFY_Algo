package stack2;

import java.util.Stack;

public class Postfix2Calc {
	//"(6+5*(2-8)/2)";
	public static String msg = "6528-*2/+";
	public static Stack<Integer> stack2 = new Stack<Integer>();

	public static void main(String[] args) {
		for (int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);
			if ('0' <= c && c <= '9') {
				stack2.push(c - '0');
			} else {
				int n2 = stack2.pop();
				int n1 = stack2.pop();
				int nn = 0;
				switch(c) {
				case '+' : nn = n1+n2; break;
				case '-' : nn = n1-n2; break;
				case '*' : nn = n1*n2; break;
				case '/' : nn = n1/n2; break;
				}
				stack2.push(nn);
			}
		}
		System.out.println(stack2.pop());
	}

}
