package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1992_쿼드트리_서울8반_김영연 {

	static char[][] map;
	
	public static void find(int x, int y, int length) {
		boolean flag = false;
		for(int i=x; i<x+length; i++) {
			for(int j=y; j<y+length; j++) 
				if(map[x][y] != map[i][j]) flag = true;
		}
		if(!flag) System.out.print(map[x][y]);
		else {
			System.out.print("(");
			find(x, y, length / 2);
			find(x, y + length / 2, length / 2);
			find(x + length / 2, y, length / 2);
			find(x + length / 2, y + length / 2, length / 2);
			System.out.print(")");
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) 
				map[i][j] = str.charAt(j);
		}
		find(0, 0, n);
	}
}