package D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D5_7396_종구의딸이름짓기_서울8반_김영연 {

	static class name implements Comparable<name>{
		int x;
		int y;
		String str;
		public name(int x, int y, String str) {
			this.x = x;
			this.y = y;
			this.str = str;
		}
		public int compareTo(name o) {
			return this.str.compareTo(o.str);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char[][] map = new char[n][m];
			for(int i=0; i<n; i++) {
				String input = br.readLine();
				for(int j=0; j<m; j++) 
					map[i][j] = input.charAt(j);
			}
			String result = "";
			PriorityQueue<name> q = new PriorityQueue<>();
			int[] dx = {1,0};
			int[] dy = {0,1};
			q.add(new name(0,0,map[0][0] + ""));
			boolean[][] visit = new boolean[n][m];
			visit[0][0] = true;
			while(!q.isEmpty()) {
				name tmp = q.poll();
				if(tmp.x == n-1 && tmp.y == m-1) {
					result = tmp.str;
					break;
				}
				for(int i=0; i<2; i++) {
					int nx = tmp.x + dx[i];
					int ny = tmp.y + dy[i];
					if(0<=nx&&nx<n&&0<=ny&&ny<m&&!visit[nx][ny]) {
						visit[nx][ny] = true;
						String tmp_str = tmp.str + map[nx][ny];
						q.add(new name(nx, ny, tmp_str));
					}
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}