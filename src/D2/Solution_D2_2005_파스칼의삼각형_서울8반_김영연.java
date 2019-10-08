package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_2005_파스칼의삼각형_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n+1][n+1];
			System.out.println("#"+t);
			for(int i=1; i<=n ;i++) {
				for(int j=1; j<=i; j++) {
					if(j==i) arr[i][j] = 1;
					else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}