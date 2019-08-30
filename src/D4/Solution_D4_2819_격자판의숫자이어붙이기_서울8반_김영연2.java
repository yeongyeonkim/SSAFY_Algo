package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
//map 연습하기.
public class Solution_D4_2819_격자판의숫자이어붙이기_서울8반_김영연2 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static String[][] map;
	static Map<String, Integer> hs = new HashMap<>();
	
	public static void search(int x, int y, int count, String tmp) {
		if(count == 7) {
			hs.put(tmp, 1);
			return;
		}
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(0<=nx && nx <4 && 0<= ny && ny < 4) {
				search(nx, ny, count+1, tmp + map[nx][ny]);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			hs.clear();
			map = new String[4][4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++)
					map[i][j] = str.nextToken();
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++)
					search(i, j, 1, map[i][j]);
			}
			System.out.println("#" + t + " " + hs.size());
		}
	}
}