package D4;

import java.util.Scanner;

public class Solution_D4_5643_키순서_서울8반_김영연 {

	static int n, m, cnt;
	static int[][] g;
	static boolean[] visit;
	
	public static void dfs(int start, int size) {
		visit[start] = true;
		for(int i=1; i<=n; i++) {
			if(!visit[i] && g[start][i] == size) {
				cnt++;
				dfs(i, size);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			g = new int[n+1][n+1];
			for(int i=0; i<m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				g[a][b] = 1; // 1은 자신보다 큼
				g[b][a] = 2; // 2는 자신보다 작음
			}
			int ans = 0;
			for(int i=1; i<=n; i++) {
				cnt = 0;
				visit = new boolean[n+1];
				dfs(i,1);
				dfs(i,2); //작은거 cnt랑 큰거cnt 개수 세서 (-1은 나 자신)
				if(cnt==n-1) ans++;
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}