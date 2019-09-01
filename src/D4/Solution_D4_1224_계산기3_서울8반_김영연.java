package D4;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D4_1224_계산기3_서울8반_김영연 {
	
	static int len, n_top, c_top;
	static int[] stack_n;
	static char[] stack_c;
	
	static char peek_c() {
		return stack_c[c_top];
	}
	static void push_n(int n) {
		stack_n[++n_top] = n;
	}
	static void push_c(char c) {
		stack_c[++c_top] = c;
	}
	static int pop_n() {
		return stack_n[n_top--];
	}
	static void pop_c() {
		stack_c[c_top--] = 0;
	}
	static void init() {
		n_top = -1;
		c_top = -1;
		stack_n = new int[len];
		stack_c = new char[len];		
	}
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/calculator3.txt"));		
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			len = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			char[] c = new char[len];
			for(int i=0; i<len; i++)
				c[i] = str.charAt(i);
			
			init();
			
			for(int i=0; i<len; i++) {
				if(c[i] == '(') {
					push_c(c[i]);
				}
				else if(c[i] == '*') {
					push_c(c[i]);
				}
				else if(c[i] == '+') {
					if(peek_c() != '*')
						push_c(c[i]);
					else {
						while(peek_c() == '*') {
							pop_c();
							push_n(pop_n()*pop_n());
						}
						push_c(c[i]);
					}
				}
				else if(c[i] == ')') {
					while(peek_c() != '(') {
						if(peek_c() == '+') 
							push_n(pop_n()+pop_n());
						else
							push_n(pop_n() * pop_n());
						pop_c();
					}
					pop_c();
				}
				else { //숫자
					push_n(c[i]-'0');
				}
			}
			System.out.println("#"+t+" "+pop_n());
		}
	}
}
