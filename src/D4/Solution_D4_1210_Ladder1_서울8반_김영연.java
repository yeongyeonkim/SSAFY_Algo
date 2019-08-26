package D4;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D4_1210_Ladder1_서울8반_김영연
{
	static int[][] map;
	
	public static void ladder(int x, int y) {
		if(x == 0) {
			System.out.println(y); // 끝
			return;
		}
		//<-이동
		if(y > 0 && map[x][y-1] == 1) {
			while(y > 0 && map[x][y-1] == 1)
				y--;
			ladder(x-1,y);
		}
		//->이동
		else if(y < 99 && map[x][y+1] == 1) {
			while(y < 99 && map[x][y+1] == 1)
				y++;
			ladder(x-1,y);
		}
		//좌우가 1이아니면 무조건 위로간다.
		else ladder(x-1, y);			
	}
	public static void main(String args[]) throws Exception
	{;
		System.setIn(new FileInputStream("res/Ladder1.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int tca=sc.nextInt();
			int index_y = 0;
			map = new int[100][100];
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2) {
						index_y = j;
					}
				}
			}
			System.out.print("#"+t+" ");
			ladder(99, index_y);
		}
	}
}