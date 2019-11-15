package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_D4_4050_재관이의대량할인_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			ArrayList<Integer> num = new ArrayList<>();
			for(int i=0; i<n; i++) num.add(Integer.parseInt(st.nextToken()));
			Collections.sort(num);
			int sum = 0;
			for(int i=0; i<n%3; i++) sum += num.remove(0);
			for(int i=0; i<num.size(); i++) {
				if(i%3==0) num.get(i);
				else sum += num.get(i);
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}