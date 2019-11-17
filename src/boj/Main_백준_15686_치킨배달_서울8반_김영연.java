package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_15686_치킨배달_서울8반_김영연 {
	static int n, m, min;
	static ArrayList<int[]> home, chicken;
	static boolean[] visit; //치킨 visit
	
	public static void find_min() {
		int sum = 0;
		for(int i=0; i<home.size(); i++) {
			int x = home.get(i)[0];
			int y = home.get(i)[1];
			int i_min = Integer.MAX_VALUE/2;
			for(int j=0; j<chicken.size(); j++) {
				if(visit[j]) {
					int length = Math.abs(x - chicken.get(j)[0]) + Math.abs(y - chicken.get(j)[1]);
					i_min = length < i_min ? length : i_min;
				}
			}
			sum += i_min;
		}
		min = min < sum ? min : sum;
	}
	
	public static void perm(int index, int count) {
		if(count == m) {
			//m개면 visit배열에 visit인 친구들에 한해서 최소거리 계산한다.
			find_min();
			return;
		}
		for(int i=index; i<chicken.size(); i++) {
			if(!visit[i]) {
				visit[i] = true;
				perm(i, count + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 1) home.add(new int[] {i, j});
				else if(tmp == 2) chicken.add(new int[] {i, j});
			}
		}
		visit = new boolean[chicken.size()];
		min = Integer.MAX_VALUE/2;
		perm(0, 0);
		System.out.println(min);
	}
}
