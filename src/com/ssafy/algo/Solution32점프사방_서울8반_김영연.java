package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution32점프사방_서울8반_김영연 {

	static int money;

	static void move(int x, int y, int n, int[][] map,int height,int width) { // 처음 행 열 반복횟수, map

		if (map[x][y] == 0)// 함정이면 벗어남.
			return;
		if (n == 0) {// 반복횟수 끝나면 지금 위치에 기반한 금액+
			money = money + map[x][y] * 100;
			return;
		}
		else { // 함정이 아닌 경우
			if (map[x][y] / 10 == 1 && y + map[x][y] % 10 < width) {// 동
				move(x, y + map[x][y] % 10, n - 1, map,height,width);
			} else if (map[x][y] / 10 == 2 && x + map[x][y] % 10 < height) {// 남
				move(x + map[x][y] % 10, y, n - 1, map,height,width);
			} else if (map[x][y] / 10 == 3 && y - map[x][y] % 10 >= 0) {// 서
				move(x, y - map[x][y] % 10, n - 1, map,height,width);
			} else if (map[x][y] / 10 == 4 && x - map[x][y] % 10 >= 0) {// 북
				move(x - map[x][y] % 10, y, n - 1, map,height,width);
			} 
			else// 반복횟수도 남아있고 함정도 아닌데 이동도 안했다면, 벗어난 경우임
				return;
		}

	}

	public static void main(String args[]) throws Exception {
		;
		System.setIn(new FileInputStream("res/Solution32점프사방.txt"));
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		for (int t = 1; t <= TestCase; t++) {

			int x = sc.nextInt(); // 행
			int y = sc.nextInt(); // 열
			int[][] map = new int[x][y];
			int n = sc.nextInt(); // 참가자 수
			money = -1000 * n;
			int[][] v = new int[n][3];
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int k = 0; k < n; k++) { // 참가자 수만큼 반복.
				v[k][0] = sc.nextInt() - 1;
				v[k][1] = sc.nextInt() - 1;
				v[k][2] = sc.nextInt();
			}
			int trap = sc.nextInt();
			for (int k = 0; k < trap; k++) {
				int trap_x = sc.nextInt();
				int trap_y = sc.nextInt();
				map[trap_x - 1][trap_y - 1] = 0;
			}
			for (int i = 0; i < n; i++) { // 참가자 수만큼 반복.
				move(v[i][0], v[i][1], v[i][2], map,x,y);
			}
			System.out.println("#" + t + " " + money);
		}
	}
}