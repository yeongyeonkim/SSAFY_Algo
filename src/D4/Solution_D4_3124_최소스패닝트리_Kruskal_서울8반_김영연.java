package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리_Kruskal_서울8반_김영연 {
	public static int N;
	public static List<int[]> v;
	public static int[] p;

	public static int findSet(int x) {
		if (p[x] == x) {
			return x;
		}
		return p[x] = findSet(p[x]);
	}

	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if (a < b)
			p[b] = a;
		else
			p[a] = b;
	}

	public static long kruskal() {
		Collections.sort(v, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		p = new int[N + 1];
		for (int i = 0; i < N; i++)
			p[i] = i;

		long sum = 0;
		for (int i = 0; i < v.size(); i++) {
			if (findSet(v.get(i)[0]) != findSet(v.get(i)[1])) {
				sum = sum + v.get(i)[2];
				union(v.get(i)[0], v.get(i)[1]);
			}
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			v = new ArrayList<int[]>();
			p = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				v.add(new int[] {Integer.parseInt(st.nextToken()),
								 Integer.parseInt(st.nextToken()),
								 Integer.parseInt(st.nextToken())});
			}
			System.out.println("#"+ t + " " + kruskal());
		}
	}
}
