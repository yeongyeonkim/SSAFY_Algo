package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_1077_배낭채우기1_서울8반_김영연 {

	static class jewel {
		int w;
		int p;
		public jewel(int w, int p) {
			this.w = w;
			this.p = p;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		ArrayList<jewel> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.add(new jewel(a, b));
		}
		Collections.sort(arr, new Comparator<jewel>() {
			public int compare(jewel o1, jewel o2) {
				if(o1.p / o1.w > o2.p / o2.w)
					return -1;
				else if(o1.p / o1.w < o2.p / o2.w)
					return 1;
				else
					return 0;
			}
		});
		int index = 0;
		int max = 0;
		while(index < N) {
			jewel tmp = arr.get(index);
			max += (W / tmp.w) * tmp.p; //몫만큼 가치를 더해주고
			W = W % tmp.w; //나머지만큼 값을 변경
			index++;
		}
		System.out.println(max);
	}
}