package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution_8444_IM기출1_서울8반_김영연 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t=1; t<=tc; t++) {
            int result = 0;
            int n = Integer.parseInt(br.readLine());
            String[] info = br.readLine().split(" ");
            int[] ans = new int[n+1];
            for(int i=0; i<n; i++) 
                ans[i+1] = Integer.parseInt(info[i]);
            int[] visit = new int[n+1];
            for(int i=1; i<=n; i++) {
                if(ans[i] == visit[i]) continue;
                result++;
                int tmp = i; //인덱스 복사
                int cnt = 1;
                while(tmp*cnt <= n) {
                    if(visit[tmp*cnt] == 1) visit[tmp*cnt] = 0;
                    else visit[tmp*cnt] = 1;
                    cnt++;
                }
            }
            System.out.println("#"+t+" "+result);
        }
    }
}