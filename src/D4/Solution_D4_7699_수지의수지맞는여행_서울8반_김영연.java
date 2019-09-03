package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞는여행_서울8반_김영연 {

	static char[][] map;
	static boolean[] alpha;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int r, c, max;
	
	public static void DFS(int x, int y, int count) {
		if(count > max) max = count;
		if(count == 26) return;
		alpha[map[x][y] - 'A'] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0<= nx && nx < r && 0<= ny && ny < r && alpha[map[nx][ny] - 'A'] == false) {
//				alpha[map[x][y] - 'A'] = true;
				DFS(nx, ny, count+1);
				alpha[map[nx][ny] - 'A'] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new char[r][c];
			for(int i=0; i<r; i++) {
				String str = br.readLine();
				for(int j=0; j<c; j++)
					map[i][j] = str.charAt(j);
			}
			max = 1;
			alpha = new boolean[26];
//			alpha[map[0][0]] = true;
			DFS(0, 0, 1);
			System.out.println("#"+ t + " " + max);
		}
	}
}