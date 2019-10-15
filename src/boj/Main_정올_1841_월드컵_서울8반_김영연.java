package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1841_월드컵_서울8반_김영연 {
	static int[][] arr;
	static int result;

	static void solve(int A,int B, int count) {
		if(result==1) {
			return;
		}
		if(count >= 15) {
			result=1;
			return;
		}
		if(B==6) {
			A++;
			B = A+1;
		}
		//for(int[] ii:arr)System.out.println(Arrays.toString(ii));
		//A가 이김
		if(arr[A][0]>0 && arr[B][2]>0) {
			arr[A][0]--; arr[B][2]--;
			solve(A,B+1,count+1);
			arr[A][0]++; arr[B][2]++;
		}
		//비김
		if(arr[A][1]>0 && arr[B][1]>0) {
			arr[A][1]--; arr[B][1]--;
			solve(A,B+1,count+1);
			arr[A][1]++; arr[B][1]++;
		}
		//짐
		if(arr[A][2]>0 && arr[B][0]>0) {
			arr[A][2]--; arr[B][0]--;
			solve(A,B+1,count+1);
			arr[A][2]++; arr[B][0]++;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 0; tc < 4; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr = new int[6][3];
			result=0;
			for (int i = 0; i < 18; i++) {
				arr[i/3][i%3] = Integer.parseInt(st.nextToken());
				if(arr[i/3][i%3]>5)result=1;
			}
			if(result==1) {
				System.out.print("0 ");
				continue;
			}
			result=0;
			solve(0,1,0);
			
			System.out.print(result+" ");
		}
	}
}