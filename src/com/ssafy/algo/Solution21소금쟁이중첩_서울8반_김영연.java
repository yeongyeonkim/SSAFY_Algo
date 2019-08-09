package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution21소금쟁이중첩_서울8반_김영연 {

	public static void main(String args[]) throws Exception {
		;
		System.setIn(new FileInputStream("res/Solution21소금쟁이중첩.txt"));
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		for (int t = 1; t <= TestCase; t++) {
			int n = sc.nextInt();
			int[][] pond = new int[n][n];
			int s = sc.nextInt(); // 소금쟁이 수
			int flag = 0;
			int first_salt = 0;
			for (int i = 1; i <= s; i++) {// 소금쟁이 수 만큼
				int[] d = { 0, 3, 5, 6 };
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dir = sc.nextInt();

				if (dir == 1 && flag == 0) { // 하
					for(int j=0; j<d.length; j++) {
						if(x+d[j] >= n)
							break;
						if(pond[x+d[j]][y] == 0) {
							pond[x+d[j]][y] = 1;
						}
						else { //이미 밟은 곳일경우.
							first_salt = i;
							flag = 1;
						}
					}
				}//
				if (dir == 2 && flag == 0) { // 우
					for(int j=0; j<d.length; j++) {
						if(y+d[j] >= n)
							break;
						if(pond[x][y+d[j]] == 0) {
							pond[x][y+d[j]] = 1;
						}
						else { //이미 밟은 곳일경우.
							first_salt = i;
							flag = 1;
						}
					}
				}//
			}
			System.out.println("#" + t + " " + first_salt);
		}
	}
}
