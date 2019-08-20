package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합_서울8반_김영연 {
	public static int getParent(int[] p, int x) {
		if (p[x] == x)
			return x;
		return p[x] = getParent(p, p[x]);
	}

	public static void unionParent(int[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		if (a < b)
			p[b] = a;
		else
			p[a] = b;
	}

	public static boolean findParent(int[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		if (a == b)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] p = new int[n + 1];
			for (int i = 1; i <= n; i++)
				p[i] = i;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if (k == 0) {
					unionParent(p, x, y);
				} else {
					if (findParent(p, x, y))
						sb.append(1);
					else
						sb.append(0);
				}
			}
			System.out.println("#" + t + " " + sb);
		}
	}
}