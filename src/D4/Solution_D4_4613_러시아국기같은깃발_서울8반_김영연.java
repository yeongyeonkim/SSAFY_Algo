package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_4613_러시아국기같은깃발_서울8반_김영연 {

	static int min;
	
	public static void cal(int a, int b, int n) {
		for(int i=0; i<a; i++) {
			//white
		}
		for(int i=a; i<a+b; i++) {
			//blue
		}
		for(int i=a+b; i<n; i++) {
			
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			String[] str = new String[n];
			for(int i=0; i<n; i++) 
				str[i] = br.readLine();
			min = Integer.MAX_VALUE;
			for(int a=1; a<n-1; a++) {
				int b=1;
				while(a+b != n) {
					cal(a,b, n);
					b++;
				}
			}
			System.out.println(min);
		}
	}
}