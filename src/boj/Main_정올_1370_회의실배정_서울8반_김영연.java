package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_정올_1370_회의실배정_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] list = new int[n][3];
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] info = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				list[i][j] = Integer.parseInt(info[j]);
			}
			arr.add(list[i][2]);
		} // 값 넣기.
		Collections.sort(arr);
		boolean[] visit = new boolean[n];
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.size(); j++) {
				if (arr.get(i) == list[j][2] && visit[j] == false) { // arr는 끝시간정렬한거 그게 리스트의 것과가트면
					visit[j] = true;
					q.offer(j + 1); // 그 리스트의 인덱스를 q에 저장
				}
			}
		}
		int start = q.poll();
		arr.clear();
		arr.add(start);
		while (!q.isEmpty()) {
			int next = q.poll();
			if (list[start - 1][2] <= list[next - 1][1]) {
				arr.add(next);
				start = next;
			}
		}
		System.out.println(arr.size());
		for(int i=0; i<arr.size(); i++)
			System.out.print(arr.get(i) + " ");
	}
}