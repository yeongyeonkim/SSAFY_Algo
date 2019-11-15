package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//4:28 ~ 5:24
public class Solution_D9_5644_무선충전_서울8반_김영연 {
	
	static int max, m, a, a_x, a_y, b_x, b_y;
	static int[] dir_a, dir_b;
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	static int[][] map;
	static int[][][] visit;
	
	public static void injection(int x, int y, int c, int p, int index) {
		Queue<int[]> q = new LinkedList<>();
		visit[index][x][y] = p; //값 넣어주고
		q.add(new int[] {x, y, 0});
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i=1; i<=4; i++) {
				int nx = dx[i] + tmp[0];
				int ny = dy[i] + tmp[1];
				if(1<=nx&&nx<=10&&1<=ny&&ny<=10&&visit[index][nx][ny] == 0&&tmp[2] < c) {
					visit[index][nx][ny] = p;
					q.add(new int[] { nx, ny, tmp[2] + 1 } );
				}
			}
		}
	}
	
	public static void move(int count, int sum) {
		if(count == m+1) {
			max = Math.max(max, sum);
			return;
		}
		//visit배열 확인하기.
		int result = 0;
		for(int i=0; i<a; i++) {
			for(int j=0; j<a; j++) {
				int tmp = 0;
				int A = visit[i][a_x][a_y];
				int B = visit[j][b_x][b_y];
				if(i==j && A==B)  tmp = A;
				else tmp = A + B;
				result = Math.max(result, tmp);
			}
		}
		//값 계산한걸 더하고 이동.
		a_x += dx[dir_a[count]]; a_y += dy[dir_a[count]];
		b_x += dx[dir_b[count]]; b_y += dy[dir_b[count]];
		move(count + 1, sum + result);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			a_x = 1; a_y = 1; b_x = 10; b_y = 10;
			map = new int[11][11];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			dir_a = new int[m+1]; dir_b = new int[m+1];
			a = Integer.parseInt(st.nextToken());
			visit = new int[a][11][11];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<m; i++) dir_a[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<m; i++) dir_b[i] = Integer.parseInt(st.nextToken());
			for(int i=0; i<a; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				//값들을 넣어준다. visit배열에
				injection(x,y,c,p,i);
			}
			max = 0;
			move(0, 0);
			System.out.println("#"+t+" "+max);
		}
	}
}
