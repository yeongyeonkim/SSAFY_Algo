package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_7854_최약수_서울8반_김영연 {

	public static int check(int tmp) {
		String str = "" + tmp;
		if(str.charAt(0) != '1' && str.charAt(0) != '2' && str.charAt(0) != '5' && str.charAt(0) != '0')
			return 0;
		return 1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int num = Integer.parseInt(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(1);
			q.offer(1);
			while(!q.isEmpty()) {
				int tmp = q.poll();
				int tmp2 = tmp * 2;
				if(num >= tmp2 && check(tmp2) == 1 && !arr.contains(tmp2)) {
					q.offer(tmp2);
					arr.add(tmp2);
				}
				int tmp5 = tmp * 5;
				if(num >= tmp5 && check(tmp5) == 1 && !arr.contains(tmp5)) {
					q.offer(tmp5);
					arr.add(tmp5);
				}
			}
			System.out.println("#" + t + " " +arr.size());
		}
	}
}