package D4;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D4_1211_Ladder2_서울8반_김영연
{
	static int[][] map;
	static int min, cnt, answer;
	
	public static void ladder(int x, int y) {

		if(x == 0) {// 끝
			if(min> cnt) {
				min = cnt;
				answer=y;
			}
			return;
		}
		//<-이동
		if(y > 0 && map[x][y-1] == 1) {
			while(y > 0 && map[x][y-1] == 1) {
				++cnt;
				y--;
			}
			++cnt;
			ladder(x-1,y);
		}
		//->이동
		else if(y < 99 && map[x][y+1] == 1) {
			while(y < 99 && map[x][y+1] == 1) {
				++cnt;
				y++;
			}
			++cnt;
			ladder(x-1,y);
		}
		//좌우가 1이아니면 무조건 위로간다.
		else {
			++cnt;
			ladder(x-1, y);
		}
	}
	public static void main(String args[]) throws Exception
	{;
		System.setIn(new FileInputStream("res/Ladder2.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int tca=sc.nextInt();//입력을 위한 쓰레기 값.
			map = new int[100][100];
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			min=100*100;
			answer = 0;
			for(int i=0; i<100; i++) {
				if(map[99][i] >= 1) {
					cnt = 0;
					ladder(99, i);
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}