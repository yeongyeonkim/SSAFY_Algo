package D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필트_서울8반_김영연 {
	static char[][] map;
	static String str;
	static int h, w, tank_x, tank_y, dir; // 시작인덱스, 방향
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	// dir 0 1 2 3
	// 오른쪽 아래 왼쪽 위

	public static void test(String tmp) {
		for (int i = 0; i < tmp.length(); i++) {
			char c = tmp.charAt(i);
			int x = tank_x;
			int y = tank_y; // 일시적으로 기억할
			switch (c) {
			case 'S':// 지금방향에서 쏴서 그위치 부셔
				while(true) {
					x += dx[dir];
					y += dy[dir];
					
					if(x>=0 && y>=0 && x<h && y<w) {
						if(map[x][y] == '*') {
							map[x][y] = '.';
							break;
						}
						if(map[x][y] == '#')
							break;
					}
					else
						break;
				}
				break;
			case 'R': // 오른쪽
				dir = 0;
				if (y + 1 < w && map[tank_x][y + 1] == '.') {
					swap(x, y+1);
					tank_y++;
				}
				break;
			case 'D': // 아래
				dir = 1;
				if (x + 1 < h && map[x + 1][tank_y] == '.') {
					swap(x+1, y);
					tank_x++;
				}
				break;
			case 'L': // 왼쪽
				dir = 2;
				if (y - 1 >= 0 && map[tank_x][y - 1] == '.') {
					swap(x,y-1);
					tank_y--;
				}
				break;
			case 'U': // 위
				dir = 3;
				if (x - 1 >= 0 && map[x - 1][tank_y] == '.') {
					swap(x-1,y);
					tank_x--;
				}
				break;
			}
		}
	}

	public static void swap(int x, int y) {
		char tmp = map[x][y];
		map[x][y] = map[tank_x][tank_y];
		map[tank_x][tank_y] = tmp;
	}
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/D3_1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] info = br.readLine().split(" ");
			h = Integer.parseInt(info[0]);
			w = Integer.parseInt(info[1]);
			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			} // 값 입력
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						tank_x = i;
						tank_y = j;
						if (map[i][j] == '>')
							dir = 0;
						else if (map[i][j] == 'v')
							dir = 1;
						else if (map[i][j] == '<')
							dir = 2;
						else
							dir = 3;
					}
				}
			}
			br.readLine();
			str = br.readLine();
			test(str);
			
			if (dir == 0)
				map[tank_x][tank_y] = '>';
			else if (dir == 1)
				map[tank_x][tank_y] = 'v';
			else if (dir == 2)
				map[tank_x][tank_y] = '<';
			else
				map[tank_x][tank_y] = '^';

			System.out.print("#" + t + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}