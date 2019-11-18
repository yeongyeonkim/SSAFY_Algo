package boj;

import java.util.Scanner;

public class Main_백준_1436_영화감독숌_서울8반_김영연 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = 665;
		while(n > 0) {
			num++;
			String str = Integer.toString(num);
			
			if(str.contains("666")) n--;
		}
		System.out.println(num);
	}
}