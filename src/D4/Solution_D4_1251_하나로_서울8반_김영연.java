package D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_D4_1251_하나로_서울8반_김영연 {

	static PriorityQueue<Node> q = new PriorityQueue<>();
	static int[][] island;
	static boolean[] visit;
	static double e, max, cnt;

	static class Node implements Comparable<Node> {

		int index;
		double sum;

		public Node(int index, double sum) {
			this.index = index;
			this.sum = sum;
		}

		@Override
		public int compareTo(Node o) {
			return this.sum < o.sum ? -1 : 1; // 작은값을 먼저.
		}

	}

	public static void BFS() {
		q.offer(new Node(0, 0));
		
		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (visit[tmp.index] == true)
				continue;
			visit[tmp.index] = true;
			max += tmp.sum;
			cnt++;
			if(cnt == island.length) break;
			
			for (int i = 0; i < island.length; i++) {
				if (visit[i] == false) {
					q.offer(new Node(i, e * (Math.pow(island[i][0] - island[tmp.index][0], 2)
							+ Math.pow(island[i][1] - island[tmp.index][1], 2))));
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/D4_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
		int n = Integer.parseInt(br.readLine());
		q.clear();
		max = 0;
		cnt = 0;
		visit = new boolean[n];
		island = new int[n][n];
		String[] info = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			island[i][0] = Integer.parseInt(info[i]); // x좌표입력
		info = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			island[i][1] = Integer.parseInt(info[i]);
		e = Double.parseDouble(br.readLine());
		BFS();
		System.out.println("#" + t + " " + Math.round(max));
		}
	}
}