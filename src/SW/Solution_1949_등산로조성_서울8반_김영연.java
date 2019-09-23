package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성_서울8반_김영연 {

	static int n, k, result, max, min;
	static int[][] map;
	static boolean[][] visit;
	static boolean flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void DFS(int x, int y, int count) {
		if (count > result)
			result = count;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < n && !visit[nx][ny]) {
				// 범위내에있고 들리지 않았다면
				if (map[nx][ny] < map[x][y]) {// 다음거가 작으면 그냥
					visit[nx][ny] = true;
					DFS(nx, ny, count + 1);
					visit[nx][ny] = false;
				} else {// 다음거가 클 경우
					if (!flag && map[x][y] > map[nx][ny] - k ) {
						// 굴삭 기회가 있고, 더 작게 굴삭할 수 있을때에
						int tmp = map[nx][ny];// 값을 잠시 저장
						map[nx][ny] = map[x][y] - 1;// 바로 아래값으로
						flag = true;
						visit[nx][ny] = true;
						DFS(nx, ny, count + 1);
						visit[nx][ny] = false;
						flag = false;
						map[nx][ny] = tmp;// 다시 돌려주기
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			visit = new boolean[n][n];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			result = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max)
						max = map[i][j];
					if (map[i][j] < min)
						min = map[i][j];
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == max) {
						flag = false;
						visit[i][j] = true;
						DFS(i, j, 1);
						visit[i][j] = false;
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
