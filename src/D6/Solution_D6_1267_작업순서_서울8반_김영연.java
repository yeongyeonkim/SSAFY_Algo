package D6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D6_1267_작업순서_서울8반_김영연 {

	static int n;
	static int[] visit;
	static boolean[][] map;

	public static void DFS(int x) {
		for(int i=1; i<=n; i++) {
			if(map[x][i] == true) {
				if(visit[x] >= visit[i]) {
					visit[i] = visit[x] + 1;
					DFS(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			map = new boolean[n+1][n+1];
			visit = new int[n+1];
			for(int i=0; i<m; i++) 
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			Queue<Integer> q = new LinkedList<>();
			for(int j=1; j<=n; j++) {
				boolean flag = false;
				for(int i=1; i<=n; i++) 
					if(map[i][j] == true) flag = true;
				if(!flag) {
					visit[j] = 1;
					q.add(j);
				}
			}			
			while(!q.isEmpty()) {
				DFS(q.poll());
			}
			ArrayList<int[]> result = new ArrayList<>();
			for(int i=1; i<=n; i++) 
				result.add(new int[] { i, visit[i] });
			Collections.sort(result, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if(o1[1] > o2[1]) return 1;
					else if(o1[1] < o2[1]) return -1;
					else return 0;
				}
			});
			System.out.print("#"+t);
			for(int i=0; i<n; i++) 
				System.out.print(" "+result.get(i)[0]);
			System.out.println();
		}
	}
}