package list;

import java.util.Stack;

public class LinkedStackTest {
	public static Node top = null;

	public static void push(int value) {
		Node n = new Node();
		n.data = value;
		n.link = top;
		top = n;
	}

	public static int pop() {
		if (top == null) return -1;
		int value = top.data;
		top = top.link;
		return value;
	}

	public static int peek() {
		if (top == null) return -1;
		int value = top.data;
		return value;
	}

	public static void main(String args[]) {
		push(1);
		push(2);
		push(3);
		System.out.println(peek());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
	}
}
