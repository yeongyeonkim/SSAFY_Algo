package D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_Kruskal_서울8반_김영연 {
	static List<long[]> v;
	static double e;
	static int N;
	static int[] p;

	public static int findSet(long x) {
		int xx = (int)x;
		if (p[xx] == xx)
			return xx;
		else
			return findSet(p[xx]);
	}

	public static void union(long a, long b) {
		int aa = findSet(a);
		int bb = findSet(b);
		if (a < b)
			p[bb] = aa;
		else
			p[aa] = bb;
	}

	public static double kruskal() {
		Collections.sort(v, new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[2], o2[2]);
			}
		});
		p = new int[N];
		for (int i = 0; i < N; i++)
			p[i] = i;
		double sum = 0;
		for (int i = 0; i < v.size(); i++) {
			if (findSet(v.get(i)[0]) != findSet(v.get(i)[1])) {
				union(v.get(i)[0], v.get(i)[1]);
				sum = sum + v.get(i)[2];
			}
		}
		return sum;
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/D4_1251.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; t++) {
            N = Integer.parseInt(br.readLine());
            v = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] x = new int[N];
            int[] y = new int[N];
            for (int i = 0; i < N; i++)
                x[i] = Integer.parseInt(st.nextToken()); // x좌표입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                y[i] = Integer.parseInt(st.nextToken());
            e = Double.parseDouble(br.readLine());
            for(int i=0; i<N-1; i++) {
                for(int j=i+1; j<N; j++) {
                    long sum = (long)((Math.pow(x[j] - x[i], 2) + Math.pow(y[j] - y[i], 2)));
                    v.add(new long[] { i, j, sum } );
                }
            }
            
            System.out.println("#" + t + " " +  Math.round(e * kruskal()));
        }
    }
}