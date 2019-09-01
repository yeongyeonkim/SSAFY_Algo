package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_4408_자기방으로돌아가기_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		for(int t=1; t<=tc; t++) {
			int[] visit = new int[401];
			int max = Integer.MIN_VALUE;
			int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
			for(int k=0; k<n; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if(start> end) { // swap
					int tmp = start;
					start = end;
					end = tmp;
				}
				for(int i=start; i<=end; i++) 
					visit[i]++;
				if(end % 2 == 1)
					visit[end+1]++;
			}
			for(int i=1; i<=400; i++)
				if(max < visit[i]) max = visit[i];
			System.out.println("#"+t+" " +max);
		}
	}
}
