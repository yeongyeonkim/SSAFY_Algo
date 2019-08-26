package D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물수확하기_서울8반_김영연 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/crops.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = n / 2 - cnt; j <= n / 2 + cnt; j++)
					sum += s.charAt(j) - '0';
				if(i < n/2) cnt++;
				else cnt--;
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
