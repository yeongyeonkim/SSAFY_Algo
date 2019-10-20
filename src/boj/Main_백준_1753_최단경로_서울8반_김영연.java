package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_1753_최단경로_서울8반_김영연 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine()) - 1;
		ArrayList<int[]>[] arr = new ArrayList[n];
		for(int i=0; i<n; i++)
			arr[i] = new ArrayList<int[]>();
		int[] d = new int[n];
		Arrays.fill(d, Integer.MAX_VALUE / 2);
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			arr[a].add(new int[] { b, Integer.parseInt(st.nextToken()) });
		}
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		d[start] = 0;
		q.add(new int[] {start, 0}); //출발점과 가중치
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int[] a : arr[tmp[0]]) {
				if(d[a[0]] > tmp[1] + a[1]) {
					d[a[0]] = tmp[1] + a[1];
					q.add(new int[] { a[0], d[a[0]]});
				}
			}
		}
		for(int i=0; i<d.length; i++) {
			if(d[i] == Integer.MAX_VALUE/2) System.out.println("INF");
			else System.out.println(d[i]);
		}
	}
}