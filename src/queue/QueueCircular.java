package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCircular {
	public static int N = 3;
	public static int[] queue = new int[N];
	public static int front = 0;
	public static int rear = 0;

	public static boolean isEmpty() {
		if (front == rear) return true;
		else return false;
	}

	public static boolean isFull() {
		if ((rear + 1) == front) return true;
		else return false;
	}

	public static void enQueue(int item) {
		if (isFull()) {
			System.out.println("Queue Full");
			return;
		}
		queue[(++rear)%N] = item;
	}

	public static int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[(++front)%N];
	}

	public static int qPeek() {
		if (isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[front + 1];
	}

	public static void main(String[] args) {
		enQueue(1);
		enQueue(2);
		enQueue(3);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		enQueue(4);
		System.out.println(deQueue());
		enQueue(5);
		System.out.println(deQueue());
	}
}
