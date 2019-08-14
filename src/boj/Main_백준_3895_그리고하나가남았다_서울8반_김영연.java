package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_3895_그리고하나가남았다_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		while (cnt < 100) {
			String[] info = br.readLine().split(" ");
			int n = Integer.parseInt(info[0]);
			int k = Integer.parseInt(info[1]);
			int m = Integer.parseInt(info[2]);
			if(n == 0 && k == 0 && m == 0) return;
			for (int i = m + 1; i <= n; i++)
				q.offer(i);
			for (int i = 1; i < m; i++)
				q.offer(i);
			while (q.size() != 1) {
				for (int i = 1; i < k; i++) // k-1번.
					q.offer(q.poll());
				q.poll();
			}
			System.out.println(q.poll());
			cnt++;
		}
	}

}
