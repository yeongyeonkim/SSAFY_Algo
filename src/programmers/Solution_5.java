package programmers;

/*
1001110 (78을 2진법)의 다음 큰 숫자는
1010111 (83을 2진법)이다. 
1의 갯수가 같은 것을 유지하면서 다음으로 큰 숫자를 구하여라.
 */
public class Solution_5 {
	
	static StringBuilder sb;
	static int cnt;
	
	public static void two(int n) {
		int index = 1;
		while(true) {
			if(n < Math.pow(2, index)) {
				index--;
				break;
			}
			else if(n == Math.pow(2, index)) 
				break;
			else index++;
		}
		sb = new StringBuilder();
		for(int i=index; i>=0; i--) {
			double tmp = Math.pow(2, i);
			if(n >= tmp) {
				sb.append("1");
				n -= tmp;
			} else sb.append("0");
		}
	}
	public static boolean count(String str) {
		int count = 0;
		for(int i=0; i<str.length(); i++)
			if(str.charAt(i) == '1') count++;
		if(count == cnt) return true;
		else 			 return false;
	}
	public static void main(String[] args) {
		int n = 78;
		two(n);
		System.out.println(sb);
		String str = sb.toString();
		cnt = 0;
		for(int i=0; i<str.length();i++) 
			if(str.charAt(i) == '1') cnt++;
		while(true) {
			n++;
			two(n); //문자열 만들고
			if(count(sb.toString())) break;
		}
		System.out.println(sb);
		System.out.println(n);
	}
}