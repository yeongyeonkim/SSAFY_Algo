package NHN;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_4 {
	static int n, liter;
	static int[][] map;
	static boolean[] visit;
	static ArrayList<String> arr;
	static StringBuilder sb;
	static boolean minus;

	static class path implements Comparable<path> {
		StringBuilder sbb;
		int m;
		int l;

		public path(StringBuilder sbb, int m, int l) {
			this.sbb = sbb;
			this.m = m;
			this.l = l;
		}

		@Override
		public int compareTo(path o) {
			if (this.m > o.m)
				return -1;
			else if (this.m < o.m)
				return 1;
			else {
				if (this.l == o.l)
					minus = true;
				return this.l < o.l ? -1 : 1;
			}
		}
	}

	public static void search(int start) {
		if (start == n - 1) {
			arr.add(sb.toString());
			sb = new StringBuilder();
			return;
		}
		for (int i = 1; i < n; i++) {
			if (!visit[i] && map[start][i] != 0) {
				visit[i] = true;
				sb.append(i);
				search(i);
				visit[i] = false;
			}
		}
		sb = new StringBuilder();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		liter = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = st.nextToken().charAt(0) - 'A';
			int y = st.nextToken().charAt(0) - 'A';
			int z = Integer.parseInt(st.nextToken());
			map[x][y] = z;
			map[y][x] = z;
		}
		visit = new boolean[n];
		visit[0] = true;
		sb = new StringBuilder();
		arr = new ArrayList<>();
		search(0); // 목적지로 가는 경로들을 넣어줌
		ArrayList<path> list = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {

			int tmp_liter = liter;
			String str = arr.get(i);
			int e = str.charAt(0) - '0';
			tmp_liter -= (map[0][e] - 10);
			int index = 1;
			boolean flag = false;
			while (index < str.length()) {
				int start = str.charAt(index - 1) - '0';
				int end = str.charAt(index) - '0';
				if (tmp_liter - map[start][end] < 0) { // 갈수없으면
					flag = true;
					break;
				}
				tmp_liter -= (map[start][end] - 10);
				index++;
			}
			int money = index * 200;
			if (!flag) money += 100;
			StringBuilder ssb = new StringBuilder();
			ssb.append("A");

			for (int k = 0; k < index; k++) {
				char c = (char) (str.charAt(k) + 17);
				ssb.append(" " + c);
			}
			list.add(new path(ssb, money, tmp_liter));
		}
		Collections.sort(list);
		if (minus) {
			System.out.println("-1");
			return;
		}
		int max = 0;
		ArrayList<Integer> max_index = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).m > max) {
				max = list.get(i).m;
				max_index.clear();
				max_index.add(i);
			} else if (list.get(i).m == max) {
				max_index.add(i);
			}
		}
		if (max_index.size() == 1) { // 단한개.
			System.out.println(list.get(max_index.get(0)).sbb + " " + list.get(max_index.get(0)).m + " "
					+ list.get(max_index.get(0)).l);
		} else {
			for (int i = 0; i < max_index.size(); i++)
				System.out.println(list.get(max_index.get(i)).sbb + " " + list.get(max_index.get(i)).m + " "
						+ list.get(max_index.get(i)).l);
		}

	}
}