package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnionFindTest {

	public static class Edge implements Comparable<Edge> {
		int a, b, dist;

		Edge(int a, int b, int dist) {
			this.a = a;
			this.b = b;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.dist, o.dist);
		}
		@Override
		public String toString() {
			return "(" + a + "," + b + "," + dist + ")";
		}
	}
	public static int getParent(int[] p, int x) {
		if(p[x] == x) return x; //부모
		return p[x] = getParent(p, p[x]); //갱신을 위한 p[x] =
	}
	
	public static void unionParent(int[] p, int a, int b) {
		a=getParent(p, a);
		b=getParent(p, b);
		if(a<b) p[b] = a;//인덱스가 앞에있는것을 그냥 부모로하자
		else	p[a] = b;
	}
	public static boolean findParent(int[] p, int a, int b) {
		a=getParent(p, a);
		b=getParent(p, b);
		if(a==b) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		int n = 7;
		int m = 11;
		List<Edge> v = new ArrayList<Edge>();
		v.add(new Edge(1, 7, 12));
		v.add(new Edge(1, 4, 28));
		v.add(new Edge(1, 2, 67));
		v.add(new Edge(1, 5, 17));
		v.add(new Edge(2, 4, 24));
		v.add(new Edge(2, 5, 62));
		v.add(new Edge(3, 5, 20));
		v.add(new Edge(3, 6, 37));
		v.add(new Edge(4, 7, 13));
		v.add(new Edge(5, 6, 45));
		v.add(new Edge(5, 7, 73));

		Collections.sort(v);
		
		int[] p = new int[n];
		for(int i=0; i<n; i++) p[i] = i; //make set
		
		int sum = 0;
		for(int i=0; i<v.size(); i++) {
			if(findParent(p, v.get(i).a - 1, v.get(i).b - 1)) {
				sum += v.get(i).dist;
				unionParent(p, v.get(i).a - 1, v.get(i).b - 1);
			}
		}
		System.out.println(sum);
	}
}