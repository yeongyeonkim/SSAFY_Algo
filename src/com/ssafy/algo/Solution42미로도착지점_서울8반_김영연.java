package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution42미로도착지점_서울8반_김영연 {
	
	public static void main(String args[]) throws Exception {
		;
		System.setIn(new FileInputStream("res/Solution42미로도착지점.txt"));
		Scanner sc = new Scanner(System.in);	
		int TestCase = sc.nextInt();
		for (int t = 1; t <= TestCase; t++) {
			int n = sc.nextInt(); //배열의 크기 8입력하면 9x9배열
			int[][] maze = new int[n+1][n+1];
			int s_x = sc.nextInt();
			int s_y = sc.nextInt();
			int jump_number = sc.nextInt();
			for(int i=0; i<jump_number; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				maze[x][y] = 1; // 점퍼를 1로
			}
			int move_num = sc.nextInt();
			int flag = 0; // 출력을 한번 씩 하기 위한 장치.
			for(int i=0; i<move_num; i++) {
				int dir = sc.nextInt();
				int move = sc.nextInt();
				if(dir == 1) {//상
					if(s_x - move <= 0 || maze[s_x - move][s_y] == 1) {//벗어나거나 점퍼
						System.out.println("#"+t+" 0 0");
						flag = 1;
						break;
					}
					else s_x -= move;
				}
				else if(dir == 2) {//우
					if(s_y + move >= n || maze[s_x][s_y + move] == 1) {//벗어나거나 점퍼
						System.out.println("#"+t+" 0 0");
						flag = 1;
						break;
					}
					else s_y += move;
				}
				else if(dir == 3) {//하
					if(s_x + move >= n || maze[s_x + move][s_y] == 1) {//벗어나거나 점퍼
						System.out.println("#"+t+" 0 0");
						flag = 1;
						break;
					}
					else s_x += move;
				}
				else {//좌
					if(s_y - move <= 0 || maze[s_y - move][s_y] == 1) {//벗어나거나 점퍼
						System.out.println("#"+t+" 0 0");
						flag = 1;
						break;
					}
					else s_y -= move;
				}
			}
			if(flag != 1)
				System.out.println("#"+t+" "+s_x+" "+s_y);
			
		}
	}
}