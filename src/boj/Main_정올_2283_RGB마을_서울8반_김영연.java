package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_2283_RGB마을_서울8반_김영연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][3];
		int[][] dp = new int[n][3];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) dp[0][i] = map[0][i];
		for(int i=1; i<n; i++) {
			for(int j=0; j<3; j++) {
				int tmp = Integer.MAX_VALUE;
				for(int k=0; k<3; k++) { //k는 color
					if(j==k) continue;
					tmp = Math.min(tmp, dp[i-1][k]);
				}
				dp[i][j] = map[i][j] + tmp;
			}
		}
		for(int i=0; i<3; i++) {
			min = Math.min(min, dp[n-1][i]);
		}
		System.out.println(min);
	}
}