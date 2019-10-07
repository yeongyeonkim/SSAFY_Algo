package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17471_A형1번_게리맨더링_서울8반_김영연 {

	static int n, max, min;
	static int[] people;
	static int[][] map;
	static boolean[] visit;
	static ArrayList<Integer> arr1;
	static ArrayList<Integer> arr2;

	public static boolean BFS(ArrayList<Integer> a) {
		if(a.size() == 1) return true;
		boolean[] visit2 = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(a.get(0));
		int cnt = 1;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			visit2[tmp] = true;
			for(int i=1; i<=n; i++) {
				if(!visit2[i] && a.contains(i) && map[tmp][i] == 1) {
					cnt++;
					visit2[i] = true;
					q.add(i);
				}
			}
		}
		if(cnt == a.size()) return true;
		else return false;		
	}

	public static void perm(int cnt, int[] tmp) {
		if (cnt == max) {
			for (int i = 0; i < tmp.length; i++)
				arr1.add(tmp[i]);
			for (int i = 1; i <= n; i++) {
				if (!visit[i]) arr2.add(i);
			}
			if(BFS(arr1) && BFS(arr2)){
				int sum = 0;
				for(int i=0; i<arr1.size(); i++)
					sum += people[arr1.get(i)];
				for(int i=0; i<arr2.size(); i++)
					sum -= people[arr2.get(i)];
				sum = Math.abs(sum);
				min = min < sum ? min : sum;
			}
			arr1.clear();
			arr2.clear();
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				tmp[cnt] = i;
				perm(cnt + 1, tmp);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		people = new int[n + 1];
		map = new int[n + 1][n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++)
			people[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= k; j++) {
				int y = Integer.parseInt(st.nextToken());
				map[i][y] = 1;
				map[y][i] = 1;
			}
		}
		int INF = 987654321;
		min = INF;
		arr1 = new ArrayList<>();
		arr2 = new ArrayList<>();
		for (max = 1; max <= n / 2; max++) {
			int[] tmp = new int[max];
			visit = new boolean[n+1];
			perm(0, tmp);
		}
		if(min != INF) System.out.println(min);
		else System.out.println(-1);
		
	}
}
