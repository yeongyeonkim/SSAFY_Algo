package D4;

import java.util.Scanner;

public class Solution_D4_4301_콩많이심기_서울8반_김영연 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] dx = {0,2,0,-2};
		int[] dy = {2,0,-2,0};
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int cnt=0;
			boolean[][] visit = new boolean[m][n];
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(visit[i][j]) continue;
					boolean flag = false;
					for(int k=0; k<4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(0<=nx && nx < m && 0<=ny && ny < n && !visit[nx][ny])
							visit[nx][ny] = true;
					}
					if(!flag) cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}