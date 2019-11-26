package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_경사로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int j = 0;
		for(int i=0; i<n; i++) {
			int cnt = 1;
			for(j=0; j<n-1; j++) {
				if(map[i][j] == map[i][j+1]) cnt++;
				else if(map[i][j] + 1 == map[i][j+1] && cnt >= L) cnt = 1;
				else if(map[i][j] - 1 == map[i][j+1] && cnt >= 0) cnt = -L + 1; //음수로 만들고 이걸 양수로 만들 가능성이 있는지 보는거지
				else break; //이미 음수였는데 또 내리막이 생겨서 위의 경우로 가지못하면.
			}
			if(j == n - 1 && cnt >= 0) ans++;
			cnt = 1;
			for(j=0; j<n-1; j++) {
				if(map[j][i] == map[j+1][i]) cnt++;
				else if(map[j][i] + 1 == map[j+1][i] && cnt >= L) cnt = 1;
				else if(map[j][i] - 1 == map[j+1][i] && cnt >= 0) cnt = -L + 1;
				else break;
			}
			if(j == n - 1 && cnt >= 0) ans++;
		}
		System.out.println(ans);
	}
}