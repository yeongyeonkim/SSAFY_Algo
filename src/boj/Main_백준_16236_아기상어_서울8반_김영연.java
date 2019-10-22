package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16236_아기상어_서울8반_김영연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int s_x = 0, s_y = 0;
		int[][] map = new int[n][n];
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int number = Integer.parseInt(st.nextToken());
				if(number == 9) {
					s_x = i; s_y = j;
					map[i][j] = 0;
				}
				else map[i][j] = number;
			}				
		}
		int result = 0, size = 2, cnt = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				//거리가 짧은순(2), 거리가 같으면 높이순(0), 높이도같으면(1)
				if(o1[2] < o2[2]) return -1;
				else if(o1[2] > o2[2]) return 1;
				else {
					if(o1[0] < o2[0]) return -1;
					else if(o1[0] > o2[0]) return 1;
					else return Integer.compare(o1[1], o2[1]);
				}
			}
		});
		pq.add(new int[] { s_x , s_y , 0 } );
		boolean[][] visit = new boolean[n][n];
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			//지금 뺀 녀석의 tmp위치에있는 map의 값이 size보다 작으면 tmp[2]를 ++ 하고 갱신
			if(map[tmp[0]][tmp[1]] != 0 && map[tmp[0]][tmp[1]] < size) {
				result += tmp[2];				
				cnt++;
				if(cnt == size) {
					size++;
					cnt = 0;
				}
				map[tmp[0]][tmp[1]] = 0;
				visit = new boolean[n][n];
				pq.clear();//★
				pq.add(new int[] {tmp[0], tmp[1], 0});
				continue;
			}
			for(int i=0; i<4; i++) {
				int nx = dx[i] + tmp[0];
				int ny = dy[i] + tmp[1];
				if(0<=nx&&nx<n&&0<=ny&&ny<n&&!visit[nx][ny]&&map[nx][ny] <= size) {
					visit[nx][ny] = true;
					pq.add(new int[] {nx, ny, tmp[2] + 1});
				}
			}
		}
		System.out.println(result);
	}
}