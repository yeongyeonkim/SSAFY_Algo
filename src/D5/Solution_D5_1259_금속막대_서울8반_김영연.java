package D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1259_금속막대_서울8반_김영연 {

	static int[] p;
	
	public static void print(int n) {
		if(p[n] == 0) return;
		System.out.print(" " + n + " " + p[n]);
		print(p[n]);
	}
	public static int find(int x, int count) {
		if(p[x] == 0) return count;
		else return find(p[x], count + 1);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			p = new int[31];
			int[] list = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				int x = Integer.parseInt(st.nextToken());
				list[i-1] = x;
				p[x] = Integer.parseInt(st.nextToken());
			}
			int max = 0, idx = 0;
			for(int i=0; i<n; i++) { 
				int count = find(list[i], 0);
				if(max < count) {
					max = count;
					idx = i;
				}
			}
			System.out.print("#"+t);
			print(list[idx]);
			System.out.println();
		}
	}
}