package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static int[] queue = new int[100];
	public static int front = -1;
	public static int rear = -1;

	public static boolean isEmpty() {
		if (front == rear)
			return true;
		else
			return false;
	}

	public static boolean isFull() {
		if (rear == queue.length - 1)
			return true;
		else
			return false;
	}

	public static void enQueue(int item) {
		if (isFull()) {
			System.out.println("Queue Full");
			return;
		}
		queue[++rear] = item;
	}

	public static int deQueue() {
		if (isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[++front];
	}

	public static int qPeek() {
		if (isEmpty()) {
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[front + 1];
	}

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		q.offer("홍길동");
		q.offer("손오공");
		System.out.println(q);
		System.out.println(q.size());
		System.out.println(q.peek());
		System.out.println(q.size());
		q.offer("사오정");
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.size());
		System.out.println(q);
	}
}
