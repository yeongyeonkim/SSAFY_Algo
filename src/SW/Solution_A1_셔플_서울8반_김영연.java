package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_A1_셔플_서울8반_김영연 {

	static ArrayList<Integer> result, result_up, result_down;
	static int n, cnt;
	public static void shuffle(ArrayList<Integer> arr, int count) {
		if(arr.equals(result_up) || arr.equals(result_down)) {
			if(cnt == -1)
				cnt = count;
			else if(cnt > count)
				cnt = count;
			return;
		}
		if (count == 5) return;
		for (int i = 1; i < n / 2; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			int x = i;
			int left_index = 0;
			int right_index = n/2;
			while(left_index != n/2-i) {
				tmp.add(arr.get(left_index++));
			}//벗어나면 이제 반복.
			while(x != 0) {
				x--;
				tmp.add(arr.get(right_index++));
				tmp.add(arr.get(left_index++));
			}
			while(right_index != n) {
				tmp.add(arr.get(right_index++));
			}
			shuffle(tmp, count+1);
		}
		for (int i = n / 2; i < n; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			int x = n - i -1; //횟수
			int left_index = 0;
			int right_index = n/2;
			while(right_index != i + 1) {
				tmp.add(arr.get(right_index++));
			}
			while(x != 0) {
				x--;
				tmp.add(arr.get(left_index++));
				tmp.add(arr.get(right_index++));
			}
			while(left_index != n/2) {
				tmp.add(arr.get(left_index++));
			}
			shuffle(tmp, count+1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			result = new ArrayList<>();
			ArrayList<Integer> result_tmp = new ArrayList<>();
			result_up = new ArrayList<>();
			result_down = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				result.add(Integer.parseInt(st.nextToken()));				
			}
			for(int i=0; i<result.size(); i++)
				result_tmp.add(result.get(i));
			Collections.sort(result);
			for(int i=0; i<n; i++) {
				result_up.add(result.get(i));
				result_down.add(result.get(n-i-1));
			}
			cnt = -1;
			shuffle(result_tmp, 0);

			System.out.println(cnt);
		}
	}
}