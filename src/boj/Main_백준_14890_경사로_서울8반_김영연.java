package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14890_경사로_서울8반_김영연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		int j = 0;
        for(int i = 0; i < N; i++) {
            int cnt = 1;
            for(j = 0; j < N-1; j++) {
                if(map[i][j] == map[i][j+1]) cnt++;
                //내리막길
                else if(map[i][j] + 1 == map[i][j+1] && cnt >= L) cnt = 1;
                //오르막길
                else if(map[i][j] - 1 == map[i][j+1] && cnt >= 0) cnt = -L+1;
                else break;
            }
            if(j == N-1 && cnt >= 0) ans++;
            
            cnt = 1;
            for(j = 0; j < N-1; j++) {
                if(map[j][i] == map[j+1][i]) cnt++;
                else if(map[j][i] + 1 == map[j+1][i] && cnt >= L) cnt = 1;
                else if(map[j][i] - 1 == map[j+1][i] && cnt >= 0) cnt = -L+1;
                else break;
            }
            if(j == N-1 && cnt >= 0) ans++;
        }
        System.out.println(ans);
	}
}