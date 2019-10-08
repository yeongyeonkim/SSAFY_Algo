package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3282_01Knapsack_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] v = new int[n];
			int[] c = new int[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				v[i] = Integer.parseInt(st.nextToken());
				c[i] = Integer.parseInt(st.nextToken());
			}
			int[][] bag = new int[n+1][k+1];
			//v는 부피 c는 가치
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=k; j++) { //부피최대
					if(v[i-1] > j)
						bag[i][j] = bag[i-1][j];
					else {
						bag[i][j] = Math.max(bag[i-1][j-v[i-1]] + c[i-1], bag[i-1][j]);
					}
				}
			}
			System.out.println("#"+t+" " +bag[n][k]);
		}
	}

}
