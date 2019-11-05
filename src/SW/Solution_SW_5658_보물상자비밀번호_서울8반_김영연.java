package SW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_SW_5658_보물상자비밀번호_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			// n/4개씩 잘라서 넣다가 넣는게 cnt가 0이면
			ArrayList<Integer> arr = new ArrayList<>();
			// 12 10
			// 1B3B3B81F75E
			int divide = n / 4;
			String swap = str;
			while (true) {
				str = swap;
				int cnt = 0;
				for (int i = 1; i <= 4; i++) {
					int tmp = Integer.parseInt(str.substring((i-1)*divide, i*divide), 16);
					if(!arr.contains(tmp)) {
						arr.add(tmp);
						cnt++;
					}
				}
				if(cnt == 0) break;
				swap = "";
				swap += str.charAt(n-1);
				for(int i=0; i<str.length()-1; i++) swap += str.charAt(i);
			}
			Collections.sort(arr);
			System.out.println("#"+t+" "+arr.get(arr.size() - k));
		}
	}

}
