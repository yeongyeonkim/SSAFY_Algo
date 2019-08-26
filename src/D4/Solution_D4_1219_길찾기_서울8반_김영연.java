package D4;

import java.util.Scanner;

public class Solution_D4_1219_길찾기_서울8반_김영연 {
	static int[][] map;
	static int cnt;
	public static void find(int v) {
		if(v == 99)
			cnt = 1;
		else{
			for(int i=v+1; i<=99; i++) {
				if(map[v][i] == 1)
					find(i);
			}
		}
	}
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			int testcase = sc.nextInt();
			cnt = 0;
			int n = sc.nextInt(); // 길의 총 개수
			map = new int[100][100];
			for(int i=0; i<n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
			find(0);
			System.out.println("#"+testcase+" "+cnt);
		}
	}
}
