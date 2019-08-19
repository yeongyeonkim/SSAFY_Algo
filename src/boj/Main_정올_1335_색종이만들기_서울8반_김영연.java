package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_정올_1335_색종이만들기_서울8반_김영연 {
	static int white, blue;
	
	public static int find(int[][] arr) {
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(arr[i][j] == 1) 
					cnt++;
			}
		}
		if(cnt == arr.length * arr.length) return 1; // blue
		if(cnt == 0) return 2; // white
		return 0; // blue and white
	}
	
	public static void divide(int[][] map, int n) {
		if(find(map) == 1)
			blue++;
		else if(find(map) == 2)
			white++;
		else {
			int[][] list1 = new int[n/2][n/2];
			for(int i=0; i<n/2; i++) {
				for(int j=0; j<n/2; j++) 
					list1[i][j] = map[i][j];
			}
			divide(list1, n/2);
			for(int i=0; i<n/2; i++) {
				for(int j=n/2; j<n; j++)
					list1[i][j-n/2] = map[i][j];
			}
			divide(list1, n/2);
			for(int i=n/2; i<n; i++) {
				for(int j=0; j<n/2; j++)
					list1[i-n/2][j] = map[i][j];
			}
			divide(list1, n/2);
			for(int i=n/2; i<n; i++) {
				for(int j=n/2; j<n; j++)
					list1[i-n/2][j-n/2] = map[i][j];
			}
			divide(list1, n/2);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			String[] info = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(info[j]);
			}
		}		
		white = 0; blue = 0;
		divide(map, n);
		System.out.println(white);
		System.out.println(blue);
	}

}
