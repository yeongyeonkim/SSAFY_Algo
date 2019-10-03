package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1865_동철이의일분배_서울8반_김영연 {

	static double[][] list; //앞에가 i번째 사람 뒤에가 j번째 일 확률
	static boolean[] visit;
	static double max;
	
	public static void perm(int count, double sum) {
		if(sum <= max)//소숫점을 계속 곱하니 계속 작아질테고
			return;
		if(count == visit.length) {
			if(max < sum) max = sum;
			return;
		}
		for(int i=0; i<visit.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				double tmp = sum * list[i][count];
				perm(count + 1, tmp);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			max = Double.MIN_VALUE;
			visit = new boolean[n];
			list = new double[n][n];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++)
					list[i][j] = Double.parseDouble(st.nextToken()) / 100;
			}
			perm(0, 1);
			System.out.printf("#%d %f" , t, max * 100);
			System.out.println();
		}
	}
}