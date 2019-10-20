package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1504_특정한최단경로_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int[][] Node = new int[n+1][n+1];
		int INF = Integer.MAX_VALUE/2;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				Node[i][j] = INF;
				Node[j][i] = Node[i][j];
			}
		}
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Node[x][y] = Integer.parseInt(st.nextToken());
			Node[y][x] = Node[x][y];
		}
		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(Node[i][k] == INF || Node[k][j] == INF) continue;
					Node[i][j] = Math.min(Node[i][k] + Node[k][j], Node[i][j]);
				}
			}
		}
		if(Node[1][a] >= INF || Node[a][b] >= INF || Node[b][n] >= INF)
			System.out.println("-1");
		else {
			int sum = Node[1][a] + Node[a][b] + Node[b][n];
			sum = Math.min(Node[1][b] + Node[b][a] + Node[a][n], sum);
			System.out.println(sum);
		}
	}
}