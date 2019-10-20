package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_1753_최단경로_서울8반_김영연2 {

	static int n, INF = Integer.MAX_VALUE / 2;
	static int[] d;
	static boolean[] visit;
	static ArrayList<int[]>[] arr;
	
	public static int getSmallindex() {
		int index = 0;
		int min = INF;
		for(int i=0; i<n; i++) {
			if(d[i] < min && !visit[i]) {
				min = d[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void Dijstra(int x) {
		visit[x] = true;
		for(int i=0; i<arr[x].size(); i++) 
			d[arr[x].get(i)[0]] = arr[x].get(i)[1];
		for(int i=0; i<n-2; i++) { // n-1번만
			int curr = getSmallindex();
			visit[curr] = true;
			for(int j=0; j<n; j++) {
				if(!visit[j]) {
					int index = -1;
					for(int k=0; k<arr[curr].size(); k++) {
						if(arr[curr].get(k)[0] == j) { 
							index = k;
							break;
						}
					}
					if(index != -1)
						d[j] = Math.min(d[curr] + arr[curr].get(index)[1], d[j]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n];
		for(int i=0; i<n; i++)
			arr[i] = new ArrayList<>();
		visit = new boolean[n];
		int start = Integer.parseInt(br.readLine()) - 1;
		d = new int[n];
		for(int i=0; i<n; i++) {
			if(i==start) continue;
			d[i] = INF;
		}
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[Integer.parseInt(st.nextToken()) - 1].add(new int[] {
					Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())} );
		}
		Dijstra(start);
		for(int a : d) {
			if(a >= INF) System.out.println("INF");
			else 		System.out.println(a);
		}
	}
}