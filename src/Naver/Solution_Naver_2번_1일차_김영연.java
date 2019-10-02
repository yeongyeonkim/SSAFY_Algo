package Naver;

public class Solution_Naver_2번_1일차_김영연 {

	static int cnt;
	static char[][] map;
	
	public static void find(int x, int y, int star, int n) {
		if(star == 1 && map[x][y] == '*')
			return; //종료
		else if(map[x][y] == '#') { //아래로
			if(x + 1 >= n) {
				cnt++;
				return; //범위 넘으면 out
			}
			find(x + 1, y, star, n);
		}
		else if(map[x][y] == '>') {
			if(y + 1 >= n) return;
			find(x, y + 1, star, n);
		}
		else if(map[x][y] == '<') {
			if(y - 1 < 0) return;
			find(x, y - 1, star, n);
		} 
		else {     //(map[x][y] == '*') 처음 만난 별이면 범위 벗어나지않고 star+1
			if(x + 1 >= n) {
				cnt++;
				return;
			}
			find(x + 1, y, star + 1, n);
		}
	}
	
	public int main(String[] drum){
		int n = drum.length;
		map = new char[n][n];
		for(int i=0; i<n; i++) {
			String str = drum[i];
			for(int j=0; j<n; j++) 
				map[i][j] = str.charAt(j);
		}
		cnt = 0;
		for(int i=0; i<drum.length; i++) {
			find(0, i, 0, n);
		}
		return cnt;
	}
}