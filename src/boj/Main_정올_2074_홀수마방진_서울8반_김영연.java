package boj;

import java.util.Scanner;

public class Main_정올_2074_홀수마방진_서울8반_김영연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n+1][n+1];
		int x = 1;
		int y = (n+1)/2;
		for(int i=1; i<=n*n; i++) {
			map[x][y] = i;
			if(i % n == 0) x++;
			else {
				x--; y--; //왼쪽 위
				if(x < 1) x = n;
				if(y < 1) y = n;
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}

}
