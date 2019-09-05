package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_2634_사냥꾼_서울8반_김영연 {
	static class Animal {
		int x;
		int y;

		public Animal(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<Integer> arr;
	static int m, n, l; // 사대, 동물, 사정거리

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new ArrayList<>();
		for (int i = 0; i < m; i++)
			arr.add(Integer.parseInt(st.nextToken()));
		Collections.sort(arr);
		ArrayList<Animal> ani = new ArrayList<Animal>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ani.add(new Animal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(ani, new Comparator<Animal>() {
			@Override
			public int compare(Animal o1, Animal o2) {
				return o1.x < o2.x ? -1 : 1;
			}
		});
		int cnt = 0;
		int index = 0;
		for (int i = 0; i < n; i++) {
			Animal tmp = ani.get(i);
			if (arr.get(index) == tmp.x) { // 참조하는 index와 tmp.x의 값이 같은경우 먼저 빼준다.
				if (l - Math.abs(arr.get(index) - tmp.x) >= tmp.y)
					cnt++;
			} else if (arr.get(index) < tmp.x) { // 지금 tmp.x 값이 중간에 있는 경우
				while (index + 1 != arr.size() && arr.get(index + 1) <= tmp.x) { // 범위에 벗어나지 않으면서 다음거가 클때까지 돌린다
					if (arr.get(index) == tmp.x) { // index 올리던 중 같은게 나오면 cnt++해주고 break;
						cnt++;
						break;
					}
					index++;
				}
				//while문을 벗어났다는 것은 1. 범위에서 벗어났거나 (마지막이라서), 2. 다음거가 커서
				if (index + 1 == arr.size()) {  // 범위에서 벗어난 경우 좌(index)만 탐색.
					if (l - Math.abs(arr.get(index) - tmp.x) >= tmp.y)
						cnt++;
				} else { // 다음거가 커서 인 경우 좌(index) 우(index+1) 탐색
					if (l - Math.abs(arr.get(index) - tmp.x) >= tmp.y) 
						cnt++;
					else if (l - Math.abs(arr.get(index + 1) - tmp.x) >= tmp.y) 
						cnt++;
				}
			} else {// 참조하는 index 값이 바로 큰 경우 (이 부분은 아마 시작 몇개에만 해당될텐데 따로 빼기가 귀찮아서)
				if (l - Math.abs(arr.get(index) - tmp.x) >= tmp.y) 
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
