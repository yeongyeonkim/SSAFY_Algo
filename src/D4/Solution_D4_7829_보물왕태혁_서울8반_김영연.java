package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_D4_7829_보물왕태혁_서울8반_김영연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			ArrayList<Integer> arr = new ArrayList<>();
			int result = 0;
			int m = Integer.parseInt(br.readLine()); // 약수 개수
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < m; i++)
				arr.add(Integer.parseInt(str[i]));
			Collections.sort(arr);
			result = arr.get(0) * arr.get(arr.size() - 1);
			System.out.println("#" + t + " " + result);
		}
	}
}
