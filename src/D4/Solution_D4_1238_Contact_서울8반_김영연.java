package D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D4_1238_Contact_서울8반_김영연 {
	public static int[][] map;
	public static int[] visit;
	static int max_index;
	static Stack<Integer> s1;
	static Stack<Integer> s2;

	public static void find(int v) {
		s1.push(v);
		visit[v] = 1;
		int max;
		while (true) {
			max = 0;
			while (!s1.isEmpty()) {//
				int tmp = s1.pop();
				if (max < tmp)
					max = tmp;
				for (int i = 1; i < max_index; i++) {
					if (map[tmp][i] == 1 && visit[i] == 0) {
						s2.push(i);
						visit[i] = 1;
					}
				}
			}
			if (s2.isEmpty()) {
				System.out.print(max);
				break;
			}
			max = 0;
			while (!s2.isEmpty()) {
				int tmp = s2.pop();
				if (max < tmp)
					max = tmp;
				for (int i = 1; i < max_index; i++) {
					if (map[tmp][i] == 1 && visit[i] == 0) {
						s1.push(i);
						visit[i] = 1;
					}
				}
			}
			if (s1.isEmpty()) {
				System.out.print(max);
				break;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/Contact.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			map = new int[101][101];
			max_index = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < n / 2; k++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if (x > max_index)
					max_index = x;
				if (y > max_index)
					max_index = y;
				map[x][y] = 1;
			}
			visit = new int[max_index];
			s1 = new Stack<Integer>();
			s2 = new Stack<Integer>();
			System.out.print("#"+t+" ");
			find(start);
			System.out.println();
		}
	}
}