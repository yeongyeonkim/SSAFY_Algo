package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_8424_유일한사이클_서울8반_김영연 {
	
	static int n, result;
	public static void dfs(int start, int count, boolean[][] map, int[] visit) {
		if(result != 0) return;
		if(visit[start] != 0) {
			result = count - visit[start];
			return;
		}
		visit[start] = count;
		for(int i=0; i<n; i++) {
			if(map[start][i]) {
				map[start][i] = map[i][start] = false;
				dfs(i, count + 1, map, visit);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			n = Integer.parseInt(br.readLine());
			boolean[][] map = new boolean[n][n];
			int[] visit = new int[n];
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				map[x][y] = map[y][x] = true;
			}
			result = 0;
			dfs(0, 1, map, visit);
			System.out.println("#"+t+" "+result);
		}
	}
}
