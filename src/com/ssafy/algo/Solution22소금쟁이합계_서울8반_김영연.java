package com.ssafy.algo;

import java.util.Scanner;

public class Solution22소금쟁이합계_서울8반_김영연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		for (int t = 1; t <= TestCase; t++) {
			int n = sc.nextInt();
			int[][] pond = new int[n][n];
			int s = sc.nextInt(); // 소금쟁이 수
			int cnt = 0;
			for (int i = 1; i <= s; i++) {// 소금쟁이 수 만큼
				int[] d = { 0, 3, 5, 6 };
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dir = sc.nextInt();
				if (dir == 1) {//상			
					if(x - 6 < 0) // 어쨌든 소금쟁이가 나간다면 죽음.
						continue;
					for (int j = 0; j < d.length; j++) {
						if(pond[x - d[j]][y] == 1) //이전 소금쟁이의 마지막 지점이면 죽음.
							break;
						if(j == d.length - 1) {
							pond[x-6][y] = 1;
							cnt++;
						}
					}
				}
				else if(dir == 2) { //하
					if(x + 6 >= n) // 어쨌든 소금쟁이가 나간다면 죽음.
						continue;
					for (int j = 0; j < d.length; j++) {
						if(pond[x + d[j]][y] == 1) //이전 소금쟁이의 마지막 지점이면 죽음.
							break;
						if(j == d.length - 1) {
							pond[x+6][y] = 1;
							cnt++;
						}
					}
				}
				else if(dir == 3) { //좌
					if(y - 6 < 0) // 어쨌든 소금쟁이가 나간다면 죽음.
						continue;
					for (int j = 0; j < d.length; j++) {
						if(pond[x][y - d[j]] == 1) //이전 소금쟁이의 마지막 지점이면 죽음.
							break;
						if(j == d.length - 1) {
							pond[x][y-6] = 1;
							cnt++;
						}
					}
				}
				else { //우
					if(y + 6 >= n) // 어쨌든 소금쟁이가 나간다면 죽음.
						continue;
					for (int j = 0; j < d.length; j++) {
						if(pond[x][y + d[j]] == 1) //이전 소금쟁이의 마지막 지점이면 죽음.
							break;
						if(j == d.length - 1) {
							pond[x][y+6] = 1;
							cnt++;
						}
					}
				}
				
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}