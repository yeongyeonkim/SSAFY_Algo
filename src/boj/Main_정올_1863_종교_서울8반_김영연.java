package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_정올_1863_종교_서울8반_김영연 {

	static int[] p;

	public static int find(int x) {
		if (p[x] == x) return x;
		return p[x] = find(p[x]);
	}
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a>b) p[a] = b;
		else p[b] = a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p = new int[n + 1];
		for (int i = 1; i <= n; i++) p[i] = i;
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			if(find(parent) != find(child))
				union(parent, child);
		}
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if(!a.contains(find(p[i])))
				a.add(find(p[i]));
		}
		System.out.println(a.size());
	}

}
