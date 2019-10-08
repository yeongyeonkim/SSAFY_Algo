package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_2000_동전교환_서울8반_김영연 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[n];
        for(int i=0; i<n; i++)
            number[i] = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(br.readLine());
        int[] dp = new int[w+1];
        for(int i=1; i<=w; i++) 
            dp[i] = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(number[i] > w) 
                continue;
            dp[number[i]] = 1;
        }
        for(int i=1; i<=w; i++) {
            for(int j=0; j<n; j++) {
                if(i-number[j] <= 0 || dp[i-number[j]] == Integer.MAX_VALUE) 
                    continue;
                dp[i] = Math.min(dp[i], dp[i-number[j]] + 1);
            }
        }
        if(dp[w] == Integer.MAX_VALUE)
            System.out.println("impossible");
        else
            System.out.println(dp[w]);
    }
}