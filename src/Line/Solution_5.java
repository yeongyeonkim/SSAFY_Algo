package Line;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_5 {
	static int row, col, cnt;
	static int[][] map;
	static int[] dx = {0, 1}; //위, 오른쪽
	static int[] dy = {1, 0};
	public static void DFS(int x, int y) {
		if(x == row && y == col) {
			cnt++; 
			return;
		}
		for(int i=0; i<2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0<=nx && nx <= row && 0<=ny && ny <= col)
				DFS(nx, ny);
		}
	}
	//visit 배열이 필요 없을 것으로 보임.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max_x = Integer.parseInt(st.nextToken());
		int max_y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		//모눈 종이 밖으로 설정된 경우에만 fail이다.
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		if(max_x < row || max_y < col) {
			System.out.println("fail");
			return;
		}
		//그 외의 경우는 이제 코니가 있는 곳 만큼 map을 설정
		map = new int[row+1][col+1]; //한 칸 더 크게 설정하여야 함.
		cnt = 0;
		DFS(0, 0);
		System.out.println(row + col);
		System.out.println(cnt);
	}
}