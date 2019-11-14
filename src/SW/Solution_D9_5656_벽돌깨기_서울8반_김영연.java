package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D9_5656_벽돌깨기_서울8반_김영연 {
	static int k, n, m, min;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static int[][] down(int[][] map){
		for (int i = n-2; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 0) continue;
				int nx = i + 1;
				while(nx<n&&map[nx][j] == 0) {
					nx++;
				}
				nx--;
				int asd = map[i][j];
				map[i][j] = 0;
				map[nx][j] = asd;
			}
		}
		return map;
	}
	public static int[][] BFS(int x, int y, int[][] map){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y , map[x][y] });
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int cnt = tmp[2] - 1;
			map[tmp[0]][tmp[1]] = 0; // pop
			if(cnt == 0) continue;
			for(int i=0; i<4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				int timer = 0;
				while(0<=nx&&nx<n&&0<=ny&&ny<m&&timer < cnt) {
					if(map[nx][ny] != 0) q.add(new int[] {nx, ny, map[nx][ny]});
					nx += dx[i];
					ny += dy[i];
					timer++;
				}
			}
		}
		return down(map);
	}
	
	public static void comb(int count, int[][] map) {
		if(count == k) {
			int remain = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] != 0) remain++;
				}
			}
			min = Math.min(min, remain);
			return;
		}
		for(int j=0; j<m; j++) {
			int[][] tmp = new int[n][m];
			for(int x=0; x<n; x++) {
				for(int y=0; y<m; y++) 
					tmp[x][y] = map[x][y];
			}
			int	index = 0;
			while(index < n) {
				if(tmp[index][j] == 0) index++;
				else {
					int[][] changed_tmp = BFS(index, j, tmp);
					comb(count+1, changed_tmp);
					break;
				}
			}
			if(index == n) comb(count + 1, tmp); //범위 벗어나면(안하면 count 갱신이 안될 듯)
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][m];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			comb(0, map);
			System.out.println("#"+t+" "+min);
		}
	}
}