package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_6719_성수의프로그래밍강좌시청_서울8반_김영연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //총 n개의 수
			int k = Integer.parseInt(st.nextToken()); //k개만 고른다
			int[] m = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) 
				m[i] = Integer.parseInt(st.nextToken());
			double result = 0.0;
			Arrays.sort(m);
			for(int i=n-k; i<n; i++)
				result = (result+m[i])/2;
			System.out.printf("#%d %f\n", t, result);
		}
	}
}
