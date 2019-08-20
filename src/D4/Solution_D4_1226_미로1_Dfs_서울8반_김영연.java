package D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_1226_미로1_Dfs_서울8반_김영연 {

	static int flag, nx, ny;
	static int[][] maze;
	static int[][] visit;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void dfs(int x, int y) {
		visit[x][y] = 1;
		for (int i = 0; i <= 3; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (maze[nx][ny] == 3) {
				flag = 1;
				return;
			}
			if (0 <= nx && nx < 16 && 0 <= ny && ny < 16)
				if (maze[nx][ny] == 0 && visit[nx][ny] != 1) {
					dfs(nx, ny);
				}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/maze1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			maze = new int[16][16];
			visit = new int[16][16];
			for (int i = 0; i < 16; i++) {
				String s = br.readLine();
				for (int j = 0; j < 16; j++)
					maze[i][j] = s.charAt(j) - '0';
			}
			flag = 0;
			dfs(1, 1);// 이번 테스트 케이스에선 출발점이 1,1 고정이므로
			if (flag == 1)
				System.out.println("#" + t + " 1");
			else
				System.out.println("#" + t + " 0");
		}
	}
}
