package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1733_오목_서울8반_김영연 {
	static int[][] map;
	static int result, result_x, result_y;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static void find(int i, int j) {
		int color = map[i][j];
		for(int d=0; d<8; d++) {
			int cnt = 1;
			int x = i + dx[d];
			int y = j + dy[d];
			while(1<=x&&x<=19&&1<=y&&y<=19&& color == map[x][y]) {
				cnt++; 
				x += dx[d]; y += dy[d];
			}
			if(cnt == 5 && map[i+dx[(d+4)%8]][j+dy[(d+4)%8]] != color) {
				result = color; result_x = i; result_y = j;
				return;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[20][20];
		StringTokenizer st;
		for (int i = 1; i <= 19; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= 19; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		result = 0; result_x = 0; result_y = 0;
		for(int j=1; j<=19; j++) {
			for(int i=1; i<=19; i++) {
				if(map[i][j] != 0 && result == 0) find(i, j);
			}
		}
		System.out.println(result);
		if(result != 0) System.out.println(result_x + " " + result_y);
	}
}