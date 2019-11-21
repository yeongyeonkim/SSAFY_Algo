package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_백준_2580_스도쿠 {
	
	public static boolean available(int[][] a, int r, int c, int target) {
		for(int k=0; k<a.length; k++) {
			if(a[k][c]==target || a[r][k]==target) return false;
		}
		int nr = r/3*3;
		int nc = c/3*3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(a[nr+i][nc+j]==target) return false;
			}
		}
		return true;
	}
	
	public static void dfs(int[][] a, List<int[]> list, int index) {
		if(index == list.size()) {
			for(int[] b:a) {
				for(int n:b) {
					System.out.print(n+" ");
				}
				System.out.println();
			}
			System.exit(0); // return;
		}
		int[] loc=list.get(index);
		int i=loc[0]; int j=loc[1];
		for(int t=1; t<=9; t++) {
			if(available(a,i,j,t)) {
				a[i][j]=t;
				dfs(a,list,index+1);
				a[i][j]=0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int[][] a = new int[9][9];
		List<int[]> list = new ArrayList<>();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				a[i][j] = sc.nextInt();
				if(a[i][j]==0)list.add(new int[] {i,j});
			}
		}
		dfs(a,list,0);
	}
}
