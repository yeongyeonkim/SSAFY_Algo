package list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PriorityLinkedQueueTest {
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
		int k = rear;
		for (int j = rear - 1; j > front; j--) { //삽입정렬. 우선순위
			if (queue[j] > queue[k]) {
				int T = queue[j]; queue[j] = queue[k]; queue[k] = T;
				k = j;
			}
		}
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
		enQueue(2);
		enQueue(3);
		enQueue(1);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
	}
}
