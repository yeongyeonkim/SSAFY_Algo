package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2097_지하철_서울8반_김영연 {

	static int n, m, INF = 98754321;
	static int[][] map;
	static int[] dp;
	static int[] p;
	static boolean[] visit;
	
	public static int getSmallindex() {
		int min = INF;
		int index = 0;
		for(int i=1; i<=n; i++) {
			if(dp[i] < min && !visit[i]) {
				min = dp[i];
				index = i;
			}
		}
		return index;
	}
	public static void dijkstra() {
		for(int i=1; i<=n; i++) {
			int index = getSmallindex();
			visit[index] = true;
			for(int j=1; j<=n; j++) {
				if(!visit[j]) 
					if(dp[j] > dp[index] + map[index][j]) { //지금경로가 더 작으면 갱신
						dp[j] = dp[index] + map[index][j];
						p[j] = index;
					}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		dp = new int[n+1];
		p = new int[n+1];
		visit = new boolean[n+1];
		for(int i=1; i<=n; i++) p[i] = 1;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 0) map[i][j] = INF;
				else 		 map[i][j] = num;
			}
		}
		for(int i=1; i<=n; i++) dp[i] = map[1][i];
		visit[1] = true;
		dijkstra();
		Stack<Integer> result = new Stack<>();
		StringBuilder sb = new StringBuilder();
		result.push(m);
		int x = p[m];
		while(x != 1) {
			result.push(x);
			x = p[x];
		}
		result.push(1);
		System.out.println(dp[m]);
		while(!result.isEmpty()) {
			sb.append(result.pop() + " ");
		}
		System.out.println(sb);
	}
}