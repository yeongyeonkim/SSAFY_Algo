package D2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D2_1970_쉬운거스름돈_서울8반_김영연 {
	static int[] number;
	static int[] arr = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void cal(int m) {
		for(int i=0; i<8; i++) {
			number[i] = m / arr[i];
			m -= number[i] * arr[i];
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/easychange.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		number = new int[8];
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			int money = Integer.parseInt(br.readLine());
			cal(money);
			System.out.println("#" + t);
			for (int i = 0; i < 8; i++)
				System.out.print(number[i] + " ");
			System.out.println();
		}
	}
}