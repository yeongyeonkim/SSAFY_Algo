package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_백준_2304_창고다각형_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] list = new int[n][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				return o1[0] < o2[0] ? -1 : 1;
			}
		});
		int index = 0;
		int result = 0;
		while(index<n) {
			if(index == n-1) { //마지막 요소면
				result += list[index][1];
				break;
			}
			int max = Integer.MIN_VALUE;
			int max_index = 0;
			int flag = 0;
			for(int i=index+1; i<n; i++) {
				if(list[index][1] < list[i][1]) { //큰값이 나타나면 갱신하고 바로
					max_index = i;
					flag = 1;
					break;
				}
				if(list[i][1] >= max) { //큰값안나타났으면
					max = list[i][1];//맥스값 갱신
					max_index = i;
				}
			}
			result += list[index][1];

			//큰 값 나타남
			if(flag == 1) result += (list[max_index][0] - list[index][0] - 1) * list[index][1];
			//작은 값 나타남
			else result += (list[max_index][0] - list[index][0] - 1) * list[max_index][1];
			
			index = max_index;
		}
		System.out.println(result);
	}
}

