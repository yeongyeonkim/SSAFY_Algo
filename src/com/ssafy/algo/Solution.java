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