package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_6719_성수의프로그래밍강좌시청_서울8반_김영연2 {
	static int n, k;
	static int[] m;
	static boolean[] visit;
	static double result;

	public static void perm(int[] arr, int count) {
		if (count == k) {
			double tmp = 0.0;
			for (int i = 0; i < k; i++) // 그간 담은 arr의 요소들을 담는다.
				tmp = (tmp + arr[i]) / 2;
			if (result < tmp)
				result = tmp;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[count] = m[i];
				perm(arr, count+1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 총 n개의 수
			k = Integer.parseInt(st.nextToken()); // k개만 고른다
			m = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				m[i] = Integer.parseInt(st.nextToken());
			result = Double.MIN_VALUE;
			int[] arr = new int[k];
			visit = new boolean[n];
			perm(arr, 0);
			System.out.printf("#%d %f\n", t, result);
		}
	}
}
