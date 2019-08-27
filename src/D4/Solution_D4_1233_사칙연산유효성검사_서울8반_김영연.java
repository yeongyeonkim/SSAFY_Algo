package D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_1233_사칙연산유효성검사_서울8반_김영연 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/Arithmetic_validation.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			String[][] list = new String[n + 1][4];
			int result = 1;
			for (int i = 1; i <= n; i++) {
				String[] info = br.readLine().split(" ");
				int cnt = 0;
				for (String wo : info)
					list[i][cnt++] = wo;
				if (!list[i][1].equals("*") && !list[i][1].equals("/") && 
						!list[i][1].equals("+") && !list[i][1].equals("-")) {
					if (list[i][2] != null) result = 0;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
