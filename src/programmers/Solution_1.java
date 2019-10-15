package programmers;

import java.util.ArrayList;

public class Solution_1 {

	public int[] solution(int n, String[] words) {
		ArrayList<String> arr = new ArrayList<>();
		char end = words[0].charAt(words[0].length()-1);
		arr.add(words[0]);
		int[] answer = new int[2];
		int index = 0;
		for(int i=1; i<words.length; i++) {
			String str = words[i];
			if(arr.contains(str)) {
				index = i;
				break;
			} else {
				arr.add(str);
			}
			if(end == str.charAt(0)) 
				end = str.charAt(str.length()-1);
			else {
				index = i;
				break;
			}
		}
		if(index ==0) {
			answer[0] = 0; answer[1] = 0;
		}
		else {
			index++;
			answer[0] = (index % n == 0) ? n : index % n;
			answer[1] = (index % n == 0) ? index / n : (index / n) + 1;
		}
		return answer;
	}
}