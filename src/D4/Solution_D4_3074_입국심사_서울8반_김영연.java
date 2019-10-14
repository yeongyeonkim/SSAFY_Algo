package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3074_입국심사_서울8반_김영연 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long people = Long.parseLong(st.nextToken());
			long[] number = new long[n];
			long min = 0;
			long max = 0;
			for(int i=0; i<n; i++) { 
				number[i] = Long.parseLong(br.readLine());
				max = (max > number[i]) ? max : number[i];
			}
			max *= people;
			//최대 심사대의 people안의 시간에서는 무조건 종료될테니.
			//max와 min은 시간이 된다.
			long result = Long.MAX_VALUE/2;
			//퀵솔트
			while(min < max) {
				long mid = (min + max)/2;
				long cnt = 0;
				for(int i=0; i<n; i++)
					cnt += mid / number[i];
				if(cnt < people) min = mid + 1; //min갱신
				else { 
					//max갱신인데 result를 계속 갱신해줘야 while문 빠질때 값 가져감
					result = (result < mid) ? result : mid;
					max = mid;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}