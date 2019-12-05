package programmers;

public class Programmers_lv2_1 {

	public int[] solution(int[] prices) {
		int n = prices.length;
		int[] answer = new int[n];
		int index = 0;
		while(index != n) {
			int cnt = 0;
			for(int i=index+1; i<n; i++) {
				cnt++;
				if(prices[index] > prices[i]) break;
			}
			answer[index] = cnt;
			index++;
		}
		return answer;
	}
}