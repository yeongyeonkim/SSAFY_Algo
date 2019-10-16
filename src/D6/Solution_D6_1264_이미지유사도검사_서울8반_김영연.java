package D6;

import java.util.Scanner;

public class Solution_D6_1264_이미지유사도검사_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			String a = sc.next();
			String b = sc.next();
			int[][] c = new int[n+1][n+1];
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(a.charAt(j-1) == b.charAt(i-1)) c[i][j] = c[i-1][j-1] + 1;
					else c[i][j] = (c[i-1][j] > c[i][j-1]) ? c[i-1][j] : c[i][j-1];
				}
			}
			System.out.printf("#%d %.2f\n", t, (double)c[n][n] / (double) n * 100);
		}
	}
}
/*
[0][n]에는 n개만큼 0으로 채워주고
같은 문자면 위 값 + 1 (사실은 왼쪽 대각선 위 값의 + 1인게 맞다.
why? =? ACA 와 CA가 있을때
AC와 C까지 1이였던게 다음 A와 A를 보면서 LCS(최장 공통 부분 수열)이 3이 된 것이 정확한 의미
다른 문자면 왼쪽 값, 위 값 중 큰 것
*/