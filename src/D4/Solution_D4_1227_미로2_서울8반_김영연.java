package D4;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D4_1227_미로2_서울8반_김영연 {

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
			if (0 <= nx && nx < 100 && 0 <= ny && ny < 100) //사실 이게 없어도 됨.
				if (maze[nx][ny] == 0 && visit[nx][ny] != 1) {
					dfs(nx, ny);
				}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/maze2.txt"));
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int testcase = sc.nextInt();
			sc.nextLine();
			maze = new int[100][100];
			visit = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < 100; j++)
					maze[i][j] = s.charAt(j) - '0';
			}
			flag = 0;
			dfs(1, 1);// 이번 테스트 케이스에선 출발점이 1,1 고정이므로
			System.out.println("#" + testcase + " "+flag);
		}
	}
}
