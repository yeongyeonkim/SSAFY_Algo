package list;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_3499_퍼펙트셔플_서울8반_김영연 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/perfectshuffle.txt"));
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			int n = sc.nextInt();
			String[] result = new String[n];
			sc.nextLine();
			String[] info = sc.nextLine().split(" ");
			for (int i = 0; i < n; i++) {
				if (n % 2 == 0) { // n이 짝수개면
					if (i < n / 2) // 중간까지
						result[i * 2] = info[i];
					else
						result[2 * (i - n / 2) + 1] = info[i]; // n-2
				} else { // n이 홀수개면
					if (i <= n / 2) // 중간+1개까지
						result[i * 2] = info[i];
					else
						result[2 * (i - (n / 2 + 1)) + 1] = info[i];
				}
			}
			System.out.print("#" + t);
			for (int i = 0; i < n; i++) {
				System.out.print(" " + result[i]);
			}
			System.out.println();
		}
	}
}
/*
package com.ssafy.algo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String[] temp = new String[N];
            temp = br.readLine().split(" ");
            int c = N%2==0 ? N/2: N/2+1  ;
            System.out.print("#"+tc+" ");
            for(int i=0; i<N; i++) {
                if(i%2==0) 
                    System.out.print(temp[i/2]+" ");
                else 
                    System.out.print(temp[c++]+" ");
            }
            System.out.println();
        }
    }
}
*/