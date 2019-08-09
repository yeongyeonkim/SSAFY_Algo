package queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuePriority {

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		q.offer("홍길동");
		q.offer("손오공");
		q.offer("사오정");
		System.out.println(q);
		for (int i = 0; i < 3; i++)
			System.out.print(q.poll() + " ");
		System.out.println();
		
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.offer("홍길동");
		pq.offer("손오공");
		pq.offer("사오정");
		System.out.println(pq);
		for(int i=0; i<3; i++)
			System.out.print(pq.poll() + " ");
	}
}
