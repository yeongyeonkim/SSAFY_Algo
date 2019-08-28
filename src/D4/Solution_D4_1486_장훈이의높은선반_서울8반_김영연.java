package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_1486_장훈이의높은선반_서울8반_김영연 {
	static int[] result;
	static int[] height;
	static int count, min, top;

	public static void comb(int index, int start) {
		if (index == count) {
			int sum = 0;
			for (int i = 0; i < count; i++)
				sum += result[i];
			if (sum >= top && sum - top < min)
				min = sum - top;
			return;
		}
		for (int i = start; i < height.length; i++) {
			result[index] = height[i];
			comb(index + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			top = Integer.parseInt(input[1]);
			min = 10000;
			height = new int[n];
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < str.length; i++)
				height[i] = Integer.parseInt(str[i]);
			for (count = 1; count <= n; count++) {
				result = new int[count];
				comb(0, 0);
			}
			System.out.println("#" + t + " " + min);
		}
	}
}
