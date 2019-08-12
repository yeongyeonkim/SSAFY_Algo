package boj;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_2156_포도주시식_서울8반_김영연 {

 static int max(int a, int b, int c) {
  return a > b ? (a > c) ? a : c : (b > c) ? b : c;
 }

 public static void main(String[] args) throws Exception {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int n = Integer.parseInt(br.readLine());
  int[] dp = new int[10003];
  int[] wine = new int[10003];
  for (int i = 1; i <= n; i++)
   wine[i] = Integer.parseInt(br.readLine());
  dp[1] = wine[1];
  dp[2] = wine[2] + dp[1];
  for (int i = 3; i <= n; i++) {
   dp[i] = max(dp[i - 2] + wine[i], dp[i - 3] + wine[i] + wine[i - 1], dp[i - 1]);
  }
  System.out.println(dp[n]);
 }
}
