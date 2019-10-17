package programmers;

public class Solution_3 {
/*
정사각형 크기 중 가장 큰 것 찾아서 출력하기.
visit요소 추가해서 들린 곳 안가면 될 듯.
 */
	public static void main(String[] args) {
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int n = board.length;
		int m = board[0].length;
		int min = Math.min(n, m);
		while(true) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(board[i][j] == 1) {
						boolean flag = false;
						for(int x=i; x<i+min; x++) {
							for(int y=j; y<j+min; y++) {
								if(x<0||y<0||x>=n||y>=m) {
									flag = true;
									break;
								}
								if(board[x][y] == 0) flag = true;
								//하나라도 0인게 있으면 true
							}
							if(flag) break;
						}
						if(!flag) {
							System.out.println(min*min);
							return;
						}
					}
				}
			}
			min--;
		}
	}
}
