public class Solution_Naver_3번_2일차_김영연 {

	static int result, k, n;
	static boolean flag;
	static boolean[][] map;
	
	static void DFS(int x) {
		if(x == k && !flag) {
			flag = true; // 갈수 있는 경로가 있다는 뜻
			return;
		}
		for(int i=x+1; i<=k; i++) {
			if(map[x][i]) 
				DFS(i);
		}
	}
	
	public static void main(String[] args) throws Exception {
//		int[] cook = {5, 30, 15, 30, 35, 20, 4};
//		int[][] order = {{2,4},{2,5},{3,4},{3,5},{1,6},{4,6},{5,6},{6,7}};
//		k = 6;
//		int[] cook = {5, 30, 15, 30, 35, 20, 4, 50, 40};
//		int[][] order = {{2,4},{2,5},{3,4},{3,5},{1,6},{4,6},{5,6},{6,7},{8,9}};
//		k = 9;
		int[] cook = {5, 3, 2};
		int[][] order = {{1,2},{2,3},{1,3}};
		k = 3;
/* ---------------------------------------↑입력------------------------------------------ */
		n = cook.length;
		
		//order에 맞는 2차원 배열을 만듬
		map = new boolean[n+1][n+1]; //cook의 개수만큼.
		for(int i=0; i<order.length; i++) { 
			map[order[i][0]][order[i][1]] = true;
			map[order[i][1]][order[i][0]] = true;
		}
/* -------------------------------------result 앞 부분---------------------------------------- */
		result = 0;
		for(int i=1; i<k; i++) {
			flag = false;
			DFS(i);
			if(flag) result++; // dfs하고나서 flag가 변헀으면 k로 갈 수 있는 경로가 있다는 말이므로.
		}
/* -------------------------------------result 뒷 부분---------------------------------------- */

		boolean[] visit = new boolean[n];
		for(int i=1; i<=n; i++) { //그 cook 숫자에 해당하는 아래 자식이 있는지 보는거
			int max = 0;
			for(int j=1; j<i; j++) { // j는 그 숫자보다 먼저오는 순서친구들.
				if(map[i][j] == true) { //연결되어있다면 max값 갱신
					if(max < cook[j-1]) max = cook[j-1]; 
					visit[j-1] = true;//j로 선별됬다는 것은 자식이였다는 말.
				}
			}
			cook[i-1] += max;
		}
		//함정 ★
		int sum = 0;
		int cnt = 0;
		for(int i=0; i<n; i++) { //visit되지 않은녀석들은 독립적인거임 그렇다는말은 가장 큰 값을 출력하면 됨
			if(visit[i] == false) { //부모야.
				cnt++;
				if(sum < cook[i]) sum = cook[i];
			}
		}
		if(cnt >= 2) //부모가 두개이상이면 컸던 값을 해야하고
			System.out.println(result + " " + sum);
		else //부모가 한개면 그냥 k-1인덱스의 값
			System.out.println(result + " " + cook[k-1]);
	}
}