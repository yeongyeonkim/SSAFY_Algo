package stack1;

import java.util.Stack;

public class StackTest {
	public static int[] stack = new int[100];
	public static int top = -1;

	public static boolean push(int value) {
//		보이드 반환값일때, overflow 신경쓴다면 아래처럼.
		if (top >= stack.length)
			return false;
		else {
			top++;
			stack[top] = value;
			return true;
		}
		//stack[++top]=value; overflow 신경 안쓴다면 이 한 줄로 해결.
	}
	public static int pop() {
		if(top == -1) return -1;
		return stack[top--];		
	}
	

	public static void main(String args[]) {
		push(1);
		push(2);
		push(3);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		
		Stack<Integer> s = new Stack<>(); 
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.empty());
	}
}
