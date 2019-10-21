package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크_서울8반_김영연 {
	static int n, min;
	static int[][] map;
	static boolean[] visit;
	
	public static void comb(int count, int max, int index) {
		if(count == max) {
			int sum1 = 0, sum2 = 0;
			for(int i=0; i<n; i++) {
				if(visit[i]) {
					for(int j=0; j<n; j++) {
						if(i == j)continue;
						if(visit[j]) sum1 += map[i][j];
					}
				}
				else {
					for(int j=0; j<n; j++) {
						if(i==j)continue;
						if(!visit[j]) sum2 += map[i][j];
					}
				}
			}
			int result = Math.abs(sum1 - sum2);
			min = (min < result) ? min : result;
			return;
		}
		for(int i=index+1; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				comb(count + 1, max, i);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		visit = new boolean[n];
		min = Integer.MAX_VALUE;
		for(int i=2; i<=n/2; i++) 
			comb(0, i, 0);
		System.out.println(min);
	}
}