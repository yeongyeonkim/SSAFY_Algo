package list;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedQueueTest {
	public static Node front = null;
	public static Node rear = null;

	public static boolean isEmpty() {
		if (front == null)
			return true;
		else
			return false;
	}

	public static void enQueue(int item) {
		Node n = new Node();
		n.data = item;
		//n.link = null;
		if (front == null) { //비어있다는 소리.
			rear = n; 
			front = n;
		} else { //비어있지 않은 상태라면.
			rear.link = n;
			rear = n;
		}
	}

	public static int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		int item = front.data;
		front=front.link; // front가 제거되는.
		if(isEmpty()) rear = null; // front가 null이면 rear도 null이여야 하니, 까먹지말자.
		return item;
	}

	public static int qPeek() {
		if (isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		int item = front.data;
		return item;
	}

	public static void main(String[] args) {
		enQueue(1);
		enQueue(2);
		enQueue(3);
		System.out.println(qPeek());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
	}
}
