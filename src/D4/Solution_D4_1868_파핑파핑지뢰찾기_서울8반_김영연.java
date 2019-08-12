package D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_1868_파핑파핑지뢰찾기_서울8반_김영연 {
	static char[][] map;
	static int[][] visit;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int n, cnt, flag;

	static void search(int x, int y) {// 주위가 다 0인요소 찾기.
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (map[nx][ny] == '*') return; // 지뢰발견하면 ㅌㅌ
			}
		}
		// 이곳에 도착하면 모두 .이였다는 소리이므로 visit처리해주고 cnt++
		if(flag == 0) {
			cnt++;
			flag = 1;
		}
		visit[x][y] = 1;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < n && visit[nx][ny] == 0) {
				visit[nx][ny] = 1;
				search(nx, ny);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/papingpaping.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= testcase; t++) {
			n = Integer.parseInt(bf.readLine());
			cnt = 0;
			map = new char[n][n];
			visit = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				for (int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') visit[i][j] = 1; // 지뢰는 방문할필요없으니
				}
			}
			// 데이터입력
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(visit[i][j] == 0 && map[i][j] != '*') {//방문한 적 없고, 지뢰가 아닌위치 탐색.
						flag = 0;
						search(i, j);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					if (visit[i][j] == 0) cnt++; // 방문하지않았으면.
			}
			System.out.println("#" + "t" + " " + cnt);
		}
	}
}