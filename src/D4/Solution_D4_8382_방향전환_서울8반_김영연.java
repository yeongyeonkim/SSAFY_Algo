package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_8382_방향전환_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			x = Math.abs(x - Integer.parseInt(st.nextToken()));
			y = Math.abs(y - Integer.parseInt(st.nextToken()));
			int cnt = (x - y >= 0) ? y * 2 : x * 2;
			int tmp = Math.abs(x - y);
			cnt += tmp % 2 == 0 ? tmp*2 : tmp*2 -1;
			System.out.println("#"+t+" "+cnt);
		}
	}

}
