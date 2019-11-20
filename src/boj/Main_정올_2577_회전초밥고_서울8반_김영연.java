package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_2577_회전초밥고_서울8반_김영연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 접시 수
		int d = Integer.parseInt(st.nextToken()); // 가짓 수
		int k = Integer.parseInt(st.nextToken()); // 연속 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰
		int[] visit = new int[d+1];
		int[] a = new int[n+1];
		int max = Integer.MIN_VALUE;
		int cnt = 0;
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) if(++visit[a[i]] == 1) cnt++;
		if(visit[c] == 0) max = Math.max(max, cnt+1);
		else			  max = Math.max(max, cnt);
		for(int i=0; i<n; i++) {
			if(max == k+1) break;
			if(--visit[a[i]] == 0) cnt--;
			if(++visit[a[(i+k)%n]] == 1) cnt++;
			if(visit[c] == 0) max = Math.max(max, cnt+1);
			else 			  max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
}
