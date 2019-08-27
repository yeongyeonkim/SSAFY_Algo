package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_백준_1828_냉장고_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		
		int[][] matter = new int[N][2];
		for(int i=0; i<N; i++) {
			matter[i][0] = sc.nextInt();
			matter[i][1] = sc.nextInt();
		}
		Arrays.sort(matter, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		int cnt=1;
		int max = matter[0][1];
		for(int i=1; i<N; i++) {
			if(max < matter[i][0]) {
				//현화학물질의 최저온도가 냉장고의 최고온도보다 크다면 새로운 냉장고
				max=matter[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}