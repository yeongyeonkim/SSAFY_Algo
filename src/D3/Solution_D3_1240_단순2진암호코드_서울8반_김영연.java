package D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1240_단순2진암호코드_서울8반_김영연 {

	static String[] info = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
			"0110111", "0001011" };
	static StringBuilder sb;
	static int m, cnt, result, flag;

	public static void cal() {
		int sum = 0;
		for (int i = 0; i < 8; i++) { // 계산
			if (i % 2 == 0)// 짝수번째 인덱스 사실 홀수째이므로 x3
				sum += (sb.charAt(i) - '0') * 3;
			else
				sum += (sb.charAt(i) - '0');
		}
		if (sum % 10 == 0) { // 계산끝. 10으로 나누어지면 각 숫자들 합 출력
			flag = 1;
			for (int i = 0; i < 8; i++) {
				result += (sb.charAt(i) - '0');
			}
		}
	}

	public static void search(String s, int start) {
		while (start <= m - 7) {
			int tmp_cnt = cnt;
			for (int j = 0; j < 10; j++) { // 암호코드 비교
				if (info[j].equals(s.substring(start, start + 7))) {
					sb.append(j);
					cnt++;
					if (cnt == 8)
						cal();
				}
			}
			if (tmp_cnt == cnt) { // 위를 탐색했지만 cnt값이 그대로면. 같은게없으니 버림.
				sb.delete(0, sb.length());
				cnt = 0;
				return;
			}
			start = start + 7;
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/simplebinary.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			String[] info = br.readLine().split(" ");
			int n = Integer.parseInt(info[0]);
			m = Integer.parseInt(info[1]);
			result = 0;
			cnt = 0;
			flag = 0;
			sb = new StringBuilder();
			for (int k = 0; k < n; k++) { // 세로 횟수 만큼
				String s = br.readLine();
				if (flag == 1)
					continue;
				for (int i = 0; i <= m - 7; i++) { // 가로 탐색 가능 범위
					search(s, i);
					if (flag == 1)
						break;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
