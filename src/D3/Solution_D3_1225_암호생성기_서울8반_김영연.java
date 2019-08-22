package D3;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_1225_암호생성기_서울8반_김영연 {

	static int front;
	static int queue[];

	static void dequeue(int n) {
		front = (front + 1) % 8;
		queue[front] -= n;
	}

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("passwordmaker.txt"));
		Scanner sc = new Scanner(System.in);
	// 5번이 1사이클. 12345씩 감소
		for (int t = 1; t <= 10; t++) {
			int testcase = sc.nextInt();
			sc.nextLine();
			front = -1;
			queue = new int[8];
			for (int i = 0; i < 8; i++) {
				queue[i] = sc.nextInt();
			}
			int index = 0;
			while (true) {
				dequeue(index%5 + 1);
				index++;
				if(queue[front] <= 0) {
					queue[front] = 0; 
					break;
				}
			}
			System.out.print("#"+testcase);
			for(int i=1; i<=8; i++) {
				System.out.print(" "+queue[(front+i)% 8]);
			}
			System.out.println();
		}
	}
}