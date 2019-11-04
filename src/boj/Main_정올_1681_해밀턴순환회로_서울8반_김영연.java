package boj;

import java.util.Scanner;

public class Main_정올_1681_해밀턴순환회로_서울8반_김영연 {
	
	static int n, min;
	static int[][] map;
	static boolean[] visit;
	public static void dfs(int index, int count, int sum) {
		if(sum > min) return;
		if(count == n) {
			if(map[index][1] != 0) {
				sum += map[index][1];
				min = Math.min(min, sum);
			}
			return;
		}
		for(int i=1; i<=n; i++) {
			if(!visit[i] && map[index][i] != 0) {
				visit[i] = true;
				dfs(i, count+1, sum + map[index][i]);
				visit[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n+1][n+1];
		min = Integer.MAX_VALUE / 2;
		visit = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) map[i][j] = sc.nextInt();
		}
		visit[1] = true;
		dfs(1,1,0);
		System.out.println(min);
	}
}