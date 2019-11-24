package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D9_2117_홈방범서비스_서울8반_김영연 {

	static int n,m, max;
	static int[][] map;
	
	public static void BFS(int x, int y, int k) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[n][n];
		q.add(new int[] {x, y, 1});
		visit[x][y] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(map[tmp[0]][tmp[1]] == 1) cnt++;
			if(tmp[2] == k) continue;
			for(int i=0; i<4; i++) {
				int nx = dx[i] + tmp[0];
				int ny = dy[i] + tmp[1];
				if(0<=nx&&nx<n&&0<=ny&&ny<n&&!visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new int[] { nx, ny,  tmp[2] + 1 } );
				}
			}
		}
		//여기서 cnt랑 k로 계산.
		int win = cnt * m;
		int lose = k*k + (k-1)*(k-1);
		int result = win - lose;
		
		if(result >= 0) //손해를 안보면
			max = Math.max(max, cnt);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			max = Integer.MIN_VALUE;
			for(int k=1; k<=n+1; k++) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) BFS(i,j,k);
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}