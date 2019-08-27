package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_8338_계산기_서울8반_김영연{
	
	static int[] number, dp;
	
	public static void cal(int i) {
		if(i == number.length - 1) return;
		if(dp[i] * number[i+1] > dp[i+1])
			dp[i+1] = dp[i] * number[i+1];
		if(dp[i] + number[i+1] > dp[i+1])
			dp[i+1] = dp[i] + number[i+1];		
		cal(i+1);
	}
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			number = new int[n];
			dp = new int[n];
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) 
				number[i] = Integer.parseInt(str.nextToken());
			dp[0] = number[0];
			cal(0);
			System.out.println("#" + t + " " + dp[dp.length-1]);
		}
	}
}