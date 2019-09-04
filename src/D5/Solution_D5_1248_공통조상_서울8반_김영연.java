package D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D5_1248_공통조상_서울8반_김영연 {
	static class Node {
		int left;
		int right;

		public Node(int left) {
			this.left = left;
		}
	}

	// 부모가 들어있는 집합을 만들어도 좋을듯.
	static Node[] n;
	static int v;
	static int cnt, parent;

	public static void insert(int idx, ArrayList<Integer> list) {
		for (int i = 1; i <= v; i++) {
			if (n[i] == null)
				continue;
			if (n[i].left == idx || n[i].right == idx) {// 일단 그 값을 가진 친구(i)를 찾는다.
				if (n[i].left == 0 || n[i].right == 0) // 하나라도 null이면
					insert(i, list); // 값 추가 필요없이 위로 ㄱㄱ
				else {
					list.add(i);
					insert(i, list);
				}
			}
		}
	}

	public static void search(int idx) {
		if (n[idx] == null)
			return;
		if (n[idx].left != 0) {
			cnt++;
			search(n[idx].left);
		}
		if (n[idx].right != 0) {
			cnt++;
			search(n[idx].right);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken()); // v
			int e = Integer.parseInt(st.nextToken()); // v - 1
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			ArrayList<Integer> list1 = new ArrayList<>();
			ArrayList<Integer> list2 = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			n = new Node[v + 1];
			for (int i = 0; i < e; i++) {
				int index = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				if (n[index] == null)
					n[index] = new Node(child);
				else
					n[index].right = child;
			}
			insert(v1, list1);
			insert(v2, list2);

			boolean flag = false;
			for (int i = 0; i < list1.size(); i++) {
				for (int j = 0; j < list2.size(); j++) {
					if (list2.contains(list1.get(i)) && flag == false) {
						parent = list1.get(i);
						flag = true;
					}

				}
			}
			cnt = 1;
			search(parent);
			System.out.println("#" + t + " " + parent + " " + cnt);
		}
	}
}
