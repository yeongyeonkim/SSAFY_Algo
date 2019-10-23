package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D4_3316_동아리실관리하기_서울8반_김영연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int result = 0;
			String str = br.readLine();
			int[][] dp = new int[str.length()][16];
			for (int k = 0; k < str.length(); k++) {
				int primary = str.charAt(k) - 'A';
				for (int i = 1; i < (1<<4); i++) {
					if (k == 0) {// 시작은 A를 인계받아야하므로 이번 primary를 지니면서 1번째요소(A)가 1이여야하는 것을 1로 초기화하며 시작
						if ((i & (1 << primary)) != 0 && (i & (1 << 0)) != 0) dp[0][i] = 1;
					} else {
							if (dp[k - 1][i] > 0) { // 처음 이후부턴 그 전값이 존재했다면 가지를 뻗어나감
								for (int j = 1; j < (1<<4); j++) 
									if ((j & (1 << primary)) != 0 && (j & i) != 0)
										dp[k][j] = (dp[k][j] + dp[k - 1][i]) % 1000000007;
							}
						}
				}
			}
			for (int i = 1; i < (1<<4); i++)
				result = (result + dp[str.length() - 1][i]) % 1000000007;
			System.out.println("#" + t + " " + result);
		}
	}
}
