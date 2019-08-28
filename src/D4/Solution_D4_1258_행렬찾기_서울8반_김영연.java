package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기_서울8반_김영연 {
	
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int max_x, max_y;
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Node o) {
			if(this.x*this.y < o.x * o.y)return -1;
			else if(this.x*this.y > o.x * o.y)return 1;
			else {//같은경우
				return this.x <= o.x ? -1 : 1;
			}
		}
	}
	
	public static void BFS(int x, int y) {
		
		int[] dx = {0,1};
		int[] dy = {1,0};
		visit[x][y] = true;
		q.offer(new int[] {x,y});
		max_x = x; max_y = y;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i=0; i<=1; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if(nx < map.length && ny < map.length 
						&& visit[nx][ny] == false && map[nx][ny] != 0) {
					visit[nx][ny] = true;
					q.offer(new int[] { nx, ny });
					if(nx >= max_x) max_x = nx;
					if(ny >= max_y) max_y = ny;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			q = new LinkedList<>();
			map = new int[n][n];
			visit = new boolean[n][n];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] != 0 && visit[i][j] == false) {
						max_x = Integer.MIN_VALUE; max_y = Integer.MIN_VALUE;
						BFS(i,j);
						cnt++;
						pq.add(new Node(max_x - i + 1, max_y - j + 1));
					}
				}
			}
			System.out.print("#" + t + " " + cnt);
			while(!pq.isEmpty()) {
				Node tmp = pq.poll();
				System.out.print(" " + tmp.x + " " + tmp.y);
			}
			System.out.println();
		}
	}

}
