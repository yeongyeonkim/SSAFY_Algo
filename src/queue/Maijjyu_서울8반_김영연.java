package queue;

public class Maijjyu_서울8반_김영연 {

	public static int[] queue = new int[100];//그저 여유있게 100으로설정.
	public static int front = -1;
	public static int rear = -1;

	public static void enQueue(int item) {
		queue[++rear] = item;
	}
	public static int qPeek() {
		return queue[++front];
	}
	public static void main(String[] args) {
		enQueue(1);
		int count = 20;//20이라고 정의되어있으니.
		int[] number = new int[count];
		int i = 1;
		int tmp = 0;
		while(true) {
			if(count <= 0) break;
			tmp = qPeek();//앞에 선 녀석 번호받기
			count -= ++number[tmp]; //그 친구 갯수를 더해주고 count에서 제거.
			enQueue(tmp);//앞이였던 녀석이 다시 줄을 선다.
			enQueue(++i);		
		}
		System.out.println(tmp);
	}
}
