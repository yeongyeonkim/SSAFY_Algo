package D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로_서울8반_김영연 {
	static int n, min;
	static int[][] map;
	static boolean[] visit;
	
	public static void go(int index, int count, int sum) {
		if(sum > min) return;
		if(count == n) {//마지막순간에오면 집까지의 거리도.
			sum += Math.abs(map[index][0]-map[1][0]) + Math.abs(map[index][1]-map[1][1]);
			if(sum <= min) 
				min = sum;
			return;
		} else {
			for(int i=2; i<=n+1; i++) {
				if(visit[i]) continue; 
				visit[i] = true;
				int tmp = Math.abs(map[index][0] - map[i][0]) + Math.abs(map[index][1] - map[i][1]);
				go(i, count+1, sum + tmp);
				visit[i] = false;
			}			
		}		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n+2][2];
			visit = new boolean[n+2];
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n+2; i++) {
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			
			go(0, 0, 0);
			System.out.println("#"+t+" "+ min);
		}
	}

}
