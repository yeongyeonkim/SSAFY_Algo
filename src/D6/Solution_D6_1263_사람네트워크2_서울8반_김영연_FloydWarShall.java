package D6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D6_1263_사람네트워크2_서울8반_김영연_FloydWarShall {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && map[i][j] == 0)
						map[i][j] = 987654321;
				}
			}
			for(int k=0; k<n; k++) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) 
						map[i][j] = Math.min(map[i][k]+map[k][j], map[i][j]);
				}
			}
			int min = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				int sum = 0;
				for(int j=0; j<n; j++) 
					sum += map[i][j];
				min = (min < sum) ? min : sum;
			}
			System.out.println("#"+t+" "+min);
		}
	}
}