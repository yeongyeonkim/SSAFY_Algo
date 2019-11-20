package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D9_1952_수영장_서울8반_김영연 {

	static int[] price, days;
	static int min;
	
	public static void find(int index, int sum) {
		if(index == 13) {
			min = Math.min(min, sum);
			return;
		}
		if(days[index] == 0) find(index + 1,sum);
		else {
			find(index + 1, sum + (days[index] * price[0]));
			find(index + 1, sum + price[1]);
			find(index + 3 > 13 ? 13 : index + 3, sum + price[2]);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			price = new int[3];
			days = new int[13];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<3; i++) price[i] = Integer.parseInt(st.nextToken());
			min = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=12; i++) days[i] = Integer.parseInt(st.nextToken());
			find(1, 0);
			System.out.println("#"+t+" "+min);
		}
	}
}