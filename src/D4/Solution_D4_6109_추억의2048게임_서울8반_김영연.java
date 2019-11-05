package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_6109_추억의2048게임_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			boolean[][] visit = new boolean[n][n];
			String dir = st.nextToken();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			int dx[] = {-1, 0, 1, 0}; //up left
			int dy[] = { 0, -1, 0, 1};
			int d = 0;
			if(dir.equals("up")) d = 0;
			else if(dir.equals("left")) d = 1;
			else if(dir.equals("down")) d = 2;
			else d = 3;
			
			if (dir.equals("down")) { // x n-2 ~ 0
				while (true) {
					boolean flag = false;
					for (int i = n-2; i >= 0; i--) {
						for (int j = 0; j < n; j++) {
							int now = map[i][j];
							if(now == 0) continue;
							int next = map[i + 1][j];
							if(now < next) {
								visit[i + 1][j] = true;
								continue;
							}
							else if (now == next && !visit[i + 1][j]) { // 같으면 합쳐, 합쳤으면 visit
								map[i + 1][j] *= 2;
								map[i][j] = 0;
								visit[i + 1][j] = true;
								flag = true;
							} 
							else if (next == 0) {
								map[i + 1][j] = map[i][j];
								map[i][j] = 0;
								flag = true;
							}
						}
					}
					if(!flag) break;
				}
			} else if(dir.equals("right")){ // right
				while (true) {
					boolean flag = false;
					for (int j = n-2; j >= 0; j--) {
						for (int i = 0; i < n; i++) {
							int now = map[i][j];
							if(now == 0) continue;
							int next = map[i][j + 1];
							if(now < next) {
								visit[i][j + 1] = true;
								continue;
							}
							else if (now == next && !visit[i][j + 1]) {
								map[i][j + 1] *= 2;
								map[i][j] = 0;
								visit[i][j + 1] = true;
								flag = true;
							} 
							else if (next == 0) {
								map[i][j + 1] = map[i][j];
								map[i][j] = 0;
								flag = true;
							}
						}
					}
					if(!flag) break;
				}
			} else  { // x 1 ~ n-1
				while (true) {
					boolean flag = false;
					for (int i = 1; i < n; i++) {
						for (int j = 0; j < n; j++) {
							int nx = i+dx[d], ny = i+dy[d];
							int now = map[i][j];
							if(now == 0) continue;
							int next = map[nx][ny];
							if(now < next) {
								visit[nx][ny] = true;
								continue;
							}
							else if (now == next && !visit[nx][ny]) {
								map[nx][ny] *= 2;
								map[i][j] = 0;
								visit[nx][ny] = true;
								flag = true;
							} 
							else if (next == 0) {
								map[nx][ny] = map[i][j];
								map[i][j] = 0;
								flag = true;
							}
						}
					}
					if(!flag) break;
				}
			} 
			System.out.println("#"+t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}