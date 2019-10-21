package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16235_나무재테크_서울8반_김영연 {
	static int n, m, k;
	static int[][] map;
	static PriorityQueue<int[]> q; //x,y,age
	static Queue<int[]> death;
	
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
	
	public static void spring() {
		ArrayList<int[]> arr = new ArrayList<>();
		while(!q.isEmpty()) {
			int[] x = q.poll();
			if(map[x[0]][x[1]] < x[2])  //나이보다 양분이 적으면
				death.add(new int[] {x[0], x[1], x[2]});
			 else { //충분한 양분이면
				map[x[0]][x[1]] -= x[2]; //나이만큼 양분 --
				arr.add(new int[] { x[0], x[1], x[2] + 1});//나이 + 1
			}
		}//q에 다시 담기
		for(int i=0; i<arr.size(); i++) 
			q.add(new int[] {arr.get(i)[0], arr.get(i)[1], arr.get(i)[2]});
		arr.clear();
	}
	public static void summer() {
		while(!death.isEmpty()) {
			int[] x = death.poll();
			map[x[0]][x[1]] += x[2]/2;
		}
	}
	public static void fall() {
		ArrayList<int[]> arr = new ArrayList<>();
		while(!q.isEmpty()) {
			int[] x = q.poll();
			arr.add(new int[] { x[0], x[1], x[2]}); //일단
			if(x[2] % 5 == 0) { // 5의 배수면
				for(int i=0; i<8; i++) {
					int nx = dx[i] + x[0];
					int ny = dy[i] + x[1];
					if(1<=nx&&nx<=n&&1<=ny&&ny<=n)
						arr.add(new int[] {nx, ny, 1});
				}
			}
		}
		for(int i=0; i<arr.size(); i++) 
			q.add(new int[] {arr.get(i)[0], arr.get(i)[1], arr.get(i)[2]});
		arr.clear();
	}
	public static void winter(int[][] supply) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) 
				map[i][j] += supply[i][j];
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[][] supply = new int[n + 1][n + 1];
		map = new int[n + 1][n + 1];
		q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				map[i][j] = 5;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++)
				supply[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			q.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		death = new LinkedList<>();
		for(int i=0; i<k; i++) {
			spring();
			summer();
			fall();
			winter(supply);
		}
		System.out.println(q.size());
	}
}