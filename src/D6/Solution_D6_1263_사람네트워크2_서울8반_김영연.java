package D6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D6_1263_사람네트워크2_서울8반_김영연 {

	static Queue<int[]> q = new LinkedList<>();
	static boolean[] visit;
	static int[][] map;
	static int n;

	public static int cc(int start) {
		int sum = 0;
		visit[start] = true;
		q.add(new int[] { start, 1 });
		while (!q.isEmpty()) {
			int[] tmp = q.poll(); // [0] : 점 / [1] : 간선 수
			for (int i = 1; i <= n; i++) {
				if (visit[i] == true || map[tmp[0]][i] == 0)
					continue;
				visit[i] = true;
				q.add(new int[] { i, tmp[1] + 1 }); // 점과 간선+1
				sum += tmp[1];
			}
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			q.clear();
			n = Integer.parseInt(st.nextToken());
			map = new int[n + 1][n + 1];
			visit = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= n; i++) {
				visit = new boolean[n + 1];
				int c = cc(i);
				min = min > c ? c : min;
			}
			System.out.println("#"+t+" "+min);
		}
	}
}