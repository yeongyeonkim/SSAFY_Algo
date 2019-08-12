package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_백준_2667_단지번호붙이기_서울8반_김영연 {

	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visit;
	static int N, cnt;

	public static void search(int x, int y) {
		visit[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(0<= nx && nx < N && 0<= ny && ny < N && visit[nx][ny] == false) {
				cnt++;
				search(nx,ny);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> result = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
				if(map[i][j] == 0) visit[i][j] = true;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visit[i][j] == false) {
					cnt = 1;
					search(i, j);
					result.add(cnt);
				}
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for (int a : result) {
			System.out.println(a);
		}
	}

}
