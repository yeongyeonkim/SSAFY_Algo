package array2;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_2817_부분수열의합_서울8반_김영연 {

	public static int[] data;
	public static int N, hap, cnt;

	public static void solve(int sum, int pos) {
		if (sum > hap) return;
		if (sum == hap) {
			cnt++;
			return;
		}
		if (pos > N - 1) return;
		solve(sum,          pos+1);
		solve(sum+data[pos],pos+1);
		//pos번째 인덱스의 데이터를 더한것, 안더한것을 반복해서 테스트해줌
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			data = new int[N];
			hap = sc.nextInt();
			for (int i = 0; i < N; i++)
				data[i] = sc.nextInt();
			cnt = 0;
			solve(0, 0);
			System.out.println("#" + tc + " " + cnt);
		}
	}
}