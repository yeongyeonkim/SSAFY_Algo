package programmers;

public class Programmers_lv2_2 {

	static int answer;
	public static void find(int index, int sum, int[] numbers, int target) {
		if(index == numbers.length) {
			if(sum == target) answer++;
			return;
		}
		find(index + 1, sum - numbers[index], numbers, target);
		find(index + 1, sum + numbers[index], numbers, target);
	}
	public int solution(int[] numbers, int target) {
		answer = 0;
		find(0, 0, numbers, target);
		return answer;
	}
}