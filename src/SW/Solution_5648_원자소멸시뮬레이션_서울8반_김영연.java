package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5648_원자소멸시뮬레이션_서울8반_김영연 {
	static int[][] map = new int[4001][4001];
	static ArrayList<Node> arr = new ArrayList<>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int sum, n;
	static boolean[] visit;

	static class Node {
		int x;
		int y;
		int dir;
		int en;

		public Node(int x, int y, int dir, int en) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.en = en;
		}
	}

	public static void move() {
		while (true) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if(visit[i]) {
					cnt++;
					continue;
				}
				Node tmp = arr.get(i);
				// 내가 있던 곳이 값이 나의 값이랑 다르다면 부딪힌것.
				if (map[tmp.x][tmp.y] != tmp.en) {
					sum += map[tmp.x][tmp.y];
					map[tmp.x][tmp.y] = 0;
					visit[i] = true;
					continue;
				}
				// 부딪힌게 아니면 내가 원래 있던 곳의 map을 0으로 갱신해야함
				else
					map[tmp.x][tmp.y] = 0;
				int nx = tmp.x + dx[tmp.dir];
				int ny = tmp.y + dy[tmp.dir];
				// 이동할 인덱스
				if (0 <= nx && nx <= 4000 && 0 <= ny && ny <= 4000) {
					map[nx][ny] += tmp.en; // 탐색한 곳의 맵에 에너지+
					arr.set(i, new Node(nx, ny, tmp.dir, tmp.en));
				} else // 범위 벗어난 녀석이므로 visit true로 검색 안하게끔
					visit[i] = true;
			}
			if(cnt == arr.size()) return;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			visit = new boolean[n];
			arr.clear();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) * 2 + 2000;
				int y = Integer.parseInt(st.nextToken()) * 2 + 2000;
				int dir = Integer.parseInt(st.nextToken());
				int en = Integer.parseInt(st.nextToken());
				arr.add(new Node(x, y, dir, en));
				map[x][y] = en; // 에너지를 맵에 저장?
			}
			sum = 0;
			move();
			System.out.println("#" + t + " " + sum);
		}
	}
}