package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1183_동전자판기하_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(br.readLine());
		int[] count = new int[6];
		int[] money = {500, 100, 50, 10, 5, 1};
		int number = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++) {
			count[i] = Integer.parseInt(st.nextToken());
			number += count[i] * money[i];
		}
		number -= w;
		for(int i=0; i<6; i++) {
			while(count[i] != 0 && number >= money[i]) {
				number -= money[i];
				count[i]--;
			}
		}
		int result = 0;
		for(int i=0; i<6; i++) 
			result += count[i];
		System.out.println(result);
		for(int i=0; i<6; i++)
			System.out.print(count[i] + " ");
	}
}