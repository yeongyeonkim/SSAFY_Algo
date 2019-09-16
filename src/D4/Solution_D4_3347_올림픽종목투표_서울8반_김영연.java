package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3347_올림픽종목투표_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] a = new int[n][2];
			int[] b = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) 
				a[i][0] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) 
				b[i] = Integer.parseInt(st.nextToken());
			int idx_b = 0;
			while(idx_b != m) {
				int idx_a = 0;
				while(idx_a != n) {
					if(a[idx_a][0] <= b[idx_b]) {
						a[idx_a][1]++;
						break;
					}
					idx_a++;
				}
				idx_b++;
			}
			int max = 0;
			int idx = 0;
			for(int i=0; i<n; i++) {
				if(max < a[i][1]) {
					max = a[i][1];
					idx = i;
				}
			}
			System.out.println("#" + t + " " + ++idx);
		}
	}
}