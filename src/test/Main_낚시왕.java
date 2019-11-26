package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_낚시왕 {

	static int n, m, k;
	static int[][] map;
	static Shark[] S;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static class Shark{
		int r, c, s, d, z;
	}
	
	public static void move() {
		for(int i=1; i<=k; i++) {
			if(S[i] == null) continue;
			int x = S[i].r;
			int y = S[i].c;
			int d = S[i].d;
			for(int j=1; j<=S[i].s; j++) {//속력만큼
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(ny >= m) { //버뮈벗어나면 오른쪽이동했던거
					d = 3;
					ny = y+dy[d];
				} else if(ny < 0) {
					d = 2;
					ny = y+dy[d];
				} else if(nx >= n) {
					d = 0;
					nx = x+dx[d];
				} else if(nx < 0) {
					d = 1;
					nx = x+dx[d];
				}
				x = nx;
				y = ny;
			}
			if(map[x][y] > 0) { //상어 ㅇㅇ
				if(S[i].z > S[map[x][y]].z) S[map[x][y]] = null;
				else {
					S[i] = null; continue;
				}
			}
			S[i].r = x; S[i].c = y; S[i].d = d;
			map[x][y] = i;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		k = Integer.parseInt(st.nextToken());
		S = new Shark[k+1];
		for(int i=1; i<=k; i++) {
			Shark s = new Shark();
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = i;
			s.r = r;
			s.c = c;
			s.s = Integer.parseInt(st.nextToken());
			s.d = Integer.parseInt(st.nextToken()) - 1;
			s.z = Integer.parseInt(st.nextToken());
			S[i] = s;
		}
		int sum = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(map[j][i] != 0) {
					sum += S[map[j][i]].z;
					S[map[j][i]] = null; // 인덱스 null하고
					break;
				}
			}
			map = new int[n][m];
			move();
		}
		System.out.println(sum);
	}
}