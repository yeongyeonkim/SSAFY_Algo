package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울_서울8반_김영연 {
	static int cnt;

	public static void find(int[] a, int left, int right, int count, boolean[] visit) {
		if (count == visit.length) {
			cnt++;
			return;
		}
		for (int i = 0; i < visit.length; i++) { // 오른쪽에 넣을 값을 찾았다면
			if(!visit[i]) {
				visit[i] = true;
				if(left >= right + a[i]) find(a, left, right + a[i], count + 1, visit);
				find(a, left + a[i], right, count + 1, visit);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			boolean[] visit = new boolean[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				a[i] = Integer.parseInt(st.nextToken());
			cnt = 0;
			for (int i = 0; i < n; i++) {
				visit[i] = true;
				find(a, a[i], 0, 1, visit);
				visit[i] = false;
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}