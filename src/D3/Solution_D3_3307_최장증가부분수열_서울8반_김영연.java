package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_3307_최장증가부분수열_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++)
				a[i] = Integer.parseInt(st.nextToken());
			int[] l = new int[n];
			for (int i = 0; i < n; i++) {
				l[i] = 1;
				for (int j = 0; j < i; j++) {
					if (a[j] < a[i] && l[i] < 1 + l[j]) {
						l[i] = 1 + l[j];
					}
				}
			}
			System.out.println("#"+t+" "+Arrays.stream(l).max().getAsInt());
		}
	}
}
