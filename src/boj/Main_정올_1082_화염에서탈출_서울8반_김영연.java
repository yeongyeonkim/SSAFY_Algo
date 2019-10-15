package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정올_1082_화염에서탈출_서울8반_김영연 {
	static int n, m, s_x, s_y, cnt;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean check;
	
	public static void f_BFS() {
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++)
				if(map[i][j] == '*')
					q.add(new int[] {i, j});
		}
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i=0; i<4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny] != 'D' 
					&& map[nx][ny] != 'X' && map[nx][ny] != '*') {
					map[nx][ny] = '*';
				}
			}
		}
	}
	
	public static void BFS() {
		//모든곳을 불로 만들어줘//X나 *은 못감 D 불 x
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {s_x, s_y, 0});
		int cur_time = -1;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(check) {
				return;
			}
			
			if(map[tmp[0]][tmp[1]] == 'D') {
				cnt = tmp[2];
				check=true;
				return;
			}
			if(cur_time != tmp[2]) {
				cur_time = tmp[2];
				f_BFS();
			}
			
			for(int i=0; i<4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if(0<=nx && nx<n && 0<=ny && ny <m && !visit[nx][ny]
				&& map[nx][ny] != 'X' && map[nx][ny] != '*') {
					visit[nx][ny] = true;
					q.add(new int[] {nx, ny, tmp[2] + 1});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new boolean[n][m];
		s_x = 0; s_y = 0;check=false;
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') { s_x = i; s_y = j; }
			}
		}
		cnt = 0;
		BFS();
		if(cnt == 0) System.out.println("impossible");
		else 		 System.out.println(cnt);
	}
}