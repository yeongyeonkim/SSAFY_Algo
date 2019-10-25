package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17143_낚시왕_서울8반_김영연 {

	static int n, m, size;
	static int[][] map;// 인덱스 번호를 2차원배열
	static int[][] is_shark;
	static shark[] list;
	static int[] dx = {-1,1,0,0}; //위 아래 오른쪽 왼쪽
	static int[] dy = {0,0,1,-1}; // 0  1    2     3
	
	static class shark {
		int idx, r, c, s, d, z;
	}

	public static void move() {
		map = new int[n][m];
		for (shark shark : list) {
			if(shark == null) continue;
			int r = shark.r;
			int c = shark.c;
			int d = shark.d;
			int s = shark.s;
			int z = shark.z;
			for(int i = s; i > 0; i--) {
				int nx = r + dx[d];
				int ny = c + dy[d];
				if(nx < 0) {
					d = 1;
					nx = r + dx[d];
				} else if(nx >= n) {
					d = 0;
					nx = r + dx[d];
				} else if(ny < 0) {
					d = 2;
					ny = c + dy[d];
				} else if(ny >= m){
					d = 3;
					ny = c + dy[d];
				}
				r = nx; c = ny;
			}
			if(map[r][c] > 0) { //기존 상어 있는지.
				if(z > list[map[r][c]].z) list[map[r][c]] = null;
				else {
					list[shark.idx] = null; continue;
				}
			}
			shark.r = r; shark.c = c; shark.d = d;
			map[r][c] = shark.idx;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		is_shark = new int[n][m];
		list = new shark[k+1];
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			shark s = new shark();
			s.idx = i;
			s.r = Integer.parseInt(st.nextToken()) - 1;
			s.c = Integer.parseInt(st.nextToken()) - 1;
			s.s = Integer.parseInt(st.nextToken());
			s.d = Integer.parseInt(st.nextToken()) - 1;
			s.z = Integer.parseInt(st.nextToken());
			map[s.r][s.c] = i;
			list[i] = s;
		}
		size = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[j][i] > 0) {
					size += list[map[j][i]].z;
					list[map[j][i]] = null;
					break;
				}
			}
			move();
		}
		System.out.println(size);
	}
}