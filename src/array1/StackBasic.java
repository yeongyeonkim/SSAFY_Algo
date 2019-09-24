//package array1;
//
//public class StackBasic {
//	int s[100];
//	int top; //보통 스택에서 사용하는 변수 top은 전역변수로 선언한다
//	void init() { //init은 초기화로, stack은 top이라는 변수에 따라 좌지우지 되기에 top을 반드시 초기화해준다.
//		top = -1; //top을 초기화할 때 기호에따라 =0으로 하든, -1로 하든 한다.
//		//-1로하면 push를 할 때에 s[++top]=num 식으로 들어가고 pop은 s[top--]=0;
//		//0으로 하면 push를 할 때에 s[top++]=num으로 하고, pop은 s[--top]=0으로 함.
//	}
//	void push(int x) {
//		s[++top] = x; //top을 증가시키면서 데이터를 넣어준다.
//	}
//	void pop() {
//		s[top--]=0; //현재 있는 곳을 0으로 초기화해주고, top을 하나 줄여줌
//	}
//	int peek() {
//		return s[top]; //스택의 가장 위쪽을 반환
//	}
//	bool isfull() { //스택이 꽉차있는지 검사
//		if (top >= MAX - 1) return true; 
//		else return false;
//	}
//	bool isempty() { //스택이 비어있는지 검사
//		if (top < 0) return true;
//		else return false;
//	}
//	int main()
//	{
//		init();
//		push(3);
//		push(4);
//		push(5);
//	​
//		printf("%d\n", peek());
//		pop();
//		printf("%d\n", peek());
//		pop();
//		printf("%d\n", peek());
//		pop();
//		printf("%d\n", isempty());
//	​
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
