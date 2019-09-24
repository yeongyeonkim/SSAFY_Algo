package array1;

import java.util.Scanner;

public class QueueBasic {

	static int front;
	static int rear;
	static int queue[];
	
	static void init(int n) {
		front = -1;
		rear = -1;
		queue = new int[n];
	}
	
//	static boolean isEmpty() {
//		//front , rear 포인터가 같은 경우 데이터가 없는 상태이므로 포인터를 모두 -1로 초기화
//		if(front == rear) {
//			front = -1;
//			rear = -1;
//		}
//		//같은 경우 데이터가 없는 상태이므로 true, 아닌 경우 false 리턴
//		return (front == rear)
//	}
	
//	static boolean isFull() {
//		//rear 포인터가 큐의 마지막 인덱스와 동일한 경우 true, 아닌경우 false 리턴
//		return (rear == queueSize - 1);
//	}
	
	//큐에 데이터 삽입
	static void enqueue(int n) { 
//		if(isFull(){
//			System.out.println("Queue is full!");
//		else {
			queue[++rear] = n; //다음 rear 포인터가 가리키는 위치에 데이터 추가
//			System.out.println("Inserted Item: " + n);
//		}
	}
	//큐에서 데이터 추출 후 삭제
//	static int dequeue() {
//		if(isEmpty()) {
//			System.out.println("~~");
//			return 0;
//		}
//		else {
//			front = (front + 1) % queueSize;
//			
//			return queue[front];
//		}
//	}
	//큐의 첫번째 데이터 추출.
//	static int peek() {
//		if(isEmpty()) {
//			return 0;
//		}
//		else {//front 포인터는 삭제한 위치에 있으므로 +1을 해줘서 첫번째 요소를 추출하도록 지정.
//			return queue[front+1];
//		}
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			init(8); //8개로 정해진 케이스.
		}
	}

}
